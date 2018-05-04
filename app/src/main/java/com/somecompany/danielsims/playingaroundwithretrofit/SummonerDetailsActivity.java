package com.somecompany.danielsims.playingaroundwithretrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.somecompany.danielsims.playingaroundwithretrofit.Models.Match;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.MatchList;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.Summoner;
import com.somecompany.danielsims.playingaroundwithretrofit.Models.SummonerRank;

import java.util.List;

public class SummonerDetailsActivity extends AppCompatActivity {

    private TextView mFoundSummonerName;
    private TextView mFoundSummonerLevel;

    private TextView mFoundSummonerTier;
    private TextView mFoundSummonerDivision;
    private TextView mFoundSummonerLp;

    private TextView mFoundSummonerTotalWins;
    private TextView mFoundSummonerTotalLosses;

    private Summoner mSummoner;
    private SummonerRank mSummonerRank;
    private MatchList mMatchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_summoner_details_activity);

        mFoundSummonerName = findViewById(R.id.found_summoner_name);
        mFoundSummonerLevel = findViewById(R.id.found_summoner_level);

        mFoundSummonerTier = findViewById(R.id.found_summoner_tier);
        mFoundSummonerDivision = findViewById(R.id.found_summoner_division);
        mFoundSummonerLp = findViewById(R.id.found_summoner_lp);

        mFoundSummonerTotalWins = findViewById(R.id.summoner_total_wins);
        mFoundSummonerTotalLosses = findViewById(R.id.summoner_total_losses);

        RecyclerView matchRecyclerView = findViewById(R.id.matchlist_recyclerview);

        mSummoner = getIntent().getParcelableExtra("summoner");
        mSummonerRank = getIntent().getParcelableExtra("summonerrank");
        mMatchList = getIntent().getParcelableExtra("matchlist");

        if(mSummoner != null && mSummonerRank != null){
            mFoundSummonerName.setText(mSummoner.getName());
            mFoundSummonerLevel.setText(mSummoner.getSummonerLevel().toString());

            mFoundSummonerTier.setText(mSummonerRank.getTier());
            mFoundSummonerDivision.setText(mSummonerRank.getRank());
            mFoundSummonerLp.setText(mSummonerRank.getLeaguePoints().toString());

            mFoundSummonerTotalWins.setText(mSummonerRank.getWins().toString());
            mFoundSummonerTotalLosses.setText(mSummonerRank.getLosses().toString());

            MatchListAdapter matchListAdapter = new MatchListAdapter(mMatchList.getMatches());
            matchRecyclerView.setAdapter(matchListAdapter);
            matchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    //https://guides.codepath.com/android/using-the-recyclerview
    public class MatchListAdapter extends RecyclerView.Adapter<SummonerDetailsActivity.MatchListAdapter.ViewHolder> {
        public List<Match> mMatches;

        public MatchListAdapter(List<Match> matches){
            mMatches = matches;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View matchView = layoutInflater.inflate(R.layout.recycler_view_match, parent, false);
            ViewHolder viewHolder = new ViewHolder(matchView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Match match = mMatches.get(position);

            holder.mChampionId.setText(match.getChampion().toString());
            holder.mUserRole.setText(match.getRole());
        }

        @Override
        public int getItemCount() {
            return mMatches.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder{
            public TextView mChampionId;
            public TextView mUserRole;

            public ViewHolder(View itemView){
                super(itemView);

                mChampionId = itemView.findViewById(R.id.champion_id);
                mUserRole = itemView.findViewById(R.id.user_role);
            }
        }

    }


}
