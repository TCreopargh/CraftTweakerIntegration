package xyz.tcreopargh.ctintegration.util;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.mc1120.data.NBTConverter;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "util.DataUtil")
public class DataUtil {

    @ZenMethod
    public static IData fromJSON(String jsonString) {
        return parse(jsonString);
    }

    @ZenMethod
    public static IData parse(String jsonString) {
        try {
            NBTTagCompound tagCompound = JsonToNBT.getTagFromJson(jsonString);
            return NBTConverter.from(tagCompound, false);
        } catch (NBTException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
        }
        return null;
    }

    @ZenMethod
    public static String toNBTString(IData data) {
        return NBTConverter.from(data).toString();
    }

}
