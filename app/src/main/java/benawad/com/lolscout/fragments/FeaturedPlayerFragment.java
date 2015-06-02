package benawad.com.lolscout.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benawad.lolscout.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import benawad.com.lolscout.MainActivity;
import benawad.com.lolscout.StaticData;
import benawad.com.lolscout.adapters.GamesAdapter;
import benawad.com.lolscout.adapters.RuneAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedPlayerFragment extends Fragment {

    public static final String TAG = FeaturedPlayerFragment.class.getSimpleName();

    public FeaturedPlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.featured_player_fragment, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity);

        String data = sharedPreferences.getString(MainActivity.FEATURED_PLAYER_KEY,
                getResources().getString(R.string.featured_player_def));
        String mVersion = sharedPreferences.getString(MainActivity.VERSION_KEY,
                getResources().getString(R.string.version_def));
        StaticData mStaticData = mainActivity.mStaticData;

        String[] info = data.split(",");
        String championId = info[0];
        String games = info[1];
        String wins = info[2];
        String losses = info[3];
        String kills = info[4];
        String deaths = info[5];
        String ast = info[6];
        String sum_name = info[7];
        String region = info[8];
        String champ = info[9];
        String sum1 = info[10];
        String sum2 = info[11];
        String item1 = info[12];
        String item2 = info[13];
        String item3 = info[14];
        String item4 = info[15];
        String item5 = info[16];
        String item6 = info[17];
        List<List<String>> runes = new ArrayList<>();
        for(int i = 18; i < info.length; i++){
            String runeCombo = info[i];
            String amount = getStringBetweenSymbol("(", ")", runeCombo);
            String runeId = getStringBetweenSymbol("[", "]", runeCombo);
            String description = getStringBetweenSymbol("#", "!", runeCombo);
            List<String> runeList = new ArrayList<>();
            runeList.add(amount);
            runeList.add(runeId);
            runeList.add(description);
            runes.add(runeList);
        }

        TextView name = (TextView) rootView.findViewById(R.id.fp_name);
        TextView league = (TextView) rootView.findViewById(R.id.fp_league);
        TextView totalGames = (TextView) rootView.findViewById(R.id.fp_games);
        TextView winsLoss = (TextView) rootView.findViewById(R.id.fp_win_loss);
        TextView killsView = (TextView) rootView.findViewById(R.id.fp_kills_text);
        TextView deathsView = (TextView) rootView.findViewById(R.id.fp_deaths_text);
        TextView assistsView = (TextView) rootView.findViewById(R.id.fp_assists_text);
        TextView champName = (TextView) rootView.findViewById(R.id.fp_champion_name);

        ImageView champImage = (ImageView) rootView.findViewById(R.id.fp_champion_image);
        ImageView sumView1 = (ImageView) rootView.findViewById(R.id.fp_spell1);
        ImageView sumView2 = (ImageView) rootView.findViewById(R.id.fp_spell2);
        ImageView itemView1 = (ImageView) rootView.findViewById(R.id.fp_item1);
        ImageView itemView2 = (ImageView) rootView.findViewById(R.id.fp_item2);
        ImageView itemView3 = (ImageView) rootView.findViewById(R.id.fp_item3);
        ImageView itemView4 = (ImageView) rootView.findViewById(R.id.fp_item4);
        ImageView itemView5 = (ImageView) rootView.findViewById(R.id.fp_item5);
        ImageView itemView6 = (ImageView) rootView.findViewById(R.id.fp_item6);

        name.setText(sum_name);
        league.setText("Challenger I");
        totalGames.setText(games + " Games");
        winsLoss.setText(MainActivity.getColoredGameRecord(Integer.parseInt(wins), Integer.parseInt(losses), mainActivity));
        killsView.setText(kills);
        deathsView.setText(deaths);
        assistsView.setText(ast);
        champName.setText(champ);

        int len = GamesAdapter.getLength(mainActivity);
        int length = len * 2;
        int championLength = len * 3;

        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/spell/" + mStaticData.getSpellImage(Integer.parseInt(sum1))).resize(length, length)
                .into(sumView1);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/spell/" + mStaticData.getSpellImage(Integer.parseInt(sum2))).resize(length, length)
                .into(sumView2);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                +mVersion+"/img/champion/" + mStaticData.getChampImage(Integer.parseInt(championId))).resize(championLength, championLength)
                .into(champImage);

        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/item/" + item1 + ".png").resize(length, length)
                .into(itemView1);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/item/" + item2 + ".png").resize(length, length)
                .into(itemView2);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/item/" + item3 + ".png").resize(length, length)
                .into(itemView3);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/item/" + item4 + ".png").resize(length, length)
                .into(itemView4);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/item/" + item5 + ".png").resize(length, length)
                .into(itemView5);
        Picasso.with(mainActivity).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/item/" + item6 + ".png").resize(length, length)
                .into(itemView6);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fp_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainActivity);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new RuneAdapter(mainActivity, runes);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public String getStringBetweenSymbol(String sym1, String sym2, String text){
        int loc1 = text.indexOf(sym1)+1;
        int loc2 = text.indexOf(sym2);
        return text.substring(loc1, loc2);
    }

}
