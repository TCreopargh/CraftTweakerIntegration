package xyz.tcreopargh.ctintegration.util;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.recipes.IRecipeAction;
import crafttweaker.api.recipes.IRecipeFunction;
import crafttweaker.mc1120.CraftTweaker;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "util.RecipePattern")
@ZenRegister
public class RecipePattern {
    private final List<String> pattern;
    private final Map<Character, IIngredient> mapping = new HashMap<>();
    private boolean isMirrored = false;
    private boolean isShapeless = false;
    private String name;
    private IItemStack output;
    private IRecipeFunction recipeFunction;
    private IRecipeAction recipeAction;

    public RecipePattern(List<String> pattern) {
        this.pattern = pattern;
    }

    public RecipePattern(IItemStack output, List<String> pattern) {
        this.pattern = pattern;
        this.output = output;
    }

    public RecipePattern(String name, IItemStack output, List<String> pattern) {
        this.pattern = pattern;
        this.output = output;
        this.name = name;
    }

    @ZenMethod
    public static RecipePattern init(List<String> recipePattern) {
        return new RecipePattern(recipePattern);
    }

    public static IIngredient[][] listToArray2D(List<List<IIngredient>> arrayList) {
        IIngredient[][] array = new IIngredient[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            List<IIngredient> row = arrayList.get(i);
            array[i] = row.toArray(new IIngredient[0]);
        }
        return array;
    }

    @ZenMethod
    public static RecipePattern init(IItemStack output, List<String> recipePattern) {
        return new RecipePattern(output, recipePattern);
    }

    @ZenMethod
    public static RecipePattern init(String name, IItemStack output, List<String> recipePattern) {
        return new RecipePattern(name, output, recipePattern);
    }

    @ZenMethod
    public RecipePattern with(String character, IIngredient ingredient) {
        if (character.length() != 1) {
            CraftTweakerAPI.logError("Mapping key must be one single character", new IllegalArgumentException());
        } else {
            char firstChar = character.charAt(0);
            if (Character.isWhitespace(firstChar)) {
                CraftTweakerAPI.logError("You can't map a whitespace character!", new IllegalArgumentException());
            } else {
                mapping.put(firstChar, ingredient);
            }
        }
        return this;
    }

    @ZenMethod
    public RecipePattern withOutput(IItemStack output) {
        this.output = output;
        return this;
    }

    @ZenMethod
    public RecipePattern and(String character, IIngredient ingredient) {
        return this.with(character, ingredient);
    }

    @ZenMethod
    public RecipePattern setMirrored(boolean isMirrored) {
        this.isMirrored = isMirrored;
        return this;
    }

    @ZenMethod
    public RecipePattern setName(String name) {
        this.name = name;
        return this;
    }

    @ZenMethod
    public RecipePattern setShapeless(boolean isShapeless) {
        this.isShapeless = isShapeless;
        return this;
    }

    @ZenMethod
    public RecipePattern setFunction(IRecipeFunction function) {
        this.recipeFunction = function;
        return this;
    }

    @ZenMethod
    public RecipePattern setAction(IRecipeAction action) {
        this.recipeAction = action;
        return this;
    }


    @ZenGetter("ingredients")
    public IIngredient[][] getIngredients() {
        List<List<IIngredient>> grid = new ArrayList<>();
        for (String rowString : pattern) {
            List<IIngredient> row = new ArrayList<>();
            for (char ch : rowString.toCharArray()) {
                if (Character.isWhitespace(ch)) {
                    row.add(null);
                } else {
                    if (mapping.containsKey(ch)) {
                        row.add(mapping.get(ch));
                    } else {
                        CraftTweakerAPI.logWarning("Cannot find matching ingredient for character '" + ch + "', using null instead.");
                    }
                }
            }
            grid.add(row);
        }
        return listToArray2D(grid);
    }

    @ZenGetter("shapelessIngredients")
    public IIngredient[] getShapelessIngredients() {
        IIngredient[][] grid = getIngredients();
        List<IIngredient> shapelessRecipeList = new ArrayList<>();
        for (IIngredient[] row : grid) {
            for (IIngredient ingredient : row) {
                if (ingredient != null) {
                    shapelessRecipeList.add(ingredient);
                }
            }
        }
        return shapelessRecipeList.toArray(new IIngredient[0]);
    }

    @ZenMethod
    public RecipePattern map(Map<String, IIngredient> mapping) {
        for (Map.Entry<String, IIngredient> entry : mapping.entrySet()) {
            this.with(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @ZenMethod
    public void build() {
        IIngredient[][] grid = getIngredients();

        if (grid.length == 0) {
            CraftTweakerAPI.logError("The pattern is empty", new IllegalArgumentException());
            return;
        }

        if (isShapeless) {
            IIngredient[] shapelessRecipe = getShapelessIngredients();
            if (name == null) {
                CraftTweaker.INSTANCE.recipes.addShapeless(output, shapelessRecipe, recipeFunction, recipeAction);
            } else {
                CraftTweaker.INSTANCE.recipes.addShapeless(name, output, shapelessRecipe, recipeFunction, recipeAction);
            }
        } else if (isMirrored) {
            if (name == null) {
                CraftTweaker.INSTANCE.recipes.addShapedMirrored(output, grid, recipeFunction, recipeAction);
            } else {
                CraftTweaker.INSTANCE.recipes.addShapedMirrored(name, output, grid, recipeFunction, recipeAction);
            }
        } else {
            if (name == null) {
                CraftTweaker.INSTANCE.recipes.addShaped(output, grid, recipeFunction, recipeAction);
            } else {
                CraftTweaker.INSTANCE.recipes.addShaped(name, output, grid, recipeFunction, recipeAction);
            }
        }
    }
}

