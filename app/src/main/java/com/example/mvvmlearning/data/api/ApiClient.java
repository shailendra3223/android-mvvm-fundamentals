package com.example.mvvmlearning.data.api;
import android.util.Log;

import com.example.mvvmlearning.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String TAG = "ApiClient";

    public static ApiInterface create() {
        return create(HttpUrl.parse(BuildConfig.apiUrl));
    }

    private static ApiInterface create(HttpUrl httpUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.w(TAG, "create: " + message));
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class);
    }
}
