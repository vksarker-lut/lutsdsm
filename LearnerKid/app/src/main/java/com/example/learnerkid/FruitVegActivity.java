package com.example.learnerkid;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FruitVegActivity extends AppCompatActivity {
    int[] fruits_images;
    int[] veg_images;
    String[] fruits;
    String[] veg;
    String[] fruits_details;
    String[] veg_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_veg);

        Intent intentMenu = getIntent();
        int position = intentMenu.getIntExtra("com.example.learnerkid.POSITION", -1);

        TextView textViewFruitVeg = findViewById(R.id.textViewCategory);
        ListView myFruitVegView = findViewById(R.id.myFruitVegView);

        Resources res = getResources();
        fruits = res.getStringArray(R.array.fruits);
        veg = res.getStringArray(R.array.vegetables);
        fruits_details = res.getStringArray(R.array.fruits_details);
        veg_details = res.getStringArray(R.array.vegetables_details);
        fruits_images = new int[] {
                R.drawable.fruit_apple,
                R.drawable.fruit_orange,
                R.drawable.fruit_banana,
                R.drawable.fruit_grapes,
                R.drawable.fruit_mango
        };
        veg_images = new int[] {
                R.drawable.veg_potato,
                R.drawable.veg_tomato,
                R.drawable.veg_cucumber,
                R.drawable.veg_spinach,
                R.drawable.veg_pumpkin
        };

        if (position == 2) {
            textViewFruitVeg.setText("Five Fruits");
            SubMenuItemAdapter subMenuItemAdapter = new SubMenuItemAdapter(this, fruits, fruits_details, fruits_images);
            myFruitVegView.setAdapter(subMenuItemAdapter);

        } else if (position == 3) {
            textViewFruitVeg.setText("Five Vegetables");
            SubMenuItemAdapter subMenuItemAdapter = new SubMenuItemAdapter(this, veg, veg_details, veg_images);
            myFruitVegView.setAdapter(subMenuItemAdapter);
        }

    }

//    private int getImage(int position, String category) {
//        if (category == "fruits") {
//            switch (position) {
//                case 0: return R.drawable.fruit_apple;
//                case 1: return R.drawable.fruit_orange;
//                case 2: return R.drawable.fruit_banana;
//                case 3: return R.drawable.fruit_grapes;
//                case 4: return R.drawable.fruit_mango;
//                default:
//                    return -1;
//            }
//        }
//        else if (category == "vegetables") {
//            switch (position) {
//                case 0: return R.drawable.veg_potato;
//                case 1: return R.drawable.veg_tomato;
//                case 2: return R.drawable.veg_cucumber;
//                case 3: return R.drawable.veg_spinach;
//                case 4: return R.drawable.veg_pumpkin;
//                default:
//                    return -1;
//            }
//        }
//
//        return -1;
//    }
}