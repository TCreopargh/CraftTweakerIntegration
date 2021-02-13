package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionMC {

    @ZenMethod
    public static void addExperience(IPlayer player, int amount) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        mcPlayer.addExperience(amount);
    }

    @ZenMethod
    public static void removeExperience(IPlayer player, int amount) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        if (mcPlayer.experience > amount && mcPlayer.experienceLevel > 0) {
            mcPlayer.experienceTotal = mcPlayer.experienceTotal - amount;
            mcPlayer.experience -= 1f / mcPlayer.xpBarCap();
        } else if (mcPlayer.experienceLevel > 0) {
            mcPlayer.experienceTotal = mcPlayer.experienceTotal - amount;
            mcPlayer.experienceLevel--;
            mcPlayer.experience = (float) (mcPlayer.xpBarCap() - 1) / mcPlayer.xpBarCap();
            if (mcPlayer.experienceLevel == 0) {
                mcPlayer.experience = 0;
            }
        }
    }

    @ZenMethod
    public static int getTotalXP(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return mcPlayer.experienceTotal;
    }
}
