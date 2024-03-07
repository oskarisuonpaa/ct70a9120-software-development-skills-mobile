package fi.lut.student.suonpaa.oskari.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int index = intent.getIntExtra("fi.lut.student.suonpaa.oskari.ITEM_INDEX", -1);

        if (index > -1) {
            int image = getImage(index);
            ImageView imageView = findViewById(R.id.imageView);
            scaleImage(imageView, image);
        }
    }

    private int getImage(int index) {
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    private void scaleImage(ImageView imageView, int image) {
        Display display = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), image, options);

        int imageWidth = options.outWidth;
        int displayWidth = display.getWidth();

        if (imageWidth > displayWidth) {
            int ratio = Math.round((float) imageWidth / (float) displayWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), image, options);
        imageView.setImageBitmap(scaledImage);
    }
}