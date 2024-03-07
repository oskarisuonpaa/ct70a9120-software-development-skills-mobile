package fi.lut.student.suonpaa.oskari.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater memberLayoutInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdapter (Context context, String[] items, String[] prices, String[] descriptions) {
        this.items = items;
        this.prices = prices;
        this.descriptions = descriptions;
        memberLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = memberLayoutInflater.inflate(R.layout.listview_detail, null);
        TextView nameTextView = itemView.findViewById(R.id.nameTextView);
        TextView priceTextView = itemView.findViewById(R.id.priceTextView);
        TextView descriptionTextView = itemView.findViewById(R.id.descriptionTextView);

        String name = items[i];
        String price = prices[i];
        String description = descriptions[i];

        nameTextView.setText(name);
        priceTextView.setText(price);
        descriptionTextView.setText(description);

        return itemView;
    }
}
