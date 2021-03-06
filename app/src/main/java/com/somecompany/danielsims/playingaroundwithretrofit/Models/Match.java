package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        public Match[] newArray(int size) {
            return new Match[size];
        }
    };

    @SerializedName("champion")
    @Expose
    private Integer champion;

    @SerializedName("queue")
    @Expose
    private Integer queue;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("season")
    @Expose
    private Integer season;

    public Integer getChampion() {
        return champion;
    }

    public void setChampion(Integer champion) {
        this.champion = champion;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getChampion());
        dest.writeInt(getQueue());
        dest.writeString(getRole());
        dest.writeInt(getSeason());
    }

    public Match(Parcel in){
        setChampion(in.readInt());
        setQueue(in.readInt());
        setRole(in.readString());
        setSeason(in.readInt());
    }

}
