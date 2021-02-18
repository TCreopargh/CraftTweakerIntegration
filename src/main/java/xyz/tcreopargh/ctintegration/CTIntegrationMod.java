package xyz.tcreopargh.ctintegration;

import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.api.ContentTweakerAPI;
import crafttweaker.CraftTweakerAPI;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.tcreopargh.ctintegration.cot.BaubleEventHandler;
import xyz.tcreopargh.ctintegration.cot.BaubleItemRepresentation;
import xyz.tcreopargh.ctintegration.cot.BaubleVanillaFactoryExpansion;
import xyz.tcreopargh.ctintegration.gamestages.events.EventsExpansion;

@Mod(
        modid = CTIntegrationMod.MOD_ID,
        name = CTIntegrationMod.MOD_NAME,
        version = CTIntegrationMod.VERSION,
        dependencies = "required-after:crafttweaker"
)
public class CTIntegrationMod {

    public static final String CT_NAMESPACE = "mods.ctintegration.";
    public static final String MOD_ID = "ctintegration";
    public static final String MOD_NAME = "CraftTweaker Integration";
    public static final String VERSION = "1.6.0";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static CTIntegrationMod INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        if (Loader.isModLoaded("gamestages")) {
            MinecraftForge.EVENT_BUS.register(EventsExpansion.EventHandler.class);
        }
        if (Loader.isModLoaded("contenttweaker") && Loader.isModLoaded("baubles")) {
            CraftTweakerAPI.registerClass(BaubleItemRepresentation.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.GetBaubleType.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.OnWornTick.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.CanEquip.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.CanUnequip.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.OnEquipped.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.OnUnequipped.class);
            CraftTweakerAPI.registerClass(BaubleEventHandler.WillAutoSync.class);
        }
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }
}
