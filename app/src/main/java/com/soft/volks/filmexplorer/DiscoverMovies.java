package com.soft.volks.filmexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DiscoverMovies extends AppCompatActivity {

    public  ArrayList<MovieInfo> stuff = new ArrayList<>();
    MovieInfo item = new MovieInfo();

    public int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_movies);

        setView(page);
        final View view;
        view = getLayoutInflater().inflate(R.layout.discover_page_footer, null);
        ListView listView = (ListView) findViewById(R.id.activity_discover_movies);
        listView.addFooterView(view);



        final TextView pageNumber = (TextView) findViewById(R.id.page_number);
        pageNumber.setText(Integer.toString(page));

        ImageButton forward = (ImageButton) findViewById(R.id.forward);
        ImageButton back = (ImageButton) findViewById(R.id.back);



        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = page + 1;
                pageNumber.setText(Integer.toString(page));
                setView(page);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page == 1){
                    //do nothing
                }else{
                    page = page - 1;
                    setView(page);
                }
                pageNumber.setText(Integer.toString(page));
            }
        });
    }

    public void setView(int page){
        DiscoverApi getList = new DiscoverApi();
        try{
            stuff = getList.execute(Integer.toString(page)).get();
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        final DiscoverListAdapter listAdapter = new DiscoverListAdapter(this, stuff);
        final ListView listView = (ListView) findViewById(R.id.activity_discover_movies);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(DiscoverMovies.this, TitleDetails.class);
                intent.putExtra("MOVIE_INFO", stuff.get(position));
                startActivity(intent);
            }
        });
    }
}
