package com.example.mvvmlearning.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MovieListModel {

    @SerializedName("Search")
    public List<MovieSeries> search;

    @SerializedName("totalResults")
    public String totalResults;

    @SerializedName("Response")
    public String response;
}
