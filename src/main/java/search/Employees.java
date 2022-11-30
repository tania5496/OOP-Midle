package info;

import org.json.JSONObject;

public class Employees {
    public String getEmployees(JSONObject api1) {
        try {
            return api1.getString("size");
        }
        catch (NullPointerException e) {
            return "Not found";
        }
    }

}
