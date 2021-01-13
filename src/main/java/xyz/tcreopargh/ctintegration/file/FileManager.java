package xyz.tcreopargh.ctintegration.file;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ZenClass(CTIntegrationMod.CT_NAMESPACE + "file.FileManager")
@ZenRegister
public class FileManager {

    public static List<String> whitelistedDirectories = Arrays.asList(
            "dumps",
            "config",
            "scripts",
            "resources",
            "ctintegration",
            "crash-reports",
            "crafttweaker_dump",
            "logs"
    );

    @ZenMethod
    public static String[] getFileList(String directoryPath) {
        if (!isAllowed(directoryPath)) {
            CraftTweakerAPI.logError("You don't have permission to read or write in this path: " + directoryPath);
            return null;
        }
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            CraftTweakerAPI.logError("You can only list files in a directory");
            return null;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            CraftTweakerAPI.logError("File list is null");
            return null;
        }
        List<String> filePaths = new ArrayList<>();
        for (final File fileEntry : files) {
            if (fileEntry.isDirectory()) {
                String[] innerList = getFileList(fileEntry.getPath());
                if (innerList != null) {
                    filePaths.addAll(Arrays.asList(innerList));
                }
            } else {
                filePaths.add(fileEntry.getPath());
            }
        }
        return filePaths.toArray(new String[0]);
    }

    @ZenMethod
    public static String readFromFile(String relativePath, String charset) {
        if (!isAllowed(relativePath)) {
            CraftTweakerAPI.logError("You don't have permission to read or write this file: " + relativePath);
            return null;
        }
        File file = new File(relativePath);
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
        String ret = builder.toString();
        CraftTweakerAPI.logInfo("Read " + ret.getBytes().length + " bytes from file " + file.getPath() + " with charset " + charset);
        return ret;
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
        if (!isAllowed(relativePath)) {
            CraftTweakerAPI.logError("You don't have permission to read or write this file: " + relativePath);
            return false;
        }
        File file = new File(relativePath);
        file.getParentFile().mkdirs();
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charset.forName(charset))) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String[] lines = content.split("\\n");
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            CraftTweakerAPI.logInfo("Written " + content.getBytes().length + " bytes to file " + file.getPath() + " with charset " + charset);
            return true;
        } catch (IOException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
            return false;
        }
    }

    @ZenMethod
    public static boolean isAllowed(String path) {
        for (String directory : whitelistedDirectories) {
            Path parent = Paths.get(directory).normalize();
            Path child = Paths.get(path).normalize();
            if (child.startsWith(parent)) {
                return true;
            }
        }
        return false;
    }

    @ZenMethod
    public static boolean isFileExist(String relativePath) {
        if (!isAllowed(relativePath)) {
            return false;
        }
        File file = new File(relativePath);
        return file.exists();
    }

    @ZenMethod
    public static boolean isDirectory(String relativePath) {
        if (!isAllowed(relativePath)) {
            CraftTweakerAPI.logError("You don't have permission to read or write in this path: " + relativePath);
            return false;
        }
        File file = new File(relativePath);
        return file.isDirectory();
    }
}
