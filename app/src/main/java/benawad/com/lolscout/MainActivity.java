package benawad.com.lolscout;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.benawad.lolscout.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import benawad.com.lolscout.adapters.GamesAdapter;
import benawad.com.lolscout.customs.ItemTypeAdapterFactory;
import benawad.com.lolscout.fragments.FeaturedPlayerFragment;
import benawad.com.lolscout.fragments.MatchHistoryFragment;
import benawad.com.lolscout.fragments.RankedStatsFragment;
import benawad.com.lolscout.fragments.SettingsFragment;
import benawad.com.lolscout.interfaces.Riot;
import benawad.com.lolscout.models.Summoner;
import benawad.com.lolscout.models.match_history.Games;
import benawad.com.lolscout.models.ranked_stats.Champion;
import benawad.com.lolscout.models.ranked_stats.Champions;
import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String API_KEY;
    public static final String REGION_KEY = "region";
    public static final String SUMMONER_KEY = "summoner";
    public static final String MATCH_HISTORY_KEY = "matchHistory";
    public static final String RANKED_STATS_KEY = "rankedStats";
    public static final String STRIPPED_NAME_KEY = "strippedName";
    public static final String VERSION_KEY = "version";
    public static final String CHAMPION_IMAGE_KEY = "championImage";
    public static final String SUM_SPELL_IMAGE_KEY = "sumSpellImage";
    public static final String FEATURED_PLAYER_KEY = "featuredPlayer";
    public static final String CHAMPION_INTENT_KEY = "championObject";


    @InjectView(R.id.pager)
    ViewPager mPager;
    @InjectView(R.id.tabs)
    PagerSlidingTabStrip mTabs;
    @InjectView(R.id.tool_bar)
    Toolbar mToolbar;

    private PageTabAdapter mTabAdapter;
    private SharedPreferences mSharedPref;
    private SharedPreferences.Editor mEditor;

    private String mRegion = "na";
    private Summoner mSummoner;
    private Games mGames;
    private Champions mChampions;
    private String mSumNameStrip;
    public StaticData mStaticData;
    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        API_KEY = getResources().getString(R.string.riot);

        ButterKnife.inject(this);

        mSharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        fetchStaticData();

        String championJson = mSharedPref.getString(CHAMPION_IMAGE_KEY, getResources().getString(R.string.champion_json_def));
        String sumSpellJson = mSharedPref.getString(SUM_SPELL_IMAGE_KEY, getResources().getString(R.string.sum_spell_json_def));

        mStaticData = new StaticData(championJson, sumSpellJson);

        setSupportActionBar(mToolbar);

        mTabAdapter = new PageTabAdapter(getSupportFragmentManager());
        mPager.setAdapter(mTabAdapter);
        mTabs.setViewPager(mPager);

        fetchFeaturedPlayerData();

        ComponentName componentName = getCallingActivity();

        if(componentName != null){
            mPager.setCurrentItem(2);
        }

    }

    public void fetchFeaturedPlayerData() {
        if (isNetworkAvailable()) {
            String url = "https://www.dropbox.com/s/fk1pmzcagqxeesn/featured-player.txt?raw=1";
            final SharedPreferences.Editor editor = mSharedPref.edit();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new com.squareup.okhttp.Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                }

                @Override
                public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String fpJson = response.body().string();
                        editor.putString(FEATURED_PLAYER_KEY, fpJson);
                        editor.apply();
                    }
                }
            });
        }
    }

    public void fetchStaticData() {
        if (isNetworkAvailable()) {
            final SharedPreferences.Editor editor = mSharedPref.edit();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion?champData=image&api_key=" + API_KEY)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new com.squareup.okhttp.Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                }

                @Override
                public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String championJson = response.body().string();
                        editor.putString(CHAMPION_IMAGE_KEY, championJson);
                        editor.apply();
                    }
                }
            });

            request = new Request.Builder()
                    .url("https://global.api.pvp.net/api/lol/static-data/na/v1.2/summoner-spell?spellData=image&api_key=" + API_KEY)
                    .build();

            call = client.newCall(request);
            call.enqueue(new com.squareup.okhttp.Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                }

                @Override
                public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String sumSpellJson = response.body().string();
                        editor.putString(SUM_SPELL_IMAGE_KEY, sumSpellJson);
                        editor.apply();
                    }
                }
            });

            request = new Request.Builder()
                    .url("https://ddragon.leagueoflegends.com/api/versions.json")
                    .build();

            call = client.newCall(request);
            call.enqueue(new com.squareup.okhttp.Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                }

                @Override
                public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String versionJson = response.body().string();
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(versionJson);
                            editor.putString(VERSION_KEY, (String) jsonArray.get(0));
                            editor.apply();
                        } catch (JSONException e) {
                        }
                    }
                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }

        return isAvailable;
    }

    //fetch id
    public void searchSummoner(String input) {
        mSumNameStrip = TextUtils.htmlEncode(input.replaceAll("\\s", "").toLowerCase());
        if (!mSumNameStrip.isEmpty()) {
            mRegion = mSharedPref.getString(REGION_KEY, "na");

            if (mPager.getCurrentItem() != 1 & mPager.getCurrentItem() != 2) {
                mPager.setCurrentItem(1);
            }

            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ItemTypeAdapterFactory(mSumNameStrip)).create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(new GsonConverter(gson))
                    .setEndpoint("https://" + mRegion + ".api.pvp.net")
                    .build();

            Riot service = restAdapter.create(Riot.class);

            service.summoner(mRegion, mSumNameStrip, API_KEY, new Callback<Summoner>() {
                @Override
                public void success(Summoner summoner, Response response) {
                    mEditor = mSharedPref.edit();
                    mEditor.putString(STRIPPED_NAME_KEY, mSumNameStrip);
                    mEditor.putString(SUMMONER_KEY, toJson(response));
                    mEditor.apply();
                    mSummoner = summoner;
                    matchHistory();
                    rankedStats();
                }

                @Override
                public void failure(RetrofitError error) {
                    connectionFailed(error);
                }
            });
        }
    }

    //fetch game history
    public void matchHistory() {
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ItemTypeAdapterFactory("games")).create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setEndpoint("https://" + mRegion + ".api.pvp.net")
                .build();

        Riot service = restAdapter.create(Riot.class);

        service.matchHistory(mRegion, mSummoner.getId() + "", API_KEY, new Callback<Games>() {


            @Override
            public void success(Games games, Response response) {
                mEditor.putString(MATCH_HISTORY_KEY, toJson(response));
                mEditor.apply();
                mGames = games;
                //if (mPager.getCurrentItem() == 1) {
                displayMatchHistory(games, null);
            }

            @Override
            public void failure(RetrofitError error) {
                connectionFailed(error);
            }
        });

    }

    //fetch ranked stats
    public void rankedStats() {
        Gson gson = new Gson();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setEndpoint("https://" + mRegion + ".api.pvp.net")
                .build();

        Riot service = restAdapter.create(Riot.class);
        service.rankedStats(mRegion, mSummoner.getId() + "", API_KEY, new Callback<Champions>() {
            @Override
            public void success(Champions champions, Response response) {
                mEditor.putString(RANKED_STATS_KEY, toJson(response));
                mEditor.apply();
                mChampions = champions;
                //if (mPager.getCurrentItem() == 2) {
                displayRankedStats(champions, null);
            }

            @Override
            public void failure(RetrofitError error) {
                connectionFailed(error);
            }
        });

    }

    public void displayMatchHistory(Games games, ViewGroup viewGroup) {
        RecyclerView mRecyclerView;
        if (viewGroup != null) {
            mRecyclerView = (RecyclerView) viewGroup.findViewById(R.id.games_recycler_view);
        } else {
            mRecyclerView = (RecyclerView) findViewById(R.id.games_recycler_view);
        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new GamesAdapter(games, mStaticData, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void displayRankedStats(Champions champions, ViewGroup viewGroup) {
        ImageView champ1;
        ImageView champ2;
        ImageView champ3;
        TextView desc1;
        TextView desc2;
        TextView desc3;
        GridLayout gridLayout;
        if (viewGroup != null) {
            champ1 = (ImageView) viewGroup.findViewById(R.id.s_champ1);
            champ2 = (ImageView) viewGroup.findViewById(R.id.s_champ2);
            champ3 = (ImageView) viewGroup.findViewById(R.id.s_champ3);
            desc1 = (TextView) viewGroup.findViewById(R.id.s_desc1);
            desc2 = (TextView) viewGroup.findViewById(R.id.s_desc2);
            desc3 = (TextView) viewGroup.findViewById(R.id.s_desc3);
            gridLayout = (GridLayout) viewGroup.findViewById(R.id.champ_grid);
        } else {
            champ1 = (ImageView) findViewById(R.id.s_champ1);
            champ2 = (ImageView) findViewById(R.id.s_champ2);
            champ3 = (ImageView) findViewById(R.id.s_champ3);
            desc1 = (TextView) findViewById(R.id.s_desc1);
            desc2 = (TextView) findViewById(R.id.s_desc2);
            desc3 = (TextView) findViewById(R.id.s_desc3);
            gridLayout = (GridLayout) findViewById(R.id.champ_grid);
        }

        int itemLength = GamesAdapter.getLength(this);

        final int championLength = itemLength * 2;

        String version = mSharedPref.getString(VERSION_KEY, getResources().getString(R.string.version_def));

        List<Champion> champList = champions.getChampions();

        Collections.sort(champList, new Comparator<Champion>() {

            @Override
            public int compare(Champion lhs, Champion rhs) {
                return rhs.getStats().getTotalSessionsPlayed() - lhs.getStats().getTotalSessionsPlayed();
            }
        });

        //remove overall stats
        champList.remove(0);

        final Champion champ1Ob = champList.get(0);
        final Champion champ2Ob = champList.get(1);
        final Champion champ3Ob = champList.get(2);

        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/"
                + version + "/img/champion/" + mStaticData.getChampImage(champ1Ob.getId()))
                .resize(championLength, championLength).into(champ1);
        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/"
                + version + "/img/champion/" + mStaticData.getChampImage(champ2Ob.getId()))
                .resize(championLength, championLength).into(champ2);
        Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/"
                + version + "/img/champion/" + mStaticData.getChampImage(champ3Ob.getId()))
                .resize(championLength, championLength).into(champ3);

        champ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRankedChampionStatsActivity(champ1Ob);
            }
        });
        champ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRankedChampionStatsActivity(champ2Ob);
            }
        });
        champ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRankedChampionStatsActivity(champ3Ob);
            }
        });

        desc1.setText(getColoredGameRecord(
                champ1Ob.getStats().getTotalSessionsWon(),
                champ1Ob.getStats().getTotalSessionsLost(), this));
        desc2.setText(getColoredGameRecord(
                champ2Ob.getStats().getTotalSessionsWon(),
                champ2Ob.getStats().getTotalSessionsLost(), this));
        desc3.setText(getColoredGameRecord(
                champ3Ob.getStats().getTotalSessionsWon(),
                champ3Ob.getStats().getTotalSessionsLost(), this));


        champList.remove(0);
        champList.remove(0);
        champList.remove(0);

        gridLayout.removeAllViews();

        for (int i = 0; i < champList.size(); i++){
            final ImageView image = new ImageView(this);
            image.setTag(champList.get(i));
            gridLayout.addView(image);
            Picasso.with(this).load("http://ddragon.leagueoflegends.com/cdn/"
                    + version + "/img/champion/" + mStaticData.getChampImage(champList.get(i).getId()))
                    .resize(itemLength, itemLength).into(image);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Champion champ = (Champion) image.getTag();
                    toRankedChampionStatsActivity(champ);
                }
            });
        }


    }

    public static Spanned getColoredGameRecord(int wins, int losses, Context context){
        String win = "<font color='" + context.getResources().getColor(R.color.WinGreen) + "'>" + wins + "</font>";
        String lose = "<font color='" + context.getResources().getColor(R.color.LoseRed) + "'>" + losses + "</font>";
        String slash = "<font color='" + context.getResources().getColor(R.color.DescTextColor) + "'>/</font>";
        return Html.fromHtml(win + slash + lose);
    }

    public void toRankedChampionStatsActivity(Champion champ){
        Intent intent = new Intent(this, RankedChampionStatsActivity.class);
        intent.putExtra(CHAMPION_INTENT_KEY, champ);
        startActivity(intent);
    }

    public void connectionFailed(RetrofitError error) {
        //todo
        if (!isNetworkAvailable()) {
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("No connection") // text to display
                            .actionLabel("RETRY") // action button label
                            .actionListener(new ActionClickListener() {
                                @Override
                                public void onActionClicked(Snackbar snackbar) {
                                    searchSummoner(mSearchView.getQuery().toString());
                                }
                            }) // action button's ActionClickListener
                    , this); // activity where it is displayed
        }
        else if ( error.getResponse().getStatus() == 400 ){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("Change region") // text to display
                    , this); // activity where it is displayed
        }
        else if ( error.getResponse().getStatus() == 401 ){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("Invalid key, message benawadapps@gmail.com") // text to display
                    , this); // activity where it is displayed
        }
        else if ( error.getResponse().getStatus() == 404 ){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("Missing summoner") // text to display
                    , this); // activity where it is displayed
        }
        else if ( error.getResponse().getStatus() == 429 ){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("Server overloaded, come back later") // text to display
                    , this); // activity where it is displayed
        }
        else if ( error.getResponse().getStatus() == 500 ){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("Unknown error") // text to display
                            .actionLabel("RETRY") // action button label
                            .actionListener(new ActionClickListener() {
                                @Override
                                public void onActionClicked(Snackbar snackbar) {
                                    searchSummoner(mSearchView.getQuery().toString());
                                }
                            })
                                    , this); // activity where it is displayed
        }
        else if ( error.getResponse().getStatus() == 503 ){
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext()) // context
                            .text("Maintenance, come back later") // text to display
                    , this); // activity where it is displayed
        }
    }

    public String toJson(Response response) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {

            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchMenuItem.getActionView();
        mSearchView.setQueryHint("Search Summoner");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String summonerName) {
                searchSummoner(summonerName);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    private class PageTabAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"Featured Player", "Match History", "Ranked Stats", "Settings"};


        public PageTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            if (position == 0) {
                fragment = new FeaturedPlayerFragment();
            } else if (position == 1) {
                fragment = new MatchHistoryFragment();
            } else if (position == 2) {
                fragment = new RankedStatsFragment();
            } else if (position == 3) {
                fragment = new SettingsFragment();
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

    }

}
