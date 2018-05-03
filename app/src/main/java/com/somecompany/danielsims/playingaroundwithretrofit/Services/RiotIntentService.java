package com.somecompany.danielsims.playingaroundwithretrofit.Services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.Summoner;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.SummonerRank;
import com.somecompany.danielsims.playingaroundwithretrofit.RetrofitInterace.RiotApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RiotIntentService extends IntentService {
    public static final String RIOT_BASE_URL = "https://euw1.api.riotgames.com/";
    public static final String SUMMONER_NAME_INTENT_EXTRA = "SUMMONERNAME";

    public RiotIntentService() {
        super("RiotIntentService");
    }

    public static Intent getSummonerIntent(Context context, String summonerName){
        Intent intent = new Intent(context, RiotIntentService.class);
        intent.putExtra(SUMMONER_NAME_INTENT_EXTRA, summonerName);

        return intent;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String summonerNameToGet = intent.getStringExtra(SUMMONER_NAME_INTENT_EXTRA);
        if(summonerNameToGet == null)
            summonerNameToGet = "";

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RIOT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final RiotApiInterface apiService = retrofit.create(RiotApiInterface.class);
        Call<Summoner> summonerCall = apiService.getSummonerByName(summonerNameToGet);
        try
        {
            summonerCall.enqueue(new Callback<Summoner>() {
                @Override
                public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                    int statusCode = response.code();
                    if(statusCode == 200) {
                        final Summoner summoner = response.body();

                        Call<SummonerRank[]> summonerRankCall = apiService.getSummonerRankByAccountId(summoner.getId());
                        summonerRankCall.enqueue(new Callback<SummonerRank[]>() {
                            @Override
                            public void onResponse(Call<SummonerRank[]> call, Response<SummonerRank[]> response) {
                                SummonerRank[] summonerRank = response.body();
                            }

                            @Override
                            public void onFailure(Call<SummonerRank[]> call, Throwable t) {

                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<Summoner> call, Throwable t) {

                }
            });
        } catch (Exception e) { }
    }
}
