package com.vardhan.lab7;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, FragmentB.newInstance(99, "RulerOfTheWorld"), "FragmentB");
        ft.commit();
    }

    public void update_greeting(View view) {
        FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentB");
        ((TextView)fragmentB.view.findViewById(R.id.b_textview)).setText(R.string.greeting2);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_up,R.animator.slide_down);
        ft.replace(R.id.fragment_container, FragmentB.newInstance(3,"Hello RockStar"),"BetterFragment");
        ft.commit();
    }
}