package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summoner{

    @SerializedName("profileIconId")
    @Expose
    private Integer profileIconId;
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

    public Integer getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }

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
}