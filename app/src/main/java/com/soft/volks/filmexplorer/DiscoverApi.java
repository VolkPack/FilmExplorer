package com.soft.volks.filmexplorer;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by nkarayev on 2/15/17.
 */

public class DiscoverApi extends AsyncTask<String, Void, ArrayList<MovieInfo>> {

    ArrayList<MovieInfo> movieInfoArrayList = new ArrayList<>();

    @Override
    protected ArrayList<MovieInfo> doInBackground(String... params) {

        String page = params[0];
        final String BASE_URL ="https://api.themoviedb.org/3/discover/movie?";
        final String API_KEY_PREFIX = "&api_key=";
        final String API_KEY = "ff2bbb02535ec0c14e7653d6c9bc552f";
        final String PAGE_PREFIX = "&page=";

        final String discoverURL = (BASE_URL + API_KEY_PREFIX + API_KEY + PAGE_PREFIX + page);

        String jstring;

        try{
            java.net.URL url = new URL(discoverURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println(url);
            try {
                InputStream stream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }
                jstring = buffer.toString();
            }finally {
                urlConnection.disconnect();
            }

        }catch (Exception e){
            Log.e("ERROR", e.getMessage(),e);
            return null;
        }


        try {
            JSONObject info = new JSONObject(jstring);
            JSONArray movies = info.getJSONArray("results");
            for (int i = 0; i<movies.length(); i++){
                MovieInfo movieInfo = new MovieInfo();
                JSONObject item = movies.getJSONObject(i);
                movieInfo.setmId(item.getInt("id"));
                movieInfo.setmTitle(item.getString("title"));
                movieInfo.setmPosterPath(item.getString("poster_path"));
                movieInfo.setmOverview(item.getString("overview"));
                movieInfo.setmRelease_Date(item.getString("release_date"));
                movieInfoArrayList.add(movieInfo);
            }
        }catch (JSONException e){
            Log.e("error", e.getMessage(), e);
        }

        return movieInfoArrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<MovieInfo> info){
        super.onPostExecute(info);
    }
}
