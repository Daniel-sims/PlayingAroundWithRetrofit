package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchList {

    @SerializedName("matches")
    @Expose
    private List<Match> matches = null;
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
}