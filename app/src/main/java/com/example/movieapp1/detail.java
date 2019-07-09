package com.example.movieapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class detail extends AppCompatActivity implements View.OnClickListener {

    public static final String Extra_Movie = "extra_movie";

    TextView tvTitle;
    TextView tvDesc;
    ImageView imgPhoto;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie selectedMovie = getIntent().getParcelableExtra(Extra_Movie);

        if(selectedMovie!=null){

            tvTitle = findViewById(R.id.tv_title);
            tvDesc = findViewById(R.id.tv_desc);
            imgPhoto = findViewById(R.id.IVDetail);


            tvTitle.setText(selectedMovie.getTitle());
            tvDesc.setText(selectedMovie.getDesc());
            imgPhoto.setImageResource(selectedMovie.getImg());

            setActionBarTitle("Movie Detail");
        }



        btnDownload = findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String title = getIntent().getStringExtra("title");
        Toast.makeText(detail.this,"Download " + title,Toast.LENGTH_SHORT).show();
    }



    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
