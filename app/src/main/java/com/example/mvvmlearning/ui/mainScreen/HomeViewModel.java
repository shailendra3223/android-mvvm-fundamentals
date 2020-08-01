package com.example.mvvmlearning.ui.mainScreen;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmlearning.BuildConfig;
import com.example.mvvmlearning.data.model.MovieListModel;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<MovieListModel> listModel = new MutableLiveData<>() ;
    Application application;
//    public HomeViewModel(@NonNull Application application) {
//        super(application);
//        this.application = application;
//    }

//    public void initialise(String series){
//        if(listModel != null){
//            return;
//        }
//    }

    void initialise(String series){
        MovieRepo repo = MovieRepo.getInstance();
        listModel = repo.getMovieList(series, BuildConfig.token);
//        String totalResults = listModel.getValue().totalResults;
//        Log.i("TAGTAGTAG", "initialise: "+totalResults);

    }

    LiveData<MovieListModel> getList(){
        return listModel;
    }
}
