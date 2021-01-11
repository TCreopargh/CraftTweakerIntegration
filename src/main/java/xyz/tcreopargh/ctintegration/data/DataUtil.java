package xyz.tcreopargh.ctintegration.data;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.*;
import crafttweaker.mc1120.data.NBTConverter;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.util.Iterator;
import java.util.Map;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "data.DataUtil")
public class DataUtil {

    @ZenMethod
    public static IData fromJson(String jsonString) {
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

    @ZenMethod
    public static String getRawString(IData data) {
        if (data instanceof DataBool) {
            return data.asBool() ? "true" : "false";
        } else if (data instanceof DataByte) {
            return String.valueOf(data.asByte());
        } else if (data instanceof DataDouble) {
            return String.valueOf(data.asDouble());
        } else if (data instanceof DataFloat) {
            return String.valueOf(data.asFloat());
        } else if (data instanceof DataInt) {
            return String.valueOf(data.asInt());
        } else if (data instanceof DataString) {
            return data.asString();
        } else if (data instanceof DataShort) {
            return String.valueOf(data.asShort());
        } else if (data instanceof DataLong) {
            return String.valueOf(data.asLong());
        } else {
            return data.toString();
        }
    }

    @ZenMethod
    public static String toJson(IData data) {
        if (data instanceof DataBool) {
            return data.asBool() ? "true" : "false";
        } else if (data instanceof DataByte) {
            return String.valueOf(data.asByte());
        } else if (data instanceof DataDouble) {
            return String.valueOf(data.asDouble());
        } else if (data instanceof DataFloat) {
            return String.valueOf(data.asFloat());
        } else if (data instanceof DataInt) {
            return String.valueOf(data.asInt());
        } else if (data instanceof DataString) {
            return "\"" + data.asString() + "\"";
        } else if (data instanceof DataShort) {
            return String.valueOf(data.asShort());
        } else if (data instanceof DataLong) {
            return String.valueOf(data.asLong());
        } else if (data instanceof DataByteArray) {
            StringBuilder result = new StringBuilder();
            result.append("[");
            boolean first = true;
            byte[] var3 = data.asByteArray();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                byte value = var3[var5];
                if (first) {
                    first = false;
                } else {
                    result.append(", ");
                }

                result.append(value);
            }

            result.append("]");
            return result.toString();
        } else if (data instanceof DataIntArray) {
            StringBuilder result = new StringBuilder();
            result.append('[');
            boolean first = true;
            int[] var3 = data.asIntArray();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                int value = var3[var5];
                if (first) {
                    first = false;
                } else {
                    result.append(", ");
                }

                result.append(value);
            }

            result.append(']');
            return result.toString();
        } else if (data instanceof DataList) {
            StringBuilder output = new StringBuilder();
            output.append('[');
            boolean first = true;

            IData value;
            for (Iterator var3 = data.asList().iterator(); var3.hasNext(); output.append(toJson(value))) {
                value = (IData) var3.next();
                if (first) {
                    first = false;
                } else {
                    output.append(", ");
                }
            }

            output.append(']');
            return output.toString();
        } else if (data instanceof DataMap) {
            StringBuilder result = new StringBuilder();
            result.append('{');
            boolean first = true;
            Iterator var3 = data.asMap().entrySet().iterator();

            while (var3.hasNext()) {
                Map.Entry<String, IData> entry = (Map.Entry) var3.next();
                if (first) {
                    first = false;
                } else {
                    result.append(", ");
                }

                result.append("\"").append((String) entry.getKey()).append("\"");

                result.append(": ");
                result.append(toJson(entry.getValue()));
            }

            result.append('}');
            return result.toString();
        } else {
            return "";
        }
    }

}
