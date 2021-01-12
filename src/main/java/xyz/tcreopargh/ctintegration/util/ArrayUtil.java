package xyz.tcreopargh.ctintegration.util;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.value.IAny;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;
import xyz.tcreopargh.ctintegration.date.IDate;

import java.util.Arrays;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "util.ArrayUtil")
public class ArrayUtil {
    @ZenMethod
    public static void sort(int[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(double[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(float[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(String[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(short[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(byte[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(long[] array) {
        Arrays.sort(array);
    }

    @ZenMethod
    public static void sort(char[] array) {
        Arrays.sort(array);
    }
}
