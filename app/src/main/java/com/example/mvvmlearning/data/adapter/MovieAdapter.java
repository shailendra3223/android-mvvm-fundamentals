package com.example.mvvmlearning.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmlearning.R;
import com.example.mvvmlearning.data.clickListner.ItemClickListener;
import com.example.mvvmlearning.data.model.MovieSeries;
import com.example.mvvmlearning.databinding.ItemMovieListBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieSeries> mList;
    private ItemClickListener listener;

    public MovieAdapter(ItemClickListener listener) {
        mList = new ArrayList<>();
        this.listener = listener;
    }

    public void setData(List<MovieSeries> list){
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMovieListBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_movie_list, parent, false);
        binding.setCallback(listener);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        MovieSeries movieSeries = mList.get(position);
        viewHolder.bind(movieSeries);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemMovieListBinding binding;

        public ViewHolder(ItemMovieListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(MovieSeries series){
            binding.setModel(series);
            binding.executePendingBindings();
        }
    }
}
