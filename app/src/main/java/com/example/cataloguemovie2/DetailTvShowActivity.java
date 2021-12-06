package com.example.cataloguemovie2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV);

        int imageRes = tvShow.getPhoto();
        String line1 = tvShow.getName();
        String line2 = tvShow.getDescription();

        ImageView imageView = findViewById(R.id.ivPhoto);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.tvName);
        textView1.setText(line1);

        TextView textView2 = findViewById(R.id.tvDescription);
        textView2.setText(line2);

    }
}
