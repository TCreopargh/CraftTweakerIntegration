package xyz.tcreopargh.ctintegration.projecte;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ModOnly("projecte")
@ZenExpansion("crafttweaker.item.IItemStack")
@ZenRegister
public class IItemStackExpansion {

    @ZenGetter("emc")
    public static long getEMC(IItemStack itemStack) {
        return EMCManager.getEMC(itemStack);
    }

    @ZenSetter("emc")
    public static void setEMC(IItemStack itemStack, long value) {
        EMCManager.setEMC(itemStack, value);
    }

    @ZenGetter("emcSellValue")
    public static long getEMCSellValue(IItemStack itemStack) {
        return EMCManager.getEMCSellValue(itemStack);
    }
}
