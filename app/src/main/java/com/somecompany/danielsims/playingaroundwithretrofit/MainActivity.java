package com.somecompany.danielsims.playingaroundwithretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


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

    private void getSummonerFromRiot() {
    }

}
