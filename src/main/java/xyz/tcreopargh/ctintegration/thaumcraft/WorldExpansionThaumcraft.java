package xyz.tcreopargh.ctintegration.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.common.world.aura.AuraHandler;

@ZenExpansion("crafttweaker.world.IWorld")
@ModOnly("thaumcraft")
@ZenRegister
public class WorldExpansionThaumcraft {
    @ZenMethod
    public static void addVis(IWorld world, IBlockPos pos, float amount) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        AuraHandler.addVis(mcWorld, mcBlockPos, amount);
    }

    @ZenMethod
    public static void addFlux(IWorld world, IBlockPos pos, float amount) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        AuraHandler.addFlux(mcWorld, mcBlockPos, amount);
    }

    @ZenMethod
    public static void drainVis(IWorld world, IBlockPos pos, float amount, @Optional boolean simulate) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        AuraHandler.drainVis(mcWorld, mcBlockPos, amount, simulate);
    }

    @ZenMethod
    public static void drainFlux(IWorld world, IBlockPos pos, float amount, @Optional boolean simulate) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        AuraHandler.drainFlux(mcWorld, mcBlockPos, amount, simulate);
    }

    @ZenMethod
    public static float getVis(IWorld world, IBlockPos pos) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        return AuraHandler.getVis(mcWorld, mcBlockPos);
    }

    @ZenMethod
    public static float getFlux(IWorld world, IBlockPos pos) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        return AuraHandler.getFlux(mcWorld, mcBlockPos);
    }

    @ZenMethod
    public static float getAuraBase(IWorld world, IBlockPos pos) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        return AuraHandler.getAuraBase(mcWorld, mcBlockPos);
    }

    @ZenMethod
    public static float getTotalAura(IWorld world, IBlockPos pos) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        return AuraHandler.getTotalAura(mcWorld, mcBlockPos);
    }

    @ZenMethod
    public static void addAura(IWorld world, IBlockPos pos, short base, float vis, float flux) {
        World mcWorld = CraftTweakerMC.getWorld(world);
        BlockPos mcBlockPos = CraftTweakerMC.getBlockPos(pos);
        AuraHandler.addAuraChunk(world.getDimension(), mcWorld.getChunk(mcBlockPos), base, vis, flux);
    }
}
