package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MatchList implements Parcelable{

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public MatchList createFromParcel(Parcel in) {
            return new MatchList(in);
        }

        public MatchList[] newArray(int size) {
            return new MatchList[size];
        }
    };

    @SerializedName("matches")
    @Expose
    private List<Match> matches = new ArrayList<>();
    @SerializedName("endIndex")
    @Expose
    private Integer endIndex;
    @SerializedName("startIndex")
    @Expose
    private Integer startIndex;
    @SerializedName("totalGames")
    @Expose
    private Integer totalGames;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Integer totalGames) {
        this.totalGames = totalGames;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(getMatches());
        dest.writeInt(getEndIndex());
        dest.writeInt(getStartIndex());
        dest.writeInt(getTotalGames());
    }

    public MatchList(Parcel in){
        in.readList(this.matches, Match.class.getClassLoader());
        setEndIndex(in.readInt());
        setStartIndex(in.readInt());
        setTotalGames(in.readInt());
    }
}