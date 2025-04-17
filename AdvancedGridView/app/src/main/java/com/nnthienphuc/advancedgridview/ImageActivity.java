package com.nnthienphuc.advancedgridview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.img_view);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Image image = (Image) bundle.getSerializable("image");
        imageView.setImageResource(image.getImage());
    }

    public void back(View view) {
        finish();
    }
}