package com.example.learnerkid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlphabetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        TextView textViewAlphabet = findViewById(R.id.textViewAlphabet);
        TextView textViewVowels = findViewById(R.id.textViewVowels);
        TextView textViewConsonants = findViewById(R.id.textViewConsonents);

        textViewAlphabet.setText(R.string.alphabet);
        textViewVowels.setText(R.string.vowels);
        textViewConsonants.setText(R.string.consonants);
    }
}