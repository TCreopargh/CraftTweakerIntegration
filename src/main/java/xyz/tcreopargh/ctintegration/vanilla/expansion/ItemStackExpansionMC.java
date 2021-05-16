package xyz.tcreopargh.ctintegration.vanilla.expansion;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import stanhebben.zenscript.annotations.*;
import xyz.tcreopargh.ctintegration.forge.EnergyStorageImpl;

@ZenExpansion("crafttweaker.item.IItemStack")
@ZenRegister
public class ItemStackExpansionMC {
    @ZenMethod
    @ZenCaster
    public static IData asData(IItemStack itemStack) {
        ItemStack mcItemStack = CraftTweakerMC.getItemStack(itemStack);
        NBTTagCompound tagCompound = mcItemStack.serializeNBT();
        return CraftTweakerMC.getIData(tagCompound);
    }

    @ZenMethodStatic
    public static IItemStack fromData(IData data) {
        return CraftTweakerMC.getIItemStack(new ItemStack(CraftTweakerMC.getNBTCompound(data)));
    }

    @ZenGetter("energy")
    public static xyz.tcreopargh.ctintegration.forge.IEnergyStorage getEnergy(IItemStack itemStack) {
        ItemStack mcItemStack = CraftTweakerMC.getItemStack(itemStack);
        IEnergyStorage storage = mcItemStack.getCapability(CapabilityEnergy.ENERGY, null);
        return new EnergyStorageImpl(storage);
    }

    @ZenMethod
    public static boolean isEnergyStorage(IItemStack itemStack) {
        ItemStack mcItemStack = CraftTweakerMC.getItemStack(itemStack);
        return mcItemStack.hasCapability(CapabilityEnergy.ENERGY, null);
    }
}
