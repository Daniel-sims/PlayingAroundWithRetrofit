package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SummonerRank  implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SummonerRank createFromParcel(Parcel in) {
            return new SummonerRank(in);
        }

        public SummonerRank[] newArray(int size) {
            return new SummonerRank[size];
        }
    };

    @SerializedName("wins")
    @Expose
    private Integer wins;

    @SerializedName("losses")
    @Expose
    private Integer losses;

    @SerializedName("rank")
    @Expose
    private String rank;

    @SerializedName("tier")
    @Expose
    private String tier;

    @SerializedName("leaguePoints")
    @Expose
    private Integer leaguePoints;


    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Integer getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(Integer leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getWins());
        dest.writeInt(getLosses());
        dest.writeString(getRank());
        dest.writeString(getTier());
        dest.writeInt(getLeaguePoints());
    }

    public SummonerRank(Parcel in){
        setWins(in.readInt());
        setLosses(in.readInt());
        setRank(in.readString());
        setTier(in.readString());
        setLeaguePoints(in.readInt());
    }

}
