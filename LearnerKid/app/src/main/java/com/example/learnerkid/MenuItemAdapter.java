package com.example.learnerkid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MenuItemAdapter extends BaseAdapter {
    String[] topics;
    String[] descriptions;
    LayoutInflater mInflater;

    public MenuItemAdapter(Context c, String[] t, String[] d) {
        // Class Constructor
        topics = t;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return topics.length;
    }

    @Override
    public Object getItem(int position) {
        return topics[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_info, null);

        TextView textViewTopic = v.findViewById(R.id.textViewTopic);
        TextView textViewDescription = v.findViewById(R.id.textViewDescription);

        String topic = topics[position];
        String description = descriptions[position];

        textViewTopic.setText(topic);
        textViewDescription.setText(description);

        return v;
    }
}
