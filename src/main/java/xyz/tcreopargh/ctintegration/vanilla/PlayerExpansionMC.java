package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionMC {

    @ZenSetter("xpPoints")
    public static void setXPAmount(IPlayer player, int amount) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        mcPlayer.experienceTotal = amount;
    }

    @ZenGetter("xpPoints")
    public static int getXPAmount(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return mcPlayer.experienceTotal;
    }

    @ZenGetter("bedLocation")
    public static IBlockPos getBedLocation(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return CraftTweakerMC.getIBlockPos(mcPlayer.getBedLocation());
    }

}
