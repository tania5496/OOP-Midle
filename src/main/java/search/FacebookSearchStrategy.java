package search;

import api.APIBrandfetchStrategy;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookSearchStrategy implements Search {
    @Override @SneakyThrows
    public String search(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("links");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("name").equals("facebook")){
                return arr.getJSONObject(i).getString("search");
            }
        }
        return null;
    }

}
