package benawad.com.lolscout.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.benawad.lolscout.R;

import java.util.Arrays;

import benawad.com.lolscout.MainActivity;

public class SettingsFragment extends Fragment {

    public static final String TAG = SettingsFragment.class.getSimpleName();
    public static final String[] REGIONS = {"na", "euw", "eune", "br", "kr", "lan", "las", "oce",
            "ru", "tr"};

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.settings_layout, container, false);

        final SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getActivity());

        String defRegion = sharedPreferences.getString(MainActivity.REGION_KEY, "na");

        final RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton checkedRadio = (RadioButton) rootView.findViewById(checkedId);
//                String region = checkedRadio.getText().toString().toLowerCase();
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString(MainActivity.REGION_KEY, region);
//                editor.apply();
//            }
//        });

        RadioButton radioButton1 = (RadioButton) rootView.findViewById(R.id.na);
        RadioButton radioButton2 = (RadioButton) rootView.findViewById(R.id.euw);
        RadioButton radioButton3 = (RadioButton) rootView.findViewById(R.id.eune);
        RadioButton radioButton4 = (RadioButton) rootView.findViewById(R.id.br);
        RadioButton radioButton5 = (RadioButton) rootView.findViewById(R.id.kr);
        RadioButton radioButton6 = (RadioButton) rootView.findViewById(R.id.lan);
        RadioButton radioButton7 = (RadioButton) rootView.findViewById(R.id.las);
        RadioButton radioButton8 = (RadioButton) rootView.findViewById(R.id.oce);
        RadioButton radioButton9 = (RadioButton) rootView.findViewById(R.id.ru);
        RadioButton radioButton10 = (RadioButton) rootView.findViewById(R.id.tr);

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioButton10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String region = buttonView.getText().toString().toLowerCase();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MainActivity.REGION_KEY, region);
                    editor.apply();
                }
            }
        });

        radioGroup.clearCheck();

        if(Arrays.asList(REGIONS).indexOf(defRegion) == 0){
            radioButton1.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 1){
            radioButton2.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 2){
            radioButton3.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 3){
            radioButton4.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 4){
            radioButton5.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 5){
            radioButton6.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 6){
            radioButton7.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 7){
            radioButton8.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 8){
            radioButton9.performClick();
        }
        else if(Arrays.asList(REGIONS).indexOf(defRegion) == 9){
            radioButton10.performClick();
        }

        return rootView;
    }

}
