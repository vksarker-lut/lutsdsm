package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;

    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d) {
        // Class constructor
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_detail_advanced, null);
        TextView nameTextView = v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = v.findViewById(R.id.priceTextView);

        String name = items[position];
        String desc = descriptions[position];
        String cost = prices[position];

        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(cost);

        return v;
    }
}
