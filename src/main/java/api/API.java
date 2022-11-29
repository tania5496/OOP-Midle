package api;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.json.JSONObject;

public interface API {

    @SneakyThrows
    void getInfo(String domain);
}
