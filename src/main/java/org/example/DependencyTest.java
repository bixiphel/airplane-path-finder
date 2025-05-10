package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* This class is to test that the okHTTP and org.json dependencies were installed correctly
 * I left this in the project files in case I needed to reference something.
 * Used ChatGPT to generate this testing code cuz I'm not familiar enough yet with the APIs to figure out how to
 */
class DependencyTest {
    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/todos/1")
                    .build();

            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();

            JSONObject json = new JSONObject(jsonData);
            System.out.println("Title: " + json.getString("title"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
