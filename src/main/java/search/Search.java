package search;

import lombok.SneakyThrows;
import org.json.JSONObject;

public interface Search {
    @SneakyThrows
    String searchwithBrandfetch(JSONObject json_data);
    String searchwithPDL(JSONObject json_data);
}
