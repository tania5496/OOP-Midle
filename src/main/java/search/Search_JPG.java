package search;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

public interface Search_JPG {
    @SneakyThrows
    String searchwithBrandfetch(JSONObject json_data);
}
