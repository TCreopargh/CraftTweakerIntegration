package xyz.tcreopargh.ctintegration.util;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.OperatorType;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenOperator;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

/**
 * @author TCreopargh
 */
@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "util.MutableString")
public interface IMutableString {
    @ZenMethod
    IMutableString append(String s);

    @ZenMethod
    IMutableString append(Object s);

    @ZenMethod
    IMutableString append(int s);

    @ZenMethod
    IMutableString append(double s);

    @ZenMethod
    IMutableString append(float s);

    @ZenMethod
    IMutableString append(long s);

    @ZenMethod
    IMutableString append(boolean s);

    @ZenMethod
    IMutableString append(short s);

    @ZenMethod
    IMutableString append(byte s);

    @ZenMethod
    IMutableString delete(int start, int end);

    @ZenMethod
    IMutableString deleteCharAt(int pos);

    @ZenMethod
    IMutableString insert(int offset, String s);

    @ZenMethod
    IMutableString insert(int offset, Object s);

    @ZenMethod
    IMutableString insert(int offset, int s);

    @ZenMethod
    IMutableString insert(int offset, double s);

    @ZenMethod
    IMutableString insert(int offset, float s);

    @ZenMethod
    IMutableString insert(int offset, short s);

    @ZenMethod
    IMutableString insert(int offset, long s);

    @ZenMethod
    IMutableString insert(int offset, byte s);

    @ZenMethod
    IMutableString insert(int offset, boolean s);

    @ZenMethod
    IMutableString reverse();

    @ZenMethod
    String build();

    @ZenMethod
    @Override
    int hashCode();

    @ZenMethod
    @Override
    @ZenOperator(OperatorType.EQUALS)
    boolean equals(Object obj);

    @ZenMethod
    static IMutableString format(String format, Object... args) {
        return new MutableStringImpl(String.format(format, args));
    }

    @ZenMethod
    static IMutableString create() {
        return new MutableStringImpl();
    }

    @ZenMethod
    static IMutableString create(String str) {
        return new MutableStringImpl(str);
    }
}
