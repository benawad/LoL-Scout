package benawad.com.lolscout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by benawad on 5/15/15.
 */
public class StaticData {

    public static final String TAG = StaticData.class.getSimpleName();

    String mChampJson;
    String mSpellJson;
    Map<Integer, String> mChampMap;
    Map<Integer, String> mSpellMap;

    StaticData(String champ, String summ){
        mChampJson = champ;
        mSpellJson = summ;
        mChampMap = new HashMap<>();
        mSpellMap = new HashMap<>();

        try {
            JSONObject json = new JSONObject(mChampJson);
            JSONObject data = json.getJSONObject("data");
            Iterator i = data.keys();
            while (i.hasNext()){
                String key = ""+i.next();
                JSONObject champOb = data.getJSONObject(key);
                int id = champOb.getInt("id");
                String image = champOb.getJSONObject("image").getString("full");
                mChampMap.put(id, image);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject json = new JSONObject(mSpellJson);
            JSONObject data = json.getJSONObject("data");
            Iterator i = data.keys();
            while (i.hasNext()){
                String key = ""+i.next();
                JSONObject spellOb = data.getJSONObject(key);
                int id = spellOb.getInt("id");
                String image = spellOb.getJSONObject("image").getString("full");
                mSpellMap.put(id, image);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getChampImage(int id){
        return mChampMap.get(id);
    }

    public String getSpellImage(int id){
        return mSpellMap.get(id);
    }

}
