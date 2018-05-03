package com.somecompany.danielsims.playingaroundwithretrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SummonerRank {

    @SerializedName("queueType")
    @Expose
    private String queueType;
    @SerializedName("hotStreak")
    @Expose
    private Boolean hotStreak;
    @SerializedName("wins")
    @Expose
    private Integer wins;
    @SerializedName("veteran")
    @Expose
    private Boolean veteran;
    @SerializedName("losses")
    @Expose
    private Integer losses;
    @SerializedName("playerOrTeamId")
    @Expose
    private String playerOrTeamId;
    @SerializedName("leagueName")
    @Expose
    private String leagueName;
    @SerializedName("playerOrTeamName")
    @Expose
    private String playerOrTeamName;
    @SerializedName("inactive")
    @Expose
    private Boolean inactive;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("freshBlood")
    @Expose
    private Boolean freshBlood;
    @SerializedName("leagueId")
    @Expose
    private String leagueId;
    @SerializedName("tier")
    @Expose
    private String tier;
    @SerializedName("leaguePoints")
    @Expose
    private Integer leaguePoints;

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public Boolean getHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(Boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Boolean getVeteran() {
        return veteran;
    }

    public void setVeteran(Boolean veteran) {
        this.veteran = veteran;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Boolean getFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(Boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
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

}
