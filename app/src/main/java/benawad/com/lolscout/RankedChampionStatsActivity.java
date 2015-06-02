package benawad.com.lolscout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benawad.lolscout.R;
import com.squareup.picasso.Picasso;

import benawad.com.lolscout.adapters.GamesAdapter;
import benawad.com.lolscout.models.ranked_stats.Champion;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class RankedChampionStatsActivity extends AppCompatActivity {

    @InjectView(R.id.rcs_assists_text)
    TextView mAssists;
    @InjectView(R.id.rcs_deaths_text)
    TextView mDeaths;
    @InjectView(R.id.rcs_kills_text)
    TextView mKills;
    @InjectView(R.id.rcs_win_loss)
    TextView mWinLoss;
    @InjectView(R.id.rcs_champ_image)
    ImageView mChamp;
    @InjectView(R.id.plain_tool_bar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranked_champion_stats);
        ButterKnife.inject(this);

        Intent intent = getIntent();

        Champion champion = (Champion) intent.getSerializableExtra(MainActivity.CHAMPION_INTENT_KEY);

        int length = GamesAdapter.getLength(this) * 3;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String version = sharedPreferences.getString(MainActivity.VERSION_KEY, getResources().getString(R.string.version_def));
        String championJson = sharedPreferences.getString(MainActivity.CHAMPION_IMAGE_KEY, getResources().getString(R.string.champion_json_def));
        String sumSpellJson = sharedPreferences.getString(MainActivity.SUM_SPELL_IMAGE_KEY, getResources().getString(R.string.sum_spell_json_def));

        StaticData staticData = new StaticData(championJson, sumSpellJson);

        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/"
                + version + "/img/champion/" + staticData.getChampImage(champion.getId()))
                .resize(length, length).into(mChamp);

        int games = champion.getStats().getTotalSessionsPlayed();
        double killsPer = round(champion.getStats().getTotalChampionKills() / (double)games);
        double deathsPer = round(champion.getStats().getTotalDeathsPerSession()/(double)games);
        double assistsPer = round(champion.getStats().getTotalAssists()/(double)games);

        mAssists.setText(assistsPer+"");
        mKills.setText(killsPer+"");
        mDeaths.setText(deathsPer+"");

        String win = "<font color='" + getResources().getColor(R.color.WinGreen) + "'>" + champion.getStats().getTotalSessionsWon() + "</font>";
        String lose = "<font color='" + getResources().getColor(R.color.LoseRed) + "'>" + champion.getStats().getTotalSessionsLost() + "</font>";

        mWinLoss.setText(MainActivity.getColoredGameRecord(champion.getStats().getTotalSessionsWon(), champion.getStats().getTotalSessionsLost(), this));

        setSupportActionBar(mToolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(getApplicationInfo().labelRes));
        }

    }

    public double round(double num){
        return Math.round(num*10.0)/10.0;
    }

}
