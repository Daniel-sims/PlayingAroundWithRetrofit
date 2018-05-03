package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summoner implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Summoner createFromParcel(Parcel in) {
            return new Summoner(in);
        }

        public Summoner[] newArray(int size) {
            return new Summoner[size];
        }
    };

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("summonerLevel")
    @Expose
    private Integer summonerLevel;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getSummonerLevel());
        dest.writeInt(getAccountId());
        dest.writeInt(getId());
    }

    public Summoner(Parcel in){
        setName(in.readString());
        setSummonerLevel(in.readInt());
        setAccountId(in.readInt());
        setId(in.readInt());
    }
}