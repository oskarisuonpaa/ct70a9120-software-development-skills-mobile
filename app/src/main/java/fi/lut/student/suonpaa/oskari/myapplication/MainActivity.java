package fi.lut.student.suonpaa.oskari.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumberEditText = (EditText) findViewById(R.id.firstNumberEditText);
                EditText secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                int first = Integer.parseInt(firstNumberEditText.getText().toString());
                int second = Integer.parseInt(secondNumberEditText.getText().toString());
                int sum = first + second;

                resultTextView.setText(Integer.toString(sum));
            }
        });
    }
}