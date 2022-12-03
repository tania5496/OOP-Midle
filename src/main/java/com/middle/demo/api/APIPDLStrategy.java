package com.middle.demo.api;

import lombok.Getter;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class APIPDLStrategy implements API{
    @Getter
    private JSONObject data;

    @SneakyThrows
    @Override
    public void getInfo(String domain) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.peopledatalabs.com/v5/company/enrich?website=%s&pretty=false", domain)))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("X-API-Key", "e6695d7c8c570225e915388b990380b7e0de14fef85658bd73547fe1cede1ded")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        this.data = new JSONObject(response.body());
    }
}
