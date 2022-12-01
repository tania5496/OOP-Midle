package search;

import api.APIBrandfetchStrategy;
import api.APIPDLStrategy;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSearchStrategy implements Search {
    @Override @SneakyThrows
    public String searchwithBrandfetch(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("links");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("name").equals("facebook")){
                return arr.getJSONObject(i).getString("search");
            }
        }
        return "Not found";
    }

    @Override
    public String searchwithPDL(JSONObject api1) {
        try {
            return api1.getString("facebook_url");
        } catch (JSONException e) {
            return "Not found";
        }
    }
}
