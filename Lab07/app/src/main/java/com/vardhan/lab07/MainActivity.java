package com.vardhan.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Replace the contents of the container with the new fragment
        ft.add(R.id.fragment_container, FragmentB.newInstance(4,"Hello SuperStar"),"FragmentName");
        //or ft.replace(R.id.fragment_container, new FragmentB());

        // Complete the changes added above
        ft.commit();
    }

    public void update_greeting(View view) {
        //access the fragment by tag
        FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentName");
        if(fragmentB!=null)
            ((TextView)fragmentB.view.findViewById(R.id.b_textview)).setText(R.string.greeting2);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_up,R.animator.slide_down);
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_container, FragmentB.newInstance(3,"Hello RockStar"),"BetterFragment");
        // Complete the changes added above
        ft.commit();
    }

    public void fragment_button_onclick(View view) {
        ((Button)view).setText(R.string.clicked_message);
    }
}