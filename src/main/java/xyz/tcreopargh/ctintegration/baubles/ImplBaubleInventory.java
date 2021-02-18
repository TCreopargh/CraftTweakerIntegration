package xyz.tcreopargh.ctintegration.baubles;

import baubles.api.cap.IBaublesItemHandler;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImplBaubleInventory implements IBaublesInventory {

    private final IBaublesItemHandler internal;

    public ImplBaubleInventory(IBaublesItemHandler handler) {
        this.internal = handler;
    }

    @Override
    public IBaublesItemHandler getInternal() {
        return internal;
    }

    @Override
    public boolean isItemValidForSlot(int slot, IItemStack item, IEntityLivingBase living) {
        EntityLivingBase mcLiving = CraftTweakerMC.getEntityLivingBase(living);
        ItemStack mcItemStack = CraftTweakerMC.getItemStack(item);
        return internal.isItemValidForSlot(slot, mcItemStack, mcLiving);
    }

    @Override
    public boolean isItemValid(int slot, IItemStack item) {
        ItemStack mcItemStack = CraftTweakerMC.getItemStack(item);
        return internal.isItemValid(slot, mcItemStack);
    }

    @Override
    public int getSlotCount() {
        return internal.getSlots();
    }

    @Override
    public IItemStack getStackInSlot(int slot) {
        return CraftTweakerMC.getIItemStack(internal.getStackInSlot(slot));
    }

    @Nonnull
    @Override
    public Iterator<IItemStack> iterator() {
        List<IItemStack> stacks = new ArrayList<>();
        for (int i = 0; i < internal.getSlots(); i++) {
            stacks.add(CraftTweakerMC.getIItemStack(internal.getStackInSlot(i)));
        }
        return stacks.stream().iterator();
    }
}
