package com.ptithcm.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void launchEditText(View v){
        Intent i = new Intent(this, DemoEditText.class);
        startActivity(i);
    }
    public void launchImageButton(View v){
        Intent i = new Intent(this, DemoImageButton.class);
        startActivity(i);
    }
    public void launchSeekBar(View v){
        Intent i = new Intent(this, DemoSeekBar.class);
        startActivity(i);
    }
    public void launchToast(View v){
        Intent i = new Intent(this, DemoToast.class);
        startActivity(i);
    }
    public void launchToggleButton(View v){
        Intent i = new Intent(this, DemoToggleButton.class);
        startActivity(i);
    }
    public void launchWebView(View v){
        Intent i = new Intent(this, DemoWebView.class);
        startActivity(i);
    }
}