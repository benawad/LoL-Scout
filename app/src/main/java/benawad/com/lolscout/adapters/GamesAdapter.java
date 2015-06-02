package benawad.com.lolscout.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.benawad.lolscout.R;
import com.squareup.picasso.Picasso;

import benawad.com.lolscout.MainActivity;
import benawad.com.lolscout.StaticData;
import benawad.com.lolscout.models.match_history.Game;
import benawad.com.lolscout.models.match_history.GameStats;
import benawad.com.lolscout.models.match_history.Games;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {
    private Games mGames;
    private Context mContext;
    private String mVersion;
    private StaticData mStaticData;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item1;
        ImageView item2;
        ImageView item3;
        ImageView item4;
        ImageView item5;
        ImageView item6;
        ImageView spell1;
        ImageView spell2;
        ImageView champion;
        TextView kills;
        TextView assists;
        TextView deaths;
        LinearLayout base;


        public ViewHolder(View v) {
            super(v);

            item1 = (ImageView) v.findViewById(R.id.g_item1);
            item2 = (ImageView) v.findViewById(R.id.g_item2);
            item3 = (ImageView) v.findViewById(R.id.g_item3);
            item4 = (ImageView) v.findViewById(R.id.g_item4);
            item5 = (ImageView) v.findViewById(R.id.g_item5);
            item6 = (ImageView) v.findViewById(R.id.g_item6);
            spell1 = (ImageView) v.findViewById(R.id.g_spell1);
            spell2 = (ImageView) v.findViewById(R.id.g_spell2);
            champion = (ImageView) v.findViewById(R.id.g_champion);
            kills = (TextView) v.findViewById(R.id.g_kills_text);
            assists = (TextView) v.findViewById(R.id.g_assists_text);
            deaths = (TextView) v.findViewById(R.id.g_deaths_text);
            base = (LinearLayout) v.findViewById(R.id.base_row);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GamesAdapter(Games myDataset, StaticData data, Context context) {
        mGames = myDataset;
        mContext = context;
        mStaticData = data;
        mVersion = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(MainActivity.VERSION_KEY, context.getResources().getString(R.string.version_def));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public GamesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Game game = mGames.getGames().get(position);
        GameStats gameStats = game.getStats();

        Resources resources = mContext.getResources();
        if(gameStats.isWin()){
            holder.base.setBackgroundDrawable(resources.getDrawable(R.drawable.customboarder_win));
        }
        else{
            holder.base.setBackgroundDrawable(resources.getDrawable(R.drawable.customboarder_lose));
        }

        int length = getLength(mContext);

        if(gameStats.getItem0() != 0) {
            Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                    + mVersion + "/img/item/" + gameStats.getItem0() + ".png").resize(length, length)
                    .into(holder.item1);
        }
        else{
            Picasso.with(mContext).load(R.drawable.emptyicon_item).resize(length, length)
                    .into(holder.item1);
        }
        if(gameStats.getItem1() != 0) {
            Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                    + mVersion + "/img/item/" + gameStats.getItem1() + ".png").resize(length, length)
                    .into(holder.item2);
        }
        else{
            Picasso.with(mContext).load(R.drawable.emptyicon_item).resize(length, length)
                    .into(holder.item2);
        }
        if(gameStats.getItem2() != 0) {
            Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                    + mVersion + "/img/item/" + gameStats.getItem2() + ".png").resize(length, length)
                    .into(holder.item3);
        }
        else{
            Picasso.with(mContext).load(R.drawable.emptyicon_item).resize(length, length)
                    .into(holder.item3);
        }
        if(gameStats.getItem3() != 0) {
            Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                    + mVersion + "/img/item/" + gameStats.getItem3() + ".png").resize(length, length)
                    .into(holder.item4);
        }
        else{
            Picasso.with(mContext).load(R.drawable.emptyicon_item).resize(length, length)
                    .into(holder.item4);
        }
        if(gameStats.getItem4() != 0) {
            Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                    + mVersion + "/img/item/" + gameStats.getItem4() + ".png").resize(length, length)
                    .into(holder.item5);
        }
        else{
            Picasso.with(mContext).load(R.drawable.emptyicon_item).resize(length, length)
                    .into(holder.item5);
        }
        if(gameStats.getItem5() != 0) {
            Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                    + mVersion + "/img/item/" + gameStats.getItem5() + ".png").resize(length, length)
                    .into(holder.item6);
        }
        else{
            Picasso.with(mContext).load(R.drawable.emptyicon_item).resize(length, length)
                    .into(holder.item6);
        }



        Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/spell/" + mStaticData.getSpellImage(game.getSpell1())).resize(length, length)
                .into(holder.spell1);
        Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/spell/" + mStaticData.getSpellImage(game.getSpell2())).resize(length, length)
                .into(holder.spell2);

        int championLength = length * 2;

        Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                +mVersion+"/img/champion/" + mStaticData.getChampImage(game.getChampionId())).resize(championLength, championLength)
                .into(holder.champion);

        holder.kills.setText("" + gameStats.getChampionsKilled());
        holder.deaths.setText("" + gameStats.getNumDeaths());
        holder.assists.setText(""+gameStats.getAssists());

    }

    public static int getLength(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x / 8;

        if(width > 150){
            width = 150;
        }

        return width;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mGames.getGames().size();
    }
}
