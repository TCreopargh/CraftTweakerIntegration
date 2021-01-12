package xyz.tcreopargh.ctintegration.util;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.util.Arrays;
import java.util.Collections;

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

    @ZenMethod
    public static void reverse(int[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(double[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(float[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(String[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(short[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(byte[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(long[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    @ZenMethod
    public static void reverse(char[] array) {
        Collections.reverse(Arrays.asList(array));
    }
}
