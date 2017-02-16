package com.soft.volks.filmexplorer;

import java.io.Serializable;

/**
 * Created by nkarayev on 2/15/17.
 */

public class MovieInfo implements Serializable {


    private String mTitle;
    private String mPosterPath; //in format /bbxtz5V0vvnTDA2qWbiiRC77Ok9.jpg"
    private int mId;
    private String mOverview;
    private double mVote_Average;
    private String mRelease_Date;


    public MovieInfo(){

    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public void setmPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public double getmVote_Average() {
        return mVote_Average;
    }

    public void setmVote_Average(double mVote_Average) {
        this.mVote_Average = mVote_Average;
    }

    public String getmRelease_Date() {
        return mRelease_Date;
    }

    public void setmRelease_Date(String mRelease_Date) {
        this.mRelease_Date = mRelease_Date;
    }
}
