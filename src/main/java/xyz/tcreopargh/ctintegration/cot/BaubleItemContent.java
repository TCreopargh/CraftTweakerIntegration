package xyz.tcreopargh.ctintegration.cot;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemContent;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class BaubleItemContent extends ItemContent implements IBauble {

    private final BaubleType baubleType;

    private final BaubleEventHandler.CanEquip canEquip;
    private final BaubleEventHandler.canUnequip canUneuip;
    private final BaubleEventHandler.OnWornTick onWornTick;
    private final BaubleEventHandler.OnEquipped onEquipped;
    private final BaubleEventHandler.OnUnequipped onUnequipped;
    private final BaubleEventHandler.WillAutoSync willAutoSync;
    private final BaubleEventHandler.GetBaubleType getBaubleType;

    public BaubleItemContent(BaubleItemRepresentation itemRepresentation) {
        super(itemRepresentation);
        this.baubleType = BaubleType.valueOf(itemRepresentation.baubleType);
        this.canEquip = itemRepresentation.canEquip;
        this.canUneuip = itemRepresentation.canUnequip;
        this.onWornTick = itemRepresentation.onWornTick;
        this.onEquipped = itemRepresentation.onEquipped;
        this.onUnequipped = itemRepresentation.onUnequipped;
        this.willAutoSync = itemRepresentation.willAutoSync;
        this.getBaubleType = itemRepresentation.getBaubleType;
        maxStackSize = 1;
    }

    @Override
    public void onWornTick(ItemStack baubleItem, EntityLivingBase wearer) {
        if (onWornTick != null) {
            onWornTick.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public void onEquipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (onEquipped != null) {
            onEquipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }

    }

    @Override
    public void onUnequipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (onUnequipped != null) {
            onUnequipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }

    }

    @Override
    public boolean canEquip(ItemStack baubleItem, EntityLivingBase wearer) {
        if (canEquip != null) {
            return canEquip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack baubleItem, EntityLivingBase wearer) {
        if (canUneuip != null) {
            return canUneuip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return true;
    }

    @Override
    public boolean willAutoSync(ItemStack baubleItem, EntityLivingBase wearer) {
        if (willAutoSync != null) {
            return willAutoSync.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return false;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        if (getBaubleType != null) {
            return BaubleType.valueOf(getBaubleType.handle(CraftTweakerMC.getIItemStack(itemStack)));
        } else if (baubleType != null) {
            return baubleType;
        }
        return BaubleType.TRINKET;
    }
}
