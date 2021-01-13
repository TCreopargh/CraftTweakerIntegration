package xyz.tcreopargh.ctintegration.net;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.DataMap;
import crafttweaker.api.data.IData;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import xyz.tcreopargh.ctintegration.CTIntegrationMod;
import xyz.tcreopargh.ctintegration.data.DataUtil;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

@ZenRegister
@ZenClass(CTIntegrationMod.CT_NAMESPACE + "net.Connection")
public class Connection {

    private HttpURLConnection connection;

    public Connection(String urlString) throws IOException {
        URL url = new URL(urlString);
        if (url.getProtocol().equalsIgnoreCase("https")) {
            connection = (HttpsURLConnection) (new URL(urlString)).openConnection();
        } else {
            connection = (HttpURLConnection) (new URL(urlString)).openConnection();
        }
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
    }

    public Connection(HttpURLConnection connection) {
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

    public HttpURLConnection getConnection() {
        return connection;
    }

    public void setConnection(HttpURLConnection connection) {
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
    public Connection setDoInput(boolean doInput) {
        connection.setDoInput(doInput);
        return this;
    }

    @ZenMethod
    public Connection setDoOutput(boolean doOutput) {
        connection.setDoOutput(doOutput);
        return this;
    }

    @ZenMethod
    public Connection setRequestProperty(String key, String value) {
        connection.setRequestProperty(key, value);
        return this;
    }


    @ZenMethod
    public Connection addRequestProperty(String key, String value) {
        connection.addRequestProperty(key, value);
        return this;
    }


    @ZenMethod
    public Connection setRequestMethod(String method) {
        try {
            connection.setRequestMethod(method);
        } catch (ProtocolException e) {
            CraftTweakerAPI.logError(e.getMessage(), e);
        }
        return this;
    }

    @ZenMethod
    public Connection setFixedLengthStreamingMode(int length) {
        connection.setFixedLengthStreamingMode(length);
        return this;
    }

    @ZenMethod
    public Connection setUseCaches(boolean useCaches) {
        connection.setUseCaches(useCaches);
        return this;
    }

    @ZenMethod
    public Connection setInstanceFollowRedirects(boolean instanceFollowRedirects) {
        connection.setInstanceFollowRedirects(instanceFollowRedirects);
        return this;
    }

    @ZenMethod
    public Connection post(IData data) {
        return post(data, "UTF-8");
    }

    @ZenMethod
    public Connection post(IData data, String charset) {
        if (!(data instanceof DataMap)) {
            CraftTweakerAPI.logError("post method only accepts a DataMap");
            return this;
        }
        CraftTweakerAPI.logInfo("Making post request to " + connection.getURL() + " ...");
        Map<String, IData> params = data.asMap();
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, IData> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            try {
                postData.append(URLEncoder.encode(param.getKey(), charset));
                postData.append('=');
                postData.append(URLEncoder.encode(DataUtil.getRawString(param.getValue()), charset));
            } catch (UnsupportedEncodingException e) {
                CraftTweakerAPI.logError(e.getMessage(), e);
            }
        }
        CraftTweakerAPI.logInfo("Post successful to " + connection.getURL());
        return writeString(postData.toString());
    }

    @ZenMethod
    public Connection connect() {
        try {
            connection.connect();
        } catch (IOException e) {
            CraftTweakerAPI.logInfo(e.getMessage());
        }
        CraftTweakerAPI.logInfo("Successfully connected to " + connection.getURL());
        return this;
    }

    @ZenMethod
    public Connection disconnect() {
        connection.disconnect();
        CraftTweakerAPI.logInfo("Disconnected from " + connection.getURL());
        return this;
    }

    @ZenMethod
    public Connection writeString(String str) {
        return writeString(str, "UTF-8");
    }

    @ZenMethod
    public Connection writeString(String str, String charset) {
        try {
            connection.getOutputStream().write(str.getBytes(Charset.forName(charset)));
            CraftTweakerAPI.logInfo("Written " + str.getBytes(Charset.forName(charset)).length + " bytes to " + connection.getURL());
        } catch (IOException e) {
            CraftTweakerAPI.logInfo(e.getMessage());
        }
        return this;
    }

    @ZenMethod
    public int getResponseCode() {
        try {
            return connection.getResponseCode();
        } catch (IOException e) {
            CraftTweakerAPI.logInfo(e.getMessage());
            return -1;
        }
    }

    @ZenMethod
    public String readToStringAndDisconnect() {
        String ret = readToString();
        disconnect();
        return ret;
    }

    @ZenMethod
    public String readToStringAndDisconnect(String charset) {
        String ret = readToString(charset);
        disconnect();
        return ret;
    }

    @ZenMethod
    public String readToString() {
        return readToString("UTF-8");
    }

    @ZenMethod
    public String readToString(String charset) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
            StringBuilder output = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                output.append(inputLine).append("\n");
            }
            output.setLength(Math.max(output.length() - 1, 0));
            CraftTweakerAPI.logInfo("Read " + output.toString().getBytes().length + " bytes from " + connection.getURL());
            return output.toString();

        } catch (IOException e) {
            CraftTweakerAPI.logInfo(e.getMessage());
            return null;
        }
    }
}
