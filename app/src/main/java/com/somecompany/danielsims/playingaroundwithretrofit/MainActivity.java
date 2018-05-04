package com.somecompany.danielsims.playingaroundwithretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.MatchList;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.Summoner;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.SummonerRank;
import com.somecompany.danielsims.playingaroundwithretrofit.RetrofitInterace.RiotApiInterface;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
public class MainActivity extends AppCompatActivity {

    public static final String RIOT_BASE_URL = "https://euw1.api.riotgames.com/";

    private Summoner mSummoner = null;
    private SummonerRank mSummonerRank = null;
    private MatchList mMatchList = null;

    private Button mSearchButton;
    private TextView mSummonerNameTextView;

    private Retrofit mRetrofit;
    private RiotApiInterface mRiotApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchButton = findViewById(R.id.Search);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSummonerFromRiot();
            }
        });
        mSummonerNameTextView = findViewById(R.id.summoner_name);

        Gson gson = new GsonBuilder().create();
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        okHttpBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //API keys in code, what could go wrong
                Request.Builder newRequest = request.newBuilder().addHeader("X-Riot-Token", "RGAPI-5f9692a9-1a98-4aa3-bccc-58eb95fa955e");

                return chain.proceed(newRequest.build());
            }
        });

        mRetrofit = new Retrofit.Builder()
                .baseUrl(RIOT_BASE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mRiotApiInterface = mRetrofit.create(RiotApiInterface.class);;
    }

    private void getSummonerFromRiot() {

        try
        {
            CollectionSummonerInformationAndLaunchDetailsActivity();
        } catch (Exception e) {

        }
    }

    private void CollectionSummonerInformationAndLaunchDetailsActivity(){
        if(mSummonerNameTextView.getText() != "")
        {
            final RiotApiInterface apiService = mRetrofit.create(RiotApiInterface.class);
            Call<Summoner> summonerCall = apiService.getSummonerByName(mSummonerNameTextView.getText().toString());

            summonerCall.enqueue( new Callback<Summoner>() {
                @Override
                public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                    if(response.code() == 200) {
                        final Summoner summoner = response.body();
                        mSummoner = summoner;

                        if(mSummoner != null){
                            GetSummonerRankInformation();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Summoner> call, Throwable t) {

                }
            });
        }
    }

    private void GetSummonerRankInformation(){
        Call<SummonerRank[]> summonerRankCall = mRiotApiInterface.getSummonerRankByAccountId(mSummoner.getId());
        summonerRankCall.enqueue(new Callback<SummonerRank[]>() {
            @Override
            public void onResponse(Call<SummonerRank[]> call, Response<SummonerRank[]> response) {
                if(response.code() == 200){
                    SummonerRank[] summonerRank = response.body();
                    if(summonerRank[0] != null){
                        mSummonerRank = summonerRank[0];

                        if(mSummonerRank != null){
                            GetSummonerMatchListInformation();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SummonerRank[]> call, Throwable t) {

            }
        });
    }

    private void GetSummonerMatchListInformation(){
        final int beginIndex = 0;
        final int endIndex = 50;
        Call<MatchList> matchListCall = mRiotApiInterface.getRecentMatchListForSummonerId(mSummoner.getAccountId(), beginIndex, endIndex);
        matchListCall.enqueue(new Callback<MatchList>() {
            @Override
            public void onResponse(Call<MatchList> call, Response<MatchList> response) {
                if(response.code() == 200){
                    MatchList matchlist = response.body();
                    mMatchList = matchlist;
                }

                launchSummonerDetailsActivity();
            }

            @Override
            public void onFailure(Call<MatchList> call, Throwable t) {

            }
        });
    }

    private void launchSummonerDetailsActivity(){
        Intent startSummonerDetailsActivityIntent = new Intent(this, SummonerDetailsActivity.class);
        startSummonerDetailsActivityIntent.putExtra("summoner", mSummoner);
        startSummonerDetailsActivityIntent.putExtra("summonerrank", mSummonerRank);
        startSummonerDetailsActivityIntent.putExtra("matchlist", mMatchList);

        startActivity(startSummonerDetailsActivityIntent);
    }
}
