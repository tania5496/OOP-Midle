package search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class TwitterSearchStrategy implements Search {
    @Override
    public String searchwithBrandfetch(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("links");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("name").equals("twitter")){
                return arr.getJSONObject(i).getString("search");
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

    @Override
    public String searchParser(Document doc) {
        ArrayList<Element> twitterLink = doc.select("a[href^=https://twitter.com/]");
        String twitter = twitterLink.get(0).attr("abs:href");
        return twitter;
    }
}
