package search;

import org.json.JSONException;
import org.json.JSONObject;

public class Employees {
    public String getEmployees(JSONObject api1) {
        try {
            return Integer.toString(api1.getInt("employee_count"));
        }
        catch (NullPointerException | JSONException e) {
            return "Not found";
        }
    }
}
