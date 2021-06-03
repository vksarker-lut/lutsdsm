package com.example.learnerkid;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    String[] topics;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewHeading = findViewById(R.id.textViewHeading);
        myListView = findViewById(R.id.myListView);

        Resources res = getResources();
        topics = res.getStringArray(R.array.topics);
        descriptions = res.getStringArray(R.array.descriptions);

        textViewHeading.setText(R.string.heading);

        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(this, topics, descriptions);
        myListView.setAdapter(menuItemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Log", "Position: " + position); //Debug purpose

                switch (position) {
                    case 0:
                        // Alphabets
                        Intent showAlphabetActivity = new Intent(getApplicationContext(), AlphabetActivity.class);
                        startActivity(showAlphabetActivity);
                        break;
                    case 1:
                        // Mathematics
                        Intent showMathActivity = new Intent(getApplicationContext(), MathActivity.class);
                        startActivity(showMathActivity);
                        break;
                    case 2:
                    case 3:
                        // Fruits or Vegetables
                        Intent showFruitVegActivity = new Intent(getApplicationContext(), FruitVegActivity.class);
                        showFruitVegActivity.putExtra("com.example.learnerkid.POSITION", position);
                        startActivity(showFruitVegActivity);
                        break;
                    default:
                        // Nothing happens here
                        break;
                }
            }
        });
    }
}