package benawad.com.lolscout.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.benawad.lolscout.R;
import com.google.gson.Gson;

import benawad.com.lolscout.MainActivity;
import benawad.com.lolscout.models.ranked_stats.Champions;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankedStatsFragment extends Fragment {


    public RankedStatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.ranked_stats_fragment, container, false);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String championsJson = sharedPreferences.getString(MainActivity.RANKED_STATS_KEY, getActivity().getResources().getString(R.string.ranked_stats_def));
        Gson gson = new Gson();
        Champions champions = gson.fromJson(championsJson, Champions.class);
        ((MainActivity) getActivity()).displayRankedStats(champions, rootView);
        return rootView;
    }


}
