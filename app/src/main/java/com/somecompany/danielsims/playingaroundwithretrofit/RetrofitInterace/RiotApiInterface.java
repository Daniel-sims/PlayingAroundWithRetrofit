package com.somecompany.danielsims.playingaroundwithretrofit.RetrofitInterace;

import com.somecompany.danielsims.playingaroundwithretrofit.Models.Summoner;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.SummonerRank;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RiotApiInterface {

    @Headers({"X-Riot-Token: RGAPI-5f9692a9-1a98-4aa3-bccc-58eb95fa955e"})
    @GET("lol/summoner/v3/summoners/by-name/{SummonerName}")
    Call<Summoner> getSummonerByName(@Path("SummonerName") String summonerName);

    @Headers({"X-Riot-Token: RGAPI-5f9692a9-1a98-4aa3-bccc-58eb95fa955e"})
    @GET("lol/league/v3/positions/by-summoner/{AccountId}")
    Call<SummonerRank[]> getSummonerRankByAccountId(@Path("AccountId") long accountId);

}
