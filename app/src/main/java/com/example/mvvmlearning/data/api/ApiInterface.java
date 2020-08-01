package com.example.mvvmlearning.data.api;
import com.example.mvvmlearning.data.model.MovieListModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //http://www.omdbapi.com/?s=fast+and+furious&apikey=9b7eb766
    @GET(".")
    Call<MovieListModel> getMovieList(@Query("s") String movieSeries,
                                      @Query("apiKey") String apiKey);
}
