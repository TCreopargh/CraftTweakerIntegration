package xyz.tcreopargh.ctintegration.scalinghealth;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.silentchaos512.scalinghealth.config.Config;
import net.silentchaos512.scalinghealth.utils.SHPlayerDataHandler;
import net.silentchaos512.scalinghealth.world.ScalingHealthSavedData;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;
import xyz.tcreopargh.ctintegration.date.IDate;
import xyz.tcreopargh.ctintegration.date.ImplDate;

import java.util.Objects;

@ModOnly("scalinghealth")
@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "scalinghealth.DifficultyManager")
public class DifficultyManager {

    @ZenMethod
    public static void setDifficulty(IPlayer player, double value) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).setDifficulty(value);
        } else {
            CraftTweakerAPI.logInfo("cannot set difficulty because the player's scaling health data is null");
        }
    }

    @ZenMethod
    public static void addDifficulty(IPlayer player, double value) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).incrementDifficulty(value);
        } else {
            CraftTweakerAPI.logInfo("cannot add difficulty because the player's scaling health data is null");
        }
    }

    @ZenMethod
    public static void addDifficulty(IPlayer player, double value, boolean affectWorldDifficulty) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).incrementDifficulty(value, affectWorldDifficulty);
        } else {
            CraftTweakerAPI.logInfo("cannot add difficulty because the player's scaling health data is null");
        }
    }

    @ZenMethod
    public static double getDifficulty(IPlayer player) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        double val = Double.NaN;
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            val = Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).getDifficulty();
        } else {
            CraftTweakerAPI.logInfo("cannot get difficulty because the player's scaling health data is null");
        }
        return val;
    }

    @ZenMethod
    public static double getWorldDifficulty(IWorld world) {
        World mcWorld = (World) world.getInternal();
        ScalingHealthSavedData data = ScalingHealthSavedData.get(mcWorld);
        return data.difficulty;
    }

    @ZenMethod
    public static void setWorldDifficulty(IWorld world, double value) {
        World mcWorld = (World) world.getInternal();
        ScalingHealthSavedData data = ScalingHealthSavedData.get(mcWorld);
        data.difficulty = value;
    }

    @ZenMethod
    public static void addWorldDifficulty(IWorld world, double value) {
        World mcWorld = (World) world.getInternal();
        ScalingHealthSavedData data = ScalingHealthSavedData.get(mcWorld);
        data.difficulty += value;
    }

    @ZenMethod
    public static IDate getLastTimePlayed(IPlayer player) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            return new ImplDate(Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).getLastTimePlayed());
        } else {
            CraftTweakerAPI.logInfo("cannot get last time played because the player's scaling health data is null");
        }
        return null;
    }

    @ZenMethod
    public static float getMaxHealth(IPlayer player) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            return Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).getMaxHealth();
        } else {
            CraftTweakerAPI.logInfo("cannot get max health because the player's scaling health data is null");
        }
        return Float.NaN;
    }

    @ZenMethod
    public static void setMaxHealth(IPlayer player, float value) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).setMaxHealth(value);
        } else {
            CraftTweakerAPI.logInfo("cannot set max health because the player's scaling health data is null");
        }
    }

    @ZenMethod
    public static void addMaxHealth(IPlayer player, float value) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        if (SHPlayerDataHandler.get(entPlayer) != null) {
            Objects.requireNonNull(SHPlayerDataHandler.get(entPlayer)).incrementMaxHealth(value);
        } else {
            CraftTweakerAPI.logInfo("cannot add max health because the player's scaling health data is null");
        }
    }

    @ZenMethod
    public static double getAreaDifficulty(IPlayer player) {
        EntityPlayer entPlayer = (EntityPlayer) player.getInternal();
        return Config.Difficulty.AREA_DIFFICULTY_MODE.getAreaDifficulty(entPlayer.world, entPlayer.getPosition());
    }

    @ZenMethod
    public static double getAreaDifficulty(IWorld world, IBlockPos pos) {
        World mcWorld = (World) world.getInternal();
        BlockPos mcBlockPos = (BlockPos) pos.getInternal();
        return Config.Difficulty.AREA_DIFFICULTY_MODE.getAreaDifficulty(mcWorld, mcBlockPos);
    }
}
