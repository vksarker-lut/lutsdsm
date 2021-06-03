package com.example.learnerkid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SubMenuItemAdapter extends BaseAdapter {
    int[] images;
    String[] names;
    String[] details;
    LayoutInflater mInflater;

    public SubMenuItemAdapter(Context c, String[] n, String[] d, int[] i) {
        // Class Constructor
        names = n;
        details = d;
        images = i;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_fruit_veg_info, null);

        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewDetails = v.findViewById(R.id.textViewDetails);
        ImageView imageView = v.findViewById(R.id.imageView);

        String topic = names[position];
        String description = details[position];

        textViewName.setText(topic);
        textViewDetails.setText(description);
        imageView.setImageResource(images[position]);

        return v;
    }

}
