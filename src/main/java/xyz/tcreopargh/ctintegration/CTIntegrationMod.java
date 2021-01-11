package xyz.tcreopargh.ctintegration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
    public static final String VERSION = "1.2.1";

    /** This is the instance of your mod as created by Forge. It will never be null. */
    @Mod.Instance(MOD_ID)
    public static CTIntegrationMod INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

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
