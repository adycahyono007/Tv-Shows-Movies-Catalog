package com.example.cataloguemovie2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilmActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Film film = getIntent().getParcelableExtra(EXTRA_PERSON);

        int imageRes = film.getPhoto();
        String line1 = film.getName();
        String line2 = film.getDescription();

        ImageView imageView = findViewById(R.id.ivPhoto);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.tvName);
        textView1.setText(line1);

        TextView textView2 = findViewById(R.id.tvDescription);
        textView2.setText(line2);



    }
}
