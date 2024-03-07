package fi.lut.student.suonpaa.oskari.quickapplauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActivityButton = findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("fi.lut.student.suonpaa.oskari.quickapplauncher.SOMETHING", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });

        Button googleButton = findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String googleUrl = "http://www.google.com";
                Uri googleUri = Uri.parse(googleUrl);

                Intent googleIntent = new Intent(Intent.ACTION_VIEW, googleUri);
                if (googleIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(googleIntent);
                }
            }
        });
    }
}