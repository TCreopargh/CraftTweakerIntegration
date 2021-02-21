package xyz.tcreopargh.ctintegration.cot;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "cot.baubles.BaubleItemRepresentation")
public class BaubleItemRepresentation extends ItemRepresentation {

    @ZenProperty
    public String baubleType;

    @ZenProperty
    public BaubleEventHandler.CanEquip canEquip;
    @ZenProperty
    public BaubleEventHandler.canUnequip canUnequip;
    @ZenProperty
    public BaubleEventHandler.OnWornTick onWornTick;
    @ZenProperty
    public BaubleEventHandler.OnEquipped onEquipped;
    @ZenProperty
    public BaubleEventHandler.OnUnequipped onUnequipped;
    @ZenProperty
    public BaubleEventHandler.WillAutoSync willAutoSync;
    @ZenProperty
    public BaubleEventHandler.GetBaubleType getBaubleType;

    public BaubleItemRepresentation(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new BaubleItemContent(this));
    }
}
