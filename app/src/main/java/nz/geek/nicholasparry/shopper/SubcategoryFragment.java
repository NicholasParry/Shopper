package nz.geek.nicholasparry.shopper;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;

import nz.geek.nicholasparry.shopper.tools.ItemViewAdapter;


public class SubcategoryFragment extends Fragment  {

    int imageArrayID;
    int nameID;
    int priceID;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);


        ItemViewAdapter itemViewAdapter = new ItemViewAdapter(getActivity(), R.array.cloth_icons, R.array.clothing_items, R.array.clothing_items_price);
        itemViewAdapter = null;

       // int

        switch (getArguments().getInt("CatID")){
            case 0:
                imageArrayID =R.array.shoe_icons;
                nameID = R.array.shoe_items;
                priceID = R.array.shoe_items_price;
                break;
            case 1:
                imageArrayID =R.array.cloth_icons;
                nameID = R.array.clothing_items;
                priceID = R.array.clothing_items_price;
                break;
            case 2:
                imageArrayID = R.array.electronic_icons;
                nameID = R.array.electronic_icons;
                priceID =  R.array.electronics_items_price;
                break;

        }

        itemViewAdapter = new ItemViewAdapter(getActivity(),imageArrayID, nameID, priceID);

        //itemViewAdapter.
        AbsListView list = (AbsListView)view.findViewById(android.R.id.list);
        list.setAdapter(itemViewAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("ImageArrayID", imageArrayID);
                bundle.putInt("NameID", nameID);
                bundle.putInt("PriceID", priceID);
                bundle.putInt("Position", position);
                bundle.putInt("CatID",getArguments().getInt("CatID"));
                DetailsFragment frag = new DetailsFragment();
                frag.setArguments(bundle);
                ((MainActivity) getActivity()).fragMan.beginTransaction().replace(R.id.content_frame, frag).commit();
            }
        });
        return view;
    }



}
