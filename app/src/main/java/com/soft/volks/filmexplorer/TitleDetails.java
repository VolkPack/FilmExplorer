package com.soft.volks.filmexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TitleDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_details);
        Intent intent = getIntent();
        MovieInfo titleDetails = (MovieInfo) intent.getSerializableExtra("MOVIE_INFO");

        ImageView poster = (ImageView) findViewById(R.id.poster);
        TextView movie_details = (TextView) findViewById(R.id.details_title);
        TextView overview = (TextView) findViewById(R.id.overview);
        TextView release_date = (TextView) findViewById(R.id.release_date);

        Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w780" + titleDetails.getmPosterPath()).into(poster);
        movie_details.setText(titleDetails.getmTitle());
        release_date.setText(titleDetails.getmRelease_Date());
        overview.setText(titleDetails.getmOverview());
    }
}
