package com.middle.demo.search;

import org.json.JSONException;
import org.json.JSONObject;

public class Employees {
    public String getEmployees(JSONObject api1) {
        try {
            return api1.getString("size");
        }
        catch (NullPointerException | JSONException e) {
            return "Not found";
        }
    }
}
