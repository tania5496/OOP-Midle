package search;

import api.APIBrandfetchStrategy;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

public class IconSearchStrategy implements Search{
    @Override @SneakyThrows
    public String search(JSONObject json_data) {
        JSONArray arr = json_data.getJSONArray("logos");
        for(int i = 0; i < arr.length(); ++i){
            if (arr.getJSONObject(i).getString("type").equals("icon")){
                return arr.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
            }
        }
        return null;
    }
    public static void main(String[] args) {
        APIBrandfetchStrategy apiBrandfetchStrategy = new APIBrandfetchStrategy();
        apiBrandfetchStrategy.getInfo("ucu.edu.ua");
        System.out.println(new IconSearchStrategy().search(apiBrandfetchStrategy.getData()));
    }
}
