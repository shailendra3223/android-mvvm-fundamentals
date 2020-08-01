package com.example.mvvmlearning.ui.mainScreen;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmlearning.data.api.ApiClient;
import com.example.mvvmlearning.data.api.ApiInterface;
import com.example.mvvmlearning.data.model.MovieListModel;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {

    private static MovieRepo movieRepo;
    private ApiInterface apiInterface;
    private static final String TAG = "MovieRepo";

    //Singleton
    public static MovieRepo getInstance() {
        if(movieRepo == null) {
            movieRepo = new MovieRepo();
        }
        return movieRepo;
    }

    private MovieRepo(){
        apiInterface = ApiClient.create();
    }

    public MutableLiveData<MovieListModel> getMovieList(String series, String apiKey){
        MutableLiveData<MovieListModel> list = new MutableLiveData<>();

        apiInterface.getMovieList(series, apiKey).enqueue(new Callback<MovieListModel>() {
            @Override
            public void onResponse(@NotNull Call<MovieListModel> call, @NotNull Response<MovieListModel> response) {
                Log.e(TAG, "onResponse77: " + call.request().url().toString());
                if(response.isSuccessful()){
                    if(response.code() == 200){
                        list.setValue(response.body());
                    } else if(response.code() == 400){
                        list.setValue(null);
                        Log.e(TAG, "onResponse: " + response.body());
                    }
                } else {
                    list.setValue(null);
                    Log.e(TAG, "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieListModel> call, @NotNull Throwable t) {
                Log.e(TAG, "onResponse: " + call.request().url().toString());
                list.setValue(null);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return list;
    }
}
