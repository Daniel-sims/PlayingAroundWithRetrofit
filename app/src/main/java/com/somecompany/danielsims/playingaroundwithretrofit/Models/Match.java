package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {


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

}
