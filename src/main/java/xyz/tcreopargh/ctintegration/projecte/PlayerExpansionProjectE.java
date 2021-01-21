package xyz.tcreopargh.ctintegration.projecte;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.player.IPlayer;
import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.capabilities.IKnowledgeProvider;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ModOnly("projecte")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionProjectE {

    @ZenGetter("personalEMC")
    public static long getPersonalEMC(IPlayer player) {
        EntityPlayer mcPlayer = (EntityPlayer) player.getInternal();
        IKnowledgeProvider iKnowledgeProvider = mcPlayer.getCapability(ProjectEAPI.KNOWLEDGE_CAPABILITY, null);
        if (iKnowledgeProvider == null) {
            return 0;
        }
        return iKnowledgeProvider.getEmc();
    }

    @ZenSetter("personalEMC")
    public static void setPersonalEMC(IPlayer player, long emc) {
        EntityPlayer mcPlayer = (EntityPlayer) player.getInternal();
        IKnowledgeProvider iKnowledgeProvider = mcPlayer.getCapability(ProjectEAPI.KNOWLEDGE_CAPABILITY, null);
        if (iKnowledgeProvider != null) {
            iKnowledgeProvider.setEmc(emc);
        }
    }
}
