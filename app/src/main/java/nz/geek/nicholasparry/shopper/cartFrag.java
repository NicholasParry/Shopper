package nz.geek.nicholasparry.shopper;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

/**
 * Created by nick on 28/08/15.
 */
public class cartFrag extends Fragment {

    SharedPreferences prefs;

    String[] items;
    String[] prices;
    int[] icons;
    int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cartlayout, container, false);
        prefs = getActivity().getSharedPreferences("cart", Context.MODE_PRIVATE);
        Map<String, ?> prods = prefs.getAll();

        index = 0;

        items = new String[prods.size()];
        prices = new String[prods.size()];
        icons = new int[prods.size()];

        for(Map.Entry<String, ?>entry : prods.entrySet()){
            String[] s = entry.getKey().split("$");
            items[index] = s[0];
            prices[index] = s[1];
            icons[index] = Integer.parseInt(s[2]);
            index++;
        }

        //ItemViewAdapter adapter = new ItemViewAdapter(getActivity())



        return v;
    }
}
