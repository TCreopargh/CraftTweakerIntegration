package xyz.tcreopargh.ctintegration.file;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.io.*;
import java.nio.charset.Charset;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "file.FileManager")
@ZenRegister
public class FileManager {

    @ZenMethod
    public static String readFromFile(String relativePath, String charset) {
        File file = new File("dumps/" + relativePath);
        if (!file.exists()) {
            CraftTweakerAPI.logError("File does not exist");
            return null;
        }
        if (file.isDirectory()) {
            CraftTweakerAPI.logError("Attempt to read from a directory");
            return null;
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName(charset)))) {
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
            return null;
        }
        return builder.toString();
    }

    @ZenMethod
    public static String readFromFile(String relativePath) {
        return readFromFile(relativePath, "UTF-8");
    }

    @ZenMethod
    public static boolean writeToFile(String relativePath, String content) {
        return writeToFile(relativePath, content, "UTF-8");
    }

    @ZenMethod
    public static boolean writeToFile(String relativePath, String content, String charset) {
        File file = new File("dumps/" + relativePath);
        file.getParentFile().mkdirs();
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charset.forName(charset))) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String[] lines = content.split("\\n");
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
            return false;
        }
    }
}
