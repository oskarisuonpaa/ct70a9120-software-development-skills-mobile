package fi.lut.student.suonpaa.oskari.quickapplauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("fi.lut.student.suonpaa.oskari.quickapplauncher.SOMETHING")) {
            TextView textView = findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("fi.lut.student.suonpaa.oskari.quickapplauncher.SOMETHING");
            textView.setText(text);
        }
    }
}