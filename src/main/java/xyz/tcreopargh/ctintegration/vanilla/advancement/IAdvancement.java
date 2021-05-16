package xyz.tcreopargh.ctintegration.vanilla.advancement;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.text.ITextComponent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.util.List;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "advancement.IAdvancement")
public interface IAdvancement {

    Object getInternal();

    @ZenGetter("id")
    String getId();

    @ZenGetter("displayText")
    ITextComponent getDisplayText();

    @ZenGetter("title")
    ITextComponent getTitle();

    @ZenGetter("description")
    ITextComponent getDescription();

    @ZenGetter("requirements")
    String[][] getRequirements();

    @ZenGetter("requirementCount")
    int getRequirementCount();

    @ZenGetter("children")
    List<IAdvancement> getChildren();

    @ZenGetter("criterion")
    List<String> getCriterion();

    @ZenGetter("parent")
    IAdvancement getParent();

    @ZenMethod
    void applyRewards(IPlayer player);
}
