package com.example.movieapp1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] data_title;
    private String[] data_description;
    private TypedArray data_photo;
    private MovieListViewAdapter adapter;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new MovieListViewAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showSelectedArray(movies.get(i));
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < data_title.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(data_title[i]);
            movie.setDesc(data_description[i]);
            movie.setImg(data_photo.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        data_title = getResources().getStringArray(R.array.data_title);
        data_description = getResources().getStringArray(R.array.data_description);
        data_photo = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void showSelectedArray(Movie movie) {
        Intent x = new Intent(MainActivity.this, detail.class);
        x.putExtra(detail.Title, movie.getTitle());
        x.putExtra(detail.Desc, movie.getDesc());
        x.putExtra(detail.Pic, movie.getImg());
        startActivity(x);
    }
}
