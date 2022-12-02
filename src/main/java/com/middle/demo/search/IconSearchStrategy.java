package com.middle.demo.search;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

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
}
