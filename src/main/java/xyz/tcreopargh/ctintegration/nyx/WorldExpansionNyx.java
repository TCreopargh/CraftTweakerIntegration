package xyz.tcreopargh.ctintegration.nyx;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.world.IWorld;
import de.ellpeck.nyx.capabilities.NyxWorld;
import de.ellpeck.nyx.lunarevents.BloodMoon;
import de.ellpeck.nyx.lunarevents.FullMoon;
import de.ellpeck.nyx.lunarevents.HarvestMoon;
import de.ellpeck.nyx.lunarevents.StarShower;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("nyx")
@ZenExpansion("crafttweaker.world.IWorld")
@ZenRegister
public class WorldExpansionNyx {
    @ZenMethod
    public static boolean isBloodMoon(IWorld world) {
        World mcWorld = (World) world.getInternal();
        NyxWorld data = NyxWorld.get(mcWorld);
        return data.currentEvent instanceof BloodMoon;
    }
    @ZenMethod
    public static boolean isStarShower(IWorld world) {
        World mcWorld = (World) world.getInternal();
        NyxWorld data = NyxWorld.get(mcWorld);
        return data.currentEvent instanceof StarShower;
    }
    @ZenMethod
    public static boolean isFullMoon(IWorld world) {
        World mcWorld = (World) world.getInternal();
        NyxWorld data = NyxWorld.get(mcWorld);
        return data.currentEvent instanceof FullMoon;
    }
    @ZenMethod
    public static boolean isHarvestMoon(IWorld world) {
        World mcWorld = (World) world.getInternal();
        NyxWorld data = NyxWorld.get(mcWorld);
        return data.currentEvent instanceof HarvestMoon;
    }
}
