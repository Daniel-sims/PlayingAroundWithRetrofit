package com.somecompany.danielsims.playingaroundwithretrofit.RetrofitInterace;

import com.somecompany.danielsims.playingaroundwithretrofit.Models.MatchList;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.Summoner;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.SummonerRank;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RiotApiInterface {

    @GET("lol/summoner/v3/summoners/by-name/{SummonerName}")
    Call<Summoner> getSummonerByName(@Path("SummonerName") String summonerName);

    @GET("lol/league/v3/positions/by-summoner/{AccountId}")
    Call<SummonerRank[]> getSummonerRankByAccountId(@Path("AccountId") long accountId);

    @GET("lol/match/v3/matchlists/by-account/{AccountId}")
    Call<MatchList> getRecentMatchListForSummonerId(
            @Path("AccountId") long summonerId,
            @Query("beginIndex") int beginIndex,
            @Query("endIndex") int endIndex);

}
