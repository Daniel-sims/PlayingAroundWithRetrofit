package com.somecompany.danielsims.playingaroundwithretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


//https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
public class MainActivity extends AppCompatActivity {

    public static final String RIOT_BASE_URL = "https://euw1.api.riotgames.com/";

    private TextView mFoundSummonerName;
    private TextView mFoundSummonerLevel;

    private TextView mFoundSummonerTier;
    private TextView mFoundSummonerDivision;
    private TextView mFoundSummonerLp;


    private Button mSearchButton;
    private TextView mSummonerNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFoundSummonerName = findViewById(R.id.FoundSummonerName);
        mFoundSummonerLevel = findViewById(R.id.FoundSummonerLevel);

        mFoundSummonerTier = findViewById(R.id.FoundSummonerTier);
        mFoundSummonerDivision = findViewById(R.id.FoundSummonerDivision);
        mFoundSummonerLp = findViewById(R.id.FoundSummonerLp);

        mSearchButton = findViewById(R.id.Search);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSummonerFromRiot();
            }
        });
        mSummonerNameTextView = findViewById(R.id.SummonerName);
    }

    Summoner mSummoner = null;
    SummonerRank mSummonerRank = null;

    private void getSummonerFromRiot() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RIOT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Summoner summoner = null;
        SummonerRank summonerRank = null;

        final RiotApiInterface apiService = retrofit.create(RiotApiInterface.class);
        Call<Summoner> summonerCall = apiService.getSummonerByName(mSummonerNameTextView.getText().toString());
        try
        {
            summonerCall.enqueue(new Callback<Summoner>() {
                @Override
                public void onResponse(Call<Summoner> call, Response<Summoner> response) {
                    int statusCode = response.code();
                    if(statusCode == 200) {
                        final Summoner summoner = response.body();
                        mSummoner = summoner;

                        Call<SummonerRank[]> summonerRankCall = apiService.getSummonerRankByAccountId(summoner.getId());
                        summonerRankCall.enqueue(new Callback<SummonerRank[]>() {
                            @Override
                            public void onResponse(Call<SummonerRank[]> call, Response<SummonerRank[]> response) {
                                SummonerRank[] s = response.body();
                                mSummonerRank = s[0];

                                launchSummonerDetailsActivity();

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

    private void launchSummonerDetailsActivity(){
        Intent startSummonerDetailsActivityIntent = new Intent(this, SummonerDetailsActivity.class);
        startSummonerDetailsActivityIntent.putExtra("summoner", mSummoner);
        startSummonerDetailsActivityIntent.putExtra("summonerrank", mSummonerRank);

        startActivity(startSummonerDetailsActivityIntent);
    }
}
