package search;

import lombok.SneakyThrows;
import org.json.JSONObject;

public interface Search {
    @SneakyThrows
    String search(JSONObject json_data);
}
