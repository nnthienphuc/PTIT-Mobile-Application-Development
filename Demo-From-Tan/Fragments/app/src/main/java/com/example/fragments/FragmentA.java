package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {
    Button button;
    int count = 0;
    FragmentB.Counter counter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_a,container,false);
//        counter = (FragmentB.Counter) getActivity();
//        counter.inCreamentValue(count);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.isCreasementValue(count);
                counter = (FragmentB.Counter) getActivity();
                counter.inCreamentValue(count);
            }
        });
        return v;
    }
}