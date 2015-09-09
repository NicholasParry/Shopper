package nz.geek.nicholasparry.shopper.tools;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nz.geek.nicholasparry.shopper.R;

/**
 * Created by nick on 28/08/15.
 */
public class ItemViewAdapter extends BaseAdapter {

    Context context;
    TypedArray icons;
    String[] names;
    String[] prices;

    private static LayoutInflater inflater;

    public ItemViewAdapter(Context context, int icons, int names, int prices) {
        this.context = context;
        this.icons = context.getResources().obtainTypedArray(icons);
        this.names = context.getResources().getStringArray(names);
        this.prices = context.getResources().getStringArray(prices);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public ItemViewAdapter(Context context, TypedArray icons, String[] names, String[] prices) {
        this.context = context;
        this.icons = icons;
        this.names = names;
        this.prices = prices;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        Holder holder = new Holder();

        if(rowView == null){
            holder = new Holder();
            rowView = inflater.inflate(R.layout.item_view, null);

            holder.image = (ImageView)rowView.findViewById(R.id.item_view_image);
            holder.name = (TextView)rowView.findViewById(R.id.item_view_name);
            holder.price = (TextView)rowView.findViewById(R.id.item_view_price);

            rowView.setTag(holder);
        } else {
            holder = (Holder)rowView.getTag();
        }


        holder.image.setImageDrawable(icons.getDrawable(position));
        holder.name.setText(names[position]);
        holder.price.setText(prices[position]);


        return rowView;
    }

    public class Holder{
        ImageView image;
        TextView name;
        TextView price;

    }
}
