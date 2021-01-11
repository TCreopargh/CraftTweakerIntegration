package xyz.tcreopargh.ctintegration.sereneseasons;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.world.IWorld;
import net.minecraft.world.World;
import sereneseasons.api.season.SeasonHelper;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;

@ModOnly("sereneseasons")
@ZenExpansion("crafttweaker.world.IWorld")
@ZenRegister
public class WorldExpansion {
    @ZenGetter("seasonState")
    public static ISeasonState getSeasonState(IWorld world) {
        World mcWorld = (World) world.getInternal();
        sereneseasons.api.season.ISeasonState state = SeasonHelper.getSeasonState(mcWorld);
        return new ImplSeasonState(state);
    }
}
