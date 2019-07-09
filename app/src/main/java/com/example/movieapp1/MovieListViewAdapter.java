package com.example.movieapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    MovieListViewAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }


    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.tv_item_name);
            txtDescription = view.findViewById(R.id.tv_item_desc);
            imgPhoto = view.findViewById(R.id.img_item_photo);
        }
        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDescription.setText(movie.getDesc());
            imgPhoto.setImageResource(movie.getImg());
        }
    }
}