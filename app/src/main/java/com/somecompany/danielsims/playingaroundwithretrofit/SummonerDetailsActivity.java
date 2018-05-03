package com.somecompany.danielsims.playingaroundwithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.somecompany.danielsims.playingaroundwithretrofit.Models.Summoner;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.SummonerRank;

public class SummonerDetailsActivity extends AppCompatActivity {

    private TextView mFoundSummonerName;
    private TextView mFoundSummonerLevel;

    private TextView mFoundSummonerTier;
    private TextView mFoundSummonerDivision;
    private TextView mFoundSummonerLp;

    private Summoner mSummoner;
    private SummonerRank mSummonerRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_summoner_details_activity);

        mFoundSummonerName = findViewById(R.id.FoundSummonerName);
        mFoundSummonerLevel = findViewById(R.id.FoundSummonerLevel);

        mFoundSummonerTier = findViewById(R.id.FoundSummonerTier);
        mFoundSummonerDivision = findViewById(R.id.FoundSummonerDivision);
        mFoundSummonerLp = findViewById(R.id.FoundSummonerLp);

        mSummoner = getIntent().getParcelableExtra("summoner");
        mSummonerRank = getIntent().getParcelableExtra("summonerrank");

        if(mSummoner != null && mSummonerRank != null){
            mFoundSummonerName.setText(mSummoner.getName());
            mFoundSummonerLevel.setText(mSummoner.getSummonerLevel().toString());

            mFoundSummonerTier.setText(mSummonerRank.getTier());
            mFoundSummonerDivision.setText(mSummonerRank.getRank());
            mFoundSummonerLp.setText(mSummonerRank.getLeaguePoints().toString());
        }
    }
}
