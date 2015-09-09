package nz.geek.nicholasparry.shopper;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nick on 28/08/15.
 */
public class DetailsFragment extends Fragment {

    String itemName;
    String itemPrice;
    int itemImgID;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle bundle = getArguments();
        itemName = ((view.getResources().getStringArray(bundle.getInt("NameID")))[bundle.getInt("Position")]).toString();
        itemPrice = ((view.getResources().getStringArray(bundle.getInt("PriceID")))[bundle.getInt("Position")]);
        itemImgID = view.getResources().obtainTypedArray(bundle.getInt(("ImageArrayID"))).getResourceId((bundle.getInt("Position")),0);



        //view.getResources().obtainTypedArray(bundle.getInt("ImageArrayID"))

        ((TextView) view.findViewById(R.id.fragDName)).setText(((view.getResources().getStringArray(bundle.getInt("NameID")))[bundle.getInt("Position")]).toString());
        ((TextView)view.findViewById(R.id.fragDPrice)).setText((view.getResources().getStringArray(bundle.getInt("PriceID")))[bundle.getInt("Position")]);
        ((ImageView)view.findViewById(R.id.fragdImage)).setImageDrawable((view.getResources().obtainTypedArray(bundle.getInt("ImageArrayID"))).getDrawable(bundle.getInt("Position")));
        //return view;


        getActivity().findViewById(R.id.addToCartButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getActivity().getSharedPreferences("cart", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                String s = itemName + "$" + itemPrice + "$" + itemImgID;
                edit.putString(s,s);
                edit.commit();
                Toast.makeText(getActivity(), "Added To Cart", Toast.LENGTH_SHORT).show();


            }
        });




        return view;
    }
}
