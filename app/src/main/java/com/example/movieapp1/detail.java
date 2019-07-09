package com.example.movieapp1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class detail extends AppCompatActivity implements View.OnClickListener {

    public static final String Title = "title";
    public static final String Desc = "desc";
    public static final String Pic = "pic";
    private Context context;
    TextView tvTitle;
    TextView tvDesc;
    ImageView imgPhoto;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int pic = bundle.getInt("pic");
            String title = bundle.getString("title");
            String desc = bundle.getString("desc");

            setMode(desc,title,pic);
        }


        btnDownload = findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String title = getIntent().getStringExtra("title");
        Toast.makeText(detail.this,"Download " + title,Toast.LENGTH_SHORT).show();
    }

    public void setMode(String desc, String title, int pic) {
        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
        imgPhoto = findViewById(R.id.IVDetail);


        tvTitle.setText(title);
        tvDesc.setText(desc);
        imgPhoto.setImageResource(pic);

        setActionBarTitle("Movie Detail");

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
