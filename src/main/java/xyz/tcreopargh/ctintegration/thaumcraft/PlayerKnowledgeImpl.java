package xyz.tcreopargh.ctintegration.thaumcraft;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerKnowledgeImpl implements IPlayerKnowledge {

    thaumcraft.api.capabilities.IPlayerKnowledge internal;

    public PlayerKnowledgeImpl(thaumcraft.api.capabilities.IPlayerKnowledge knowledge) {
        this.internal = knowledge;
    }

    @Override
    public Object getInternal() {
        return internal;
    }

    @Override
    public void clear() {
        internal.clear();
    }

    @Override
    public String getResearchStatus(String research) {
        return internal.getResearchStatus(research).name();
    }

    @Override
    public boolean isResearchComplete(String research) {
        return internal.isResearchComplete(research);
    }

    @Override
    public boolean isResearchKnown(String research) {
        return internal.isResearchKnown(research);
    }

    @Override
    public int getResearchStage(String research) {
        return internal.getResearchStage(research);
    }

    @Override
    public boolean addResearch(String research) {
        return internal.addResearch(research);
    }

    @Override
    public boolean setResearchStage(String research, int stage) {
        return internal.setResearchStage(research, stage);
    }

    @Override
    public boolean removeResearch(String research) {
        return internal.removeResearch(research);
    }

    @Override
    public String[] getResearchList() {
        return internal.getResearchList().toArray(new String[0]);
    }

    @Override
    public boolean setResearchFlag(String research, String researchFlag) {
        return internal.setResearchFlag(research, thaumcraft.api.capabilities.IPlayerKnowledge.EnumResearchFlag.valueOf(researchFlag));
    }

    @Override
    public boolean clearResearchFlag(String research, String researchFlag) {
        return internal.clearResearchFlag(research, thaumcraft.api.capabilities.IPlayerKnowledge.EnumResearchFlag.valueOf(researchFlag));
    }

    @Override
    public boolean hasResearchFlag(String research, String researchFlag) {
        return internal.hasResearchFlag(research, thaumcraft.api.capabilities.IPlayerKnowledge.EnumResearchFlag.valueOf(researchFlag));
    }

    @Override
    public void sync(IPlayer player) {
        if (CraftTweakerMC.getPlayer(player) instanceof EntityPlayerMP) {
            internal.sync((EntityPlayerMP) CraftTweakerMC.getPlayer(player));
        } else {
            CraftTweakerAPI.logError("Player is not an instance of EntityPlayerMP");
        }
    }
}
