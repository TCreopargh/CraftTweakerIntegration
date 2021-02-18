package xyz.tcreopargh.ctintegration.baubles;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.IterableSimple;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ModOnly("baubles")
@ZenRegister
@IterableSimple("crafttweaker.item.IItemStack")
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "baubles.IBaubleInventory")
public interface IBaublesInventory extends Iterable<IItemStack> {

    Object getInternal();

    @ZenMethod
    boolean isItemValidForSlot(int slot, IItemStack item, IEntityLivingBase living);

    @ZenMethod
    boolean isItemValid(int slot, IItemStack item);

    @ZenMethod
    int getSlotCount();

    @ZenMethod
    IItemStack getStackInSlot(int slot);
}
