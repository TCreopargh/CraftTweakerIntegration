package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.modutil.XPUtil;

import java.util.Objects;

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
        addExperience(player, -amount);
    }

    @ZenGetter("experience")
    public static int getExperience(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return XPUtil.getPlayerXP(mcPlayer);
    }

    @ZenMethod
    public static int getTotalXP(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return mcPlayer.experienceTotal;
    }

    @ZenMethod
    public static void playSound(IPlayer player, String soundResourceLocation, float volume, float pitch) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        mcPlayer.playSound(Objects.requireNonNull(SoundEvent.REGISTRY.getObject(
                new ResourceLocation(soundResourceLocation))), volume, pitch
        );
    }
}
