package com.vardhan.lab07;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    View view;

    // Creates a new fragment given an int and title
    public static FragmentB newInstance(int someInt, String someTitle) {
        FragmentB fragmentB = new FragmentB();
        Bundle args = new Bundle();//package variables into Bundle
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        fragmentB.setArguments(args);//assign bundle to arguments
        return fragmentB;
    }

    //View inflation/instantiation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container,false);
    }
    // Setup requiring access to View starts here
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        // Get back arguments
        int someInt = getArguments().getInt("someInt", 0);
        String someTitle = getArguments().getString("someTitle", "");

        //setup here
        TextView textView = view.findViewById(R.id.b_textview);
        textView.setText(someTitle);
        Button button = view.findViewById(R.id.b_button);
        String count = getString(R.string.count, someInt);
        button.setText(count);
    }

    // Parent Activity has finished loading, access parent views here
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}