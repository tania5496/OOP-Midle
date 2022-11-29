package info;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import org.json.JSONObject;

public class API2Strategy implements API{
    private JSONObject data;

    @SneakyThrows
    @Override
    public void getInfo(String domain) {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(String.format("https://api.brandfetch.io/v2/brands/%s", domain))
                .header("Authorization", "Bearer /oI0N2g30fIg5q1mps9unXZeU+C7r3NQfBE4Uq8PeOs=")
                .asString();
        JSONObject res = new JSONObject(response.getBody());
        this.data = res;
    }
}
