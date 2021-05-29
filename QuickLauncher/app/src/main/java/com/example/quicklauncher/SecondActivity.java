package com.example.quicklauncher;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("com.example.quicklauncher.SOMETHING"))
        {
            // Get the TextView in second activity
            TextView tv = findViewById(R.id.textView);
            // Retrieve the text value which is sent from the main activity
            String text = getIntent().getExtras().getString("com.example.quicklauncher.SOMETHING");
            // Set the TextView with received value from the main activity
            tv.setText(text);
        }
    }
}