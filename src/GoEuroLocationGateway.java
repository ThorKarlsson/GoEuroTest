import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Toggi
 * Date: 6.12.2013
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public class GoEuroLocationGateway {

    private static String goEuroLocationService = "https://api.goeuro.de/api/v1/suggest/position/en/name/";

    public static Collection<Location> queryLocation(String location) throws IOException {
        try {
            URL url = new URL(goEuroLocationService + location);
            String jsonResult = getLocation(url);
            Collection<Location> locationList = extractLocations(jsonResult);
            return locationList;
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String getLocation(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return readJson(reader);
    }

    private static String readJson(BufferedReader reader) throws IOException {
        String result = new String();
        String line;
        while ((line = reader.readLine()) != null) {
            result = result.concat(line);
        }
        return result;
    }

    private static Collection<Location> extractLocations(String jsonResult) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonResult).getAsJsonObject();
        Collection<Location> locationList = new ArrayList<Location>();

        for (JsonElement element : jsonObject.getAsJsonArray("results")) {
            Location location = gson.fromJson(element, Location.class);
            locationList.add(location);
        }

        return locationList;
    }
}
