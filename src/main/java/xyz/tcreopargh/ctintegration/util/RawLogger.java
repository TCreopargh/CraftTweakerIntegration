package xyz.tcreopargh.ctintegration.util;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "util.RawLogger")
public class RawLogger {

    private static final File logFile = new File("crafttweaker_raw.log");

    private static PrintWriter printWriter = null;

    static {
        try {
            PrintWriter pw = new PrintWriter(logFile);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ZenMethod
    public static void logRaw(String message) {
        try {
            logFile.createNewFile();
            printWriter = new PrintWriter(new FileOutputStream(logFile, true));
            printWriter.write(message + "\n");
        } catch (IOException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
        } finally {
            if(printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}
