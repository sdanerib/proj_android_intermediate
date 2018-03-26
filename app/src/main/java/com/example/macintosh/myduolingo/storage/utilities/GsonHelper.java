package com.example.macintosh.myduolingo.storage.utilities;
import com.example.macintosh.myduolingo.storage.network.entities.LanguagesToLearnFullResponse;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONObject;

/**
 * Created by Stephany Daneri on 3/24/18.
 */

public class GsonHelper {

    public static LanguagesToLearnFullResponse jsonToLanguagesToLearnFullResponse (JsonElement json){
        if(json==null){
            return new LanguagesToLearnFullResponse();
        }
        GsonBuilder gson = new GsonBuilder();
        LanguagesToLearnFullResponse langsToLearnFullResponse = gson.create().fromJson(json, LanguagesToLearnFullResponse.class);

        return langsToLearnFullResponse;
    }

}
