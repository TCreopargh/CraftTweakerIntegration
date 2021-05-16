package xyz.tcreopargh.ctintegration.vanilla.expansion;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.util.Position3f;
import crafttweaker.api.world.IWorld;
import net.minecraft.advancements.Advancement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Objects;

@ZenExpansion("crafttweaker.world.IWorld")
@ZenRegister
public class WorldExpansionMC {

    @ZenMethod
    public static void setOrCreateGameRule(IWorld world, String key, String value) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        mcWorld.getGameRules().setOrCreateGameRule(key, value);
    }

    @ZenMethod
    public static void playSound(IWorld world, String soundResourceLocation, String soundCategory, Position3f location, float volume, float pitch, @Optional boolean distanceDelay) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        mcWorld.playSound(location.getX(), location.getY(), location.getZ(),
                Objects.requireNonNull(SoundEvent.REGISTRY.getObject(
                        new ResourceLocation(soundResourceLocation))),
                SoundCategory.getByName(soundCategory),
                volume, pitch, distanceDelay);
    }
}
