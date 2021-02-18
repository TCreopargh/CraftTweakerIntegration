package xyz.tcreopargh.ctintegration.cot;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import net.minecraftforge.fml.common.Loader;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ModOnly("contenttweaker")
@ZenExpansion("mods.contenttweaker.VanillaFactory")
@ZenRegister
public class BaubleVanillaFactoryExpansion {
    @ZenMethodStatic
    public static BaubleItemRepresentation createBaubleItem(String unlocalizedName) {
        if(Loader.isModLoaded("baubles")) {
            return new BaubleItemRepresentation(unlocalizedName);
        } else {
            CraftTweakerAPI.logError("You can only create a bauble item when Baubles mod is loaded!");
            return null;
        }
    }
}
