package com.nnthienphuc.advancedgridview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Image> images;
    GridView gridView;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view);

        images = new ArrayList<>();
        images.add(new Image(R.drawable.actor_1, "Image 1"));
        images.add(new Image(R.drawable.actor_2, "Image 2"));
        images.add(new Image(R.drawable.actor_3, "Image 3"));
        images.add(new Image(R.drawable.actor_4, "Image 4"));
        images.add(new Image(R.drawable.actor_5, "Image 5"));
        images.add(new Image(R.drawable.actor_6, "Image 6"));
        images.add(new Image(R.drawable.actor_7, "Image 7"));
        images.add(new Image(R.drawable.actor_8, "Image 8"));
        images.add(new Image(R.drawable.actor_9, "Image 9"));

        imageAdapter = new ImageAdapter(this, R.layout.image_cell, images);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Image image = images.get(position);
            Intent intent = new Intent(MainActivity.this, ImageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("image", image);
            intent.putExtra("data", bundle);
            startActivity(intent);
        });
    }
}