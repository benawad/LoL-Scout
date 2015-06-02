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
import com.google.gson.GsonBuilder;

import benawad.com.lolscout.MainActivity;
import benawad.com.lolscout.customs.ItemTypeAdapterFactory;
import benawad.com.lolscout.models.match_history.Games;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchHistoryFragment extends Fragment {

    public static final String TAG = MatchHistoryFragment.class.getSimpleName();

    public MatchHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.match_history_fragment, container, false);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String gamesJson = sharedPreferences.getString(MainActivity.MATCH_HISTORY_KEY, getActivity().getResources().getString(R.string.match_history_def));
        String stripName = sharedPreferences.getString(MainActivity.STRIPPED_NAME_KEY, getActivity().getResources().getString(R.string.name_def));
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(
                new ItemTypeAdapterFactory(stripName)).create();
        Games games = gson.fromJson(gamesJson, Games.class);
        ((MainActivity) getActivity()).displayMatchHistory(games, rootView);
        return rootView;
    }


}
