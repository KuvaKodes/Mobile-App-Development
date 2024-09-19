package com.vardhan.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    EditText simple_EditText;
    Button display_text;
    TextView displayName;
    RadioButton leftRadBut, rightRadBut;
    int count = 0;
    String[] planets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        display_text = findViewById(R.id.displayText);
        simple_EditText = findViewById(R.id.simpleEditText);
        displayName = findViewById(R.id.display_name);
        leftRadBut = findViewById(R.id.radio_left);
        rightRadBut = findViewById(R.id.radio_right);
        planets = getResources().getStringArray(R.array.planets_array);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightRadBut.isChecked())
                    count = ++count % planets.length;
                greetingDisplay.setText(planets[count]);
//                System.out.println("incrementing: "+ ++count);
//                Log.i("incrementing", String.valueOf(count));
//                greetingDisplay.setText(getString(R.string.likes_count, count));
//                if (count > 15) {
//                    incrementButton.setVisibility(View.INVISIBLE);
//                }
            }
        });
        display_text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (simple_EditText.getText().toString() != null)
                {
                    displayName.setText(simple_EditText.getText().toString());
                }
            }
        });

    }

    public void decrement(View view) {
//        System.out.println("decrementing: "+ --count);
//        Log.i("decrementing", String.valueOf(count));
//        greetingDisplay.setText(getString(R.string.likes_count, count));
//        if (count < -15) {
//            view.setVisibility(View.INVISIBLE);
//        }
        if(leftRadBut.isChecked())
            if(--count < 0) count = planets.length-1;
        greetingDisplay.setText(planets[count]);
    }
}