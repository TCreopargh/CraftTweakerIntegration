package xyz.tcreopargh.ctintegration.projecte;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.config.CustomEMCParser;
import moze_intel.projecte.emc.EMCMapper;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.util.List;

@ModOnly("projecte")
@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "projecte.EMCManager")
public class EMCManager {

    @ZenMethod
    public static void mapEMC() {
        long start = System.currentTimeMillis();
        CustomEMCParser.init();
        CraftTweakerAPI.logInfo("Starting server-side EMC mapping.");
        EMCMapper.map();
        CraftTweakerAPI.logInfo("Registered " + EMCMapper.emc.size() + " EMC values. (took " + (System.currentTimeMillis() - start) + " ms)");
    }

    @ZenMethod
    public static long getEMC(IItemStack item) {
        ItemStack stack = (ItemStack) item.getInternal();
        return ProjectEAPI.getEMCProxy().getValue(stack);
    }

    @ZenMethod
    public static long getEMCSellValue(IItemStack item) {
        ItemStack stack = (ItemStack) item.getInternal();
        return ProjectEAPI.getEMCProxy().getSellValue(stack);
    }

    @ZenMethod
    public static boolean isEMCSet(IItemStack item) {
        ItemStack stack = (ItemStack) item.getInternal();
        return ProjectEAPI.getEMCProxy().hasValue(stack);
    }

    @ZenMethod
    public static void setEMC(IItemStack item, long value) {
        ItemStack stack = (ItemStack) item.getInternal();
        ProjectEAPI.getEMCProxy().registerCustomEMC(stack, value);
    }

    @ZenMethod
    public static void setEMC(IIngredient ingredient, long value) {
        List<IItemStack> items = ingredient.getItems();
        for (IItemStack item : items) {
            ItemStack stack = (ItemStack) item.getInternal();
            ProjectEAPI.getEMCProxy().registerCustomEMC(stack, value);
        }
    }
}
