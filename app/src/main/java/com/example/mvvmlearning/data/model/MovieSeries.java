package com.example.mvvmlearning.data.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mvvmlearning.R;
import com.google.gson.annotations.SerializedName;

public class MovieSeries {

    @SerializedName("Title")
    public String title;

    @SerializedName("Year")
    public String year;

    @SerializedName("imdbID")
    public String imdbID;

    @SerializedName("Type")
    public String type;

    @SerializedName("Poster")
    public String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @BindingAdapter("bind:posterPath")
    public static void loadMoviePoster(ImageView view, String posterPath){
        Glide.with(view.getContext())
                .load(posterPath)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}
