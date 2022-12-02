package search;

import api.APIBrandfetchStrategy;
import api.APIPDLStrategy;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class NameSearchStrategy implements Search {
    @Override @SneakyThrows
    public String searchwithBrandfetch(JSONObject json_data) {
        try {
            return json_data.getString("name");
        } catch (JSONException e) {
            return "Not found";
        }
    }

    @Override
    public String searchwithPDL(JSONObject api1) {
        try {
            return api1.getString("name");
        } catch (JSONException e) {
            return "Not found";
        }
    }

    @Override
    public String searchParser(Document doc) {
        String name = doc.title();
        return name;
    }
}
