package xyz.tcreopargh.ctintegration.scalinghealth;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;
import xyz.tcreopargh.ctintegration.date.IDate;

@ModOnly("scalinghealth")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenRegister
public class PlayerExpansionSH {

    @ZenGetter("difficulty")
    public static double getDifficulty(IPlayer player) {
        return DifficultyManager.getDifficulty(player);
    }

    @ZenSetter("difficulty")
    public static void setDifficulty(IPlayer player, double value) {
        DifficultyManager.setDifficulty(player, value);
    }

    @ZenGetter("lastTimePlayed")
    public static IDate getLastTimePlayed(IPlayer player) {
        return DifficultyManager.getLastTimePlayed(player);
    }

    @ZenGetter("scalingHealthMaxHealth")
    public static float getMaxHealth(IPlayer player) {
        return DifficultyManager.getMaxHealth(player);
    }

    @ZenSetter("scalingHealthMaxHealth")
    public static void setMaxHealth(IPlayer player, float value) {
        DifficultyManager.setMaxHealth(player, value);
    }

    @ZenGetter("areaDifficulty")
    public static double getAreaDifficulty(IPlayer player) {
        return DifficultyManager.getAreaDifficulty(player);
    }
}
