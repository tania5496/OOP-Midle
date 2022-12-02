package com.middle.demo.search;

import lombok.SneakyThrows;
import org.json.JSONObject;

public interface Search_JPG {
    @SneakyThrows
    String searchwithBrandfetch(JSONObject json_data);
}
