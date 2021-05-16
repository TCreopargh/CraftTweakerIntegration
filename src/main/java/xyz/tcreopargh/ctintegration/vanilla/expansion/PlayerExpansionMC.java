package xyz.tcreopargh.ctintegration.vanilla.expansion;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.util.Position3f;
import net.minecraft.advancements.Advancement;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.modutil.XPUtil;
import xyz.tcreopargh.ctintegration.vanilla.advancement.AdvancementProgressImpl;
import xyz.tcreopargh.ctintegration.vanilla.advancement.IAdvancement;
import xyz.tcreopargh.ctintegration.vanilla.advancement.IAdvancementProgress;

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

    @ZenMethod
    public static void sendPlaySoundPacket(IPlayer player, String soundResourceLocation, String soundCategory, Position3f pos, float volume, float pitch) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        if (mcPlayer instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) mcPlayer;
            SoundCategory category = SoundCategory.getByName(soundCategory);
            if(category != null) {
                entityPlayerMP.connection.sendPacket(
                        new SPacketCustomSound(soundResourceLocation, category,
                                pos.getX(), pos.getY(), pos.getZ(), volume, pitch));
            } else {
                CraftTweakerAPI.logWarning("Failed to send play sound packet. soundCategory is invalid.");
            }
        } else {
            CraftTweakerAPI.logInfo("Failed to send play sound packet. Player is not an instance of EntityPlayerMP");
        }
    }

    @ZenMethod
    public static boolean isPlayerMP(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return mcPlayer instanceof EntityPlayerMP;
    }

    @ZenMethod
    public static IAdvancementProgress getAdvancementProgress(IPlayer player, IAdvancement advancement) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        Advancement mcAdvancement = (Advancement) advancement.getInternal();
        if (mcPlayer instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) mcPlayer;
            return new AdvancementProgressImpl(entityPlayerMP.getAdvancements().getProgress(mcAdvancement));
        } else {
            return null;
        }
    }
}
