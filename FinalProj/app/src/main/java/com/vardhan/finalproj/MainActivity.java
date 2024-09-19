package com.vardhan.finalproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_entry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateButton(v);
                startActivity(new Intent(MainActivity.this, AddEntryActivity.class));
            }
        });

        findViewById(R.id.btn_view_entries).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateButton(v);
                startActivity(new Intent(MainActivity.this, EntryListActivity.class));
            }
        });
    }

    private void animateButton(View view) {
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.5f);
        animation.setDuration(100);
        animation.setRepeatCount(1);
        animation.setRepeatMode(AlphaAnimation.REVERSE);
        view.startAnimation(animation);
    }
}
