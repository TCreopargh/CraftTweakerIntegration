package xyz.tcreopargh.ctintegration.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;
import thaumcraft.api.capabilities.IPlayerWarp;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;

@ZenExpansion("crafttweaker.player.IPlayer")
@ModOnly("thaumcraft")
@ZenRegister
public class PlayerExpansionThaumcraft {
    @ZenGetter("warpNormal")
    public static int getWarpNormal(IPlayer player) {
        return ThaumcraftCapabilities.getWarp(CraftTweakerMC.getPlayer(player)).get(IPlayerWarp.EnumWarpType.NORMAL);
    }

    @ZenSetter("warpNormal")
    public static void setWarpNormal(IPlayer player, int amount) {
        ThaumcraftCapabilities.getWarp(CraftTweakerMC.getPlayer(player)).set(IPlayerWarp.EnumWarpType.NORMAL, amount);
    }

    @ZenGetter("warpPermanent")
    public static int getWarpPermanent(IPlayer player) {
        return ThaumcraftCapabilities.getWarp(CraftTweakerMC.getPlayer(player)).get(IPlayerWarp.EnumWarpType.PERMANENT);
    }

    @ZenSetter("warpPermanent")
    public static void setWarpPermanent(IPlayer player, int amount) {
        ThaumcraftCapabilities.getWarp(CraftTweakerMC.getPlayer(player)).set(IPlayerWarp.EnumWarpType.PERMANENT, amount);
    }

    @ZenGetter("warpTemporary")
    public static int getWarpTemporary(IPlayer player) {
        return ThaumcraftCapabilities.getWarp(CraftTweakerMC.getPlayer(player)).get(IPlayerWarp.EnumWarpType.TEMPORARY);
    }

    @ZenSetter("warpTemporary")
    public static void setWarpTemporary(IPlayer player, int amount) {
        ThaumcraftCapabilities.getWarp(CraftTweakerMC.getPlayer(player)).set(IPlayerWarp.EnumWarpType.TEMPORARY, amount);
    }

    @ZenGetter("thaumcraftKnowledge")
    public static IPlayerKnowledge getThaumcraftKnowledge(IPlayer player) {
        return new ImplPlayerKnowledge(ThaumcraftCapabilities.getKnowledge(CraftTweakerMC.getPlayer(player)));
    }
}
