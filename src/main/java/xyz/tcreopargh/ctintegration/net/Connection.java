package xyz.tcreopargh.ctintegration.net;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "net.Connection")
public class Connection {

    private URLConnection connection;

    public Connection(String urlString) throws IOException {
        connection = (new URL(urlString)).openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
    }

    public Connection(URLConnection connection) {
        this.connection = connection;
    }

    @ZenMethod
    public static Connection openUrl(String urlString) {
        try {
            return new Connection(urlString);
        } catch (IOException e) {
            CraftTweakerAPI.logInfo(e.getMessage());
            return null;
        }
    }

    public URLConnection getConnection() {
        return connection;
    }

    public void setConnection(URLConnection connection) {
        this.connection = connection;
    }

    @ZenMethod
    public Connection setConnectTimeout(int timeout) {
        connection.setConnectTimeout(timeout);
        return this;
    }

    @ZenMethod
    public Connection setReadTimeout(int timeout) {
        connection.setReadTimeout(timeout);
        return this;
    }

    @ZenMethod
    public Connection setRequestProperty(String key, String value) {
        connection.setRequestProperty(key, value);
        return this;
    }

    @ZenMethod
    public String readToString() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder output = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                output.append(inputLine).append("\n");
            }
            output.setLength(Math.max(output.length() - 1, 0));
            return output.toString();
        } catch (IOException e) {
            CraftTweakerAPI.logInfo(e.getMessage());
            return null;
        }
    }
}
