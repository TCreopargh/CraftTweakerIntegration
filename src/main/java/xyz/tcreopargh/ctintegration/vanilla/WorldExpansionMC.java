package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IWorld;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.world.IWorld")
@ZenRegister
public class WorldExpansionMC {

    @ZenMethod
    public static void setOrCreateGameRule(IWorld world, String key, String value) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        mcWorld.getGameRules().setOrCreateGameRule(key, value);
    }
}
