package com.nnthienphuc.demoimageview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    ImageView imageView;
    private int[] listButtonID = {R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7};

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
        init();
    }

    public void init() {
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.vitdonald);
        for (int id:listButtonID) {
            Button btnTemp = (Button) findViewById(id);
            btnTemp.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center Style");
                break;
            case R.id.button2:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center Crop Style");
                break;
            case R.id.button3:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center Inside Style");
                break;
            case R.id.button4:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center Center Style");
                break;
            case R.id.button5:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center FitEnd Style");
                break;
            case R.id.button6:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center FitStart Style");
                break;
            case R.id.button7:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                textView.setText("Center FitXY Style");
                break;
        }
    }
}