package com.soft.volks.filmexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by nkarayev on 2/15/17.
 */

public class DiscoverListAdapter extends ArrayAdapter<MovieInfo> {

    public DiscoverListAdapter(Context context, ArrayList<MovieInfo> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        MovieInfo movieList = getItem(pos);
        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }

        ImageView thumb = (ImageView) listItemView.findViewById(R.id.poster_thumb);
        Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500" + movieList.getmPosterPath()).resize(250,250).centerCrop().into(thumb);
        TextView movieTitle = (TextView) listItemView.findViewById(R.id.title);
        movieTitle.setText(movieList.getmTitle());


        return listItemView;
    }
}
