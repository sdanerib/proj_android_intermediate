package com.example.macintosh.myduolingo.storage.network;

import com.example.macintosh.myduolingo.storage.network.entities.LanguageToLearnResponse;
import com.example.macintosh.myduolingo.storage.network.entities.LanguagesToLearnFullResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

/**
 * Created by Stephany Daneri on 3/24/18.
 */

public interface ServicesApiInterface {

    // BASE_URL: https://api.backendless.com
    // /905A7D36-5BF7-5136-FF00-79DFC6338200/8F31AA0F-C295-33E0-FF23-BFDF25564B00
    // /data/LanguagesToLearn
    @GET("/{applicationid}/{restapikey}/data/LanguagesToLearn")
    Call<LanguagesToLearnFullResponse> getLanguagesToLearn
                                    (@Path("applicationid") String appID,
                                     @Path("restapikey") String restApiKEY,
                                     @HeaderMap Map<String, String> headers);
}
