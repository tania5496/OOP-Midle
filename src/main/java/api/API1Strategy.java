package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import org.json.JSONObject;


public class API1Strategy implements API {
    private JSONObject data;

    @SneakyThrows
    @Override
    public void getInfo(String domain) {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.peopledatalabs.com/v5/company/enrich?website=ucu.edu.ua&pretty=false")
                .header("accept", "application/json")
                .header("X-API-Key", "e6695d7c8c570225e915388b990380b7e0de14fef85658bd73547fe1cede1ded")
                .asString();
        System.out.println(response.getBody());
    }
}
