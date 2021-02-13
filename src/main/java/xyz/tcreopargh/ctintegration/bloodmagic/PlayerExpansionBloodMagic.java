package xyz.tcreopargh.ctintegration.bloodmagic;

import WayofTime.bloodmagic.util.helper.NetworkHelper;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenExpansion("crafttweaker.player.IPlayer")
@ModOnly("bloodmagic")
@ZenRegister
public class PlayerExpansionBloodMagic {
    @ZenGetter("soulNetwork")
    public static SoulNetwork getSoulNetwork(IPlayer player) {
        return new SoulNetwork(NetworkHelper.getSoulNetwork(CraftTweakerMC.getPlayer(player)));
    }
}
