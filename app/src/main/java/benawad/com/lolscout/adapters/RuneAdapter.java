package benawad.com.lolscout.adapters;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benawad.lolscout.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import benawad.com.lolscout.MainActivity;

/**
 * Created by benawad on 5/15/15.
 */
public class RuneAdapter extends RecyclerView.Adapter<RuneAdapter.ViewHolder> {

    public static final String TAG = RuneAdapter.class.getSimpleName();

    private Context mContext;
    private String mVersion;
    private List<List<String>> mRunes;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView count;
        TextView desc;

        public ViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.rune_image);
            count = (TextView) v.findViewById(R.id.rune_count);
            desc = (TextView) v.findViewById(R.id.rune_description);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RuneAdapter(Context context, List<List<String>> runes) {
        mRunes = runes;
        mContext = context;
        mVersion = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(MainActivity.VERSION_KEY, context.getResources().getString(R.string.version_def));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RuneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rune_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<String> runeList = mRunes.get(position);
        holder.count.setText(runeList.get(0)+"x");
        holder.desc.setText(runeList.get(2));
        int length = GamesAdapter.getLength(mContext);
        Picasso.with(mContext).load("http://ddragon.leagueoflegends.com/cdn/"
                + mVersion + "/img/rune/" + runeList.get(1)).resize(length, length)
                .into(holder.image);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mRunes.size();
    }

}
