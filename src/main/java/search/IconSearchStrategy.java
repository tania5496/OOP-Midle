package search;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class IconSearchStrategy implements Search_JPG{
    @Override @SneakyThrows
    public String searchwithBrandfetch(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("logos");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("type").equals("icon")){
                return arr.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
            }
        }
        return "Not found";
    }

    public String searchParser(Document doc) {
        ArrayList<Element> icons = doc.select("head > link[rel=shortcut icon]");
        String icon = icons.get(0).attr("abs:href");
        return icon;
    }
}
