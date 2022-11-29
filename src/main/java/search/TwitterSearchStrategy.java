package search;

import org.json.JSONArray;
import org.json.JSONObject;

public class TwitterSearchStrategy implements Search {
    @Override
    public String search(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("links");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("name").equals("twitter")){
                return arr.getJSONObject(i).getString("search");
            }
        }
        return null;
    }

}
