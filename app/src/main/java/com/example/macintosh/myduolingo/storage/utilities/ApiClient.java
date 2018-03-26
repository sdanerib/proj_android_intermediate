package com.example.macintosh.myduolingo.storage.utilities;

import com.example.macintosh.myduolingo.storage.network.ServicesApiInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stephany Daneri on 3/24/18.
 */

public class ApiClient {

    //private static final String TAG = "ApiClient";
    private static final String API_BASE_URL="https://api.backendless.com/";

    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;

    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(gsonConverterFactory);

            httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            servicesApiInterface = retrofit.create(ServicesApiInterface.class);
        }

        return servicesApiInterface;

    }

    private static HttpLoggingInterceptor interceptor() {

        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;

    }


}
