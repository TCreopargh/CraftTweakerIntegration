package xyz.tcreopargh.ctintegration.cot;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

public class BaubleEventHandler {
    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.WornTick")
    public interface OnWornTick {
        void handle(IItemStack bauble, IEntityLivingBase player);
    }

    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.Equipped")
    public interface OnEquipped {
        void handle(IItemStack bauble, IEntityLivingBase player);
    }

    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.Unequipped")
    public interface OnUnequipped {
        void handle(IItemStack bauble, IEntityLivingBase player);
    }

    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.CanEquip")
    public interface CanEquip {
        boolean handle(IItemStack bauble, IEntityLivingBase player);
    }

    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.CanUnEquip")
    public interface CanUnequip {
        boolean handle(IItemStack bauble, IEntityLivingBase player);
    }

    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.WillAutoSync")
    public interface WillAutoSync {
        boolean handle(IItemStack bauble, IEntityLivingBase player);
    }

    @ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.GetBaubleType")
    public interface GetBaubleType {
        String handle(IItemStack bauble);
    }
}
