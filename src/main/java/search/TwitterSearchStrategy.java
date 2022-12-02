package search;

import api.APIBrandfetchStrategy;
import api.APIPDLStrategy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterSearchStrategy implements Search {
    @Override
    public String searchwithBrandfetch(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("links");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("name").equals("twitter")){
                return arr.getJSONObject(i).getString("url");
            }
        }
        return "Not found";
    }

    @Override
    public String searchwithPDL(JSONObject api1) {
        try {
            return api1.getString("twitter_url");
        }
        catch (JSONException e) {
            return "Not found";
        }
    }

    public static void main(String[] args) {
        APIBrandfetchStrategy apiBrandfetchStrategy = new APIBrandfetchStrategy();
        apiBrandfetchStrategy.getInfo("ucu.edu.ua");
        System.out.println(new TwitterSearchStrategy().searchwithBrandfetch(apiBrandfetchStrategy.getData()));
    }
}
