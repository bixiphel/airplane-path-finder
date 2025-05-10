package edu.uwp.cs.csci340.assignments.gtfh;

import okhttp3.*;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;

public class AirportDistanceCalculator {
    // Defines API keys from the environment variables because I'm not stupid
    private static final String OPENCAGE_API_KEY = System.getenv("OPENCAGE_API_KEY");
    private static final String OPEN_ROUTE_API_KEY = System.getenv("OPENROUTESERVICE_API_KEY");

    // Creates an OkHttpClient object so I can reference it later when making HTTP requests
    private final OkHttpClient client = new OkHttpClient();

    /**
     * @param cityName
     * @return
     * @throws IOException
     */
    public double[] geocodeCity(String cityName) throws IOException {
        // Creates the url with the formatting specified on OpenCage's website
        String url = "https://api.opencagedata.com/geocode/v1/json?q=" +
                cityName.replace(" ", "%20") +
                "&key=" + OPENCAGE_API_KEY;

        // Creates an HTTP GET request
        Request request = new Request.Builder().url(url).build();

        // Execute the request and automatically close the response after use
        try (Response response = client.newCall(request).execute()) {
            String json = response.body().string(); // Read the JSON response as a string
            JSONObject obj = new JSONObject(json); // Parse the response into a JSON object

            JSONArray results = obj.getJSONArray("results"); // Extract the array of results

            if (results.length() == 0) throw new IOException("City not found");

            // Get the first result's geometry (lat/lng)
            JSONObject geometry = results.getJSONObject(0).getJSONObject("geometry");
            double lat = geometry.getDouble("lat");
            double lng = geometry.getDouble("lng");

            // Return coordinates as [latitude, longitude]
            return new double[]{lat, lng};
        }
    }

}
