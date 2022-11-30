package info;

import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class API1Strategy implements API{
    private JSONObject data;

    @SneakyThrows
    @Override
    public void getInfo(String domain) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.peopledatalabs.com/v5/company/enrich?website=%s&pretty=false", domain)))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("X-API-Key", "0e6d1e2291ce067def630829f587c149c23a30b6fcab63626f5e4a99aa4e8619")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject res = new JSONObject(response.body());
        this.data = res;
    }
}
