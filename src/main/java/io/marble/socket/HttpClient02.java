package io.marble.socket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClient02 {
    OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        System.out.println(new HttpClient02().run("http://localhost:8803"));
    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
