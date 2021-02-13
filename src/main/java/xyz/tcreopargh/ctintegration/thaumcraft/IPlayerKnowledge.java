package xyz.tcreopargh.ctintegration.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "thaumcraft.IPlayerKnowledge")
@ModOnly("thaumcraft")
@ZenRegister
public interface IPlayerKnowledge {

    Object getInternal();

    @ZenMethod
    void clear();

    @ZenMethod
    String getResearchStatus(String research);

    @ZenMethod
    boolean isResearchComplete(String research);

    @ZenMethod
    boolean isResearchKnown(String research);

    @ZenMethod
    int getResearchStage(String research);

    @ZenMethod
    boolean addResearch(String research);

    @ZenMethod
    boolean setResearchStage(String research, int stage);

    @ZenMethod
    boolean removeResearch(String research);

    @ZenMethod
    String[] getResearchList();

    @ZenMethod
    boolean setResearchFlag(String research, String researchFlag);

    @ZenMethod
    boolean clearResearchFlag(String research, String researchFlag);

    @ZenMethod
    boolean hasResearchFlag(String research, String researchFlag);

    @ZenMethod
    void sync(IPlayer player);
}
