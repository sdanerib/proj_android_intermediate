package com.example.macintosh.myduolingo.presenters;

import com.example.macintosh.myduolingo.storage.network.entities.LanguageToLearnResponse;
import com.example.macintosh.myduolingo.storage.network.entities.LanguagesToLearnFullResponse;
import com.example.macintosh.myduolingo.storage.utilities.ApiClient;
import com.example.macintosh.myduolingo.storage.utilities.GsonHelper;
import com.example.macintosh.myduolingo.storage.utilities.StorageConstant;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Stephany Daneri on 3/25/18.
 */

public class LanguagesToLearnPresenter {

    private LanguagesToLearnViewContract view;

    public void loadLanguagesFromBackendless(){

        //view.showLoading();

        Map<String, String> map = new HashMap<>();
        //map.put("user-token",token);

        Call<LanguagesToLearnFullResponse> call =
                ApiClient
                        .getMyApiClient()
                        .getLanguagesToLearn(
                                StorageConstant.APPLICATION_ID,
                                StorageConstant.REST_API_KEY,
                                map
                        );

        call.enqueue(new Callback<LanguagesToLearnFullResponse>() {
            @Override
            public void onResponse(Call<LanguagesToLearnFullResponse> call,
                                   Response<LanguagesToLearnFullResponse> response) {

                //view.hideLoading();

                if(response!=null){
                    LanguagesToLearnFullResponse languagesToLearnResponse = null;
                    if(response.isSuccessful())
                    {
                        languagesToLearnResponse = response.body();
                        System.out.println("languagesToLearnResponse: "+languagesToLearnResponse.toString());
                        view.renderAllLanguageToLearn(languagesToLearnResponse);
                    }
                    else{
                        view.showErrorMsg();
                    }
                }
            }

            @Override
            public void onFailure(Call<LanguagesToLearnFullResponse> call, Throwable t) {
                //view.hideLoading();
            }
        });


    }

    public void attachView(LanguagesToLearnViewContract view){
        this.view=view;
    }
    public void detachView(){
        this.view=null;
    }

}
