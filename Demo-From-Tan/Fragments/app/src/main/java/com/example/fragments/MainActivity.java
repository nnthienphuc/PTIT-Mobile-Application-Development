package com.example.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentB.Counter {
    FragmentA fragmentA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        fragmentA = new FragmentA();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.main,fragmentA);
//        transaction.commit();
//        getSupportFragmentManager().beginTransaction().add(R.id.main,fragmentA,"MyFragment").commit();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void inCreamentValue(int count) {
        FragmentB fragmentB;
        fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
        if(fragmentB != null){
            fragmentB.setTheCount(count);
        }
    }
//    public void isCreasementValue(int count){
//        FragmentB fragmentB;
//        fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
//        if(fragmentB != null){
//            fragmentB.setTheCount(count);
//        }
//    }
}