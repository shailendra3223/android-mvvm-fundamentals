package com.example.mvvmlearning.ui.mainScreen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmlearning.R;
import com.example.mvvmlearning.data.adapter.MovieAdapter;
import com.example.mvvmlearning.data.clickListner.ItemClickListener;
import com.example.mvvmlearning.data.model.MovieListModel;
import com.example.mvvmlearning.data.model.MovieSeries;
import com.example.mvvmlearning.databinding.ActivityMainBinding;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements ItemClickListener {

    ActivityMainBinding binding;
    HomeViewModel viewModel;
    private static final String TAG = "HomeActivity";
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new MovieAdapter(this);
        binding.rvMain.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        //TODO change this to search view and take input from user
        viewModel.initialise("star wars");
        viewModel.getList().observe(this, sam -> {
            if(sam != null){
                List<MovieSeries> list = sam.search;
                adapter.setData(list);
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
          }
        );
    }

    @Override
    public void onItemClickListener(MovieSeries series) {
        Toast.makeText(this, "" + series.title, Toast.LENGTH_SHORT).show();
    }
}