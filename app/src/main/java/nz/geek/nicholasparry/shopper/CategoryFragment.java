package nz.geek.nicholasparry.shopper;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by nick on 28/08/15.
 */
public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_item_list,container, false);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.categories, android.R.layout.simple_list_item_1);
        ListView list = (ListView)view.findViewById(android.R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SubcategoryFragment subcat = new SubcategoryFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("CatID", position);
                subcat.setArguments(bundle);
                ((MainActivity)getActivity()).fragMan.beginTransaction().replace(R.id.content_frame, subcat).commit();
            }
        });


        return view;
    }
}
