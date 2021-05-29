package com.example.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImage(index);
            ImageView img = findViewById(R.id.imageView);
            scaleImage(img, pic);
        }
    }

    private int getImage(int index) {
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomatoes;
            case 2: return R.drawable.grapes;
            case 3: return R.drawable.squash;
            default:
                return -1;
        }
    }

    private void scaleImage(ImageView img, int imgIndex) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), imgIndex, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float) imgWidth / (float) screenWidth );
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), imgIndex, options);
        img.setImageBitmap(scaledImg);
    }
}