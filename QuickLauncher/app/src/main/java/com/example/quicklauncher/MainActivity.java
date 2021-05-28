package com.example.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find and declare names for all buttons used
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        Button googleSearchBtn = (Button) findViewById(R.id.googleBtn);

        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to go to the second activity
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);

                startIntent.putExtra("com.example.quicklauncher.SOMETHING", "Hello World!");
                // Passing information to another activity from one
                startActivity(startIntent);
            }
        });

        // Attempt to launch an activity outside our application
        googleSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googleLink = "http://www.google.com";
                Uri webAddress =  Uri.parse(googleLink);

                // Intent for opening google search page
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                // Check if it is possible find an application to open the URL, if yes, do so
                if (goToGoogle.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(goToGoogle);
                }
            }
        });
    }
}