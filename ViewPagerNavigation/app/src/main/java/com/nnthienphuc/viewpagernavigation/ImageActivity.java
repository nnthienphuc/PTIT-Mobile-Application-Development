package com.nnthienphuc.viewpagernavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;
    TextView title;
    TextView calories;
    TextView carbs;
    TextView fat;
    TextView protein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.itemImage);
        title = findViewById(R.id.itemTitle);
        calories = findViewById(R.id.itemCalories);
        carbs = findViewById(R.id.itemCarbs);
        fat = findViewById(R.id.itemFat);
        protein = findViewById(R.id.itemProtein);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        ProductCell productCell = (ProductCell) bundle.getSerializable("productCell");
        imageView.setImageResource(productCell.getImage());
        title.setText(productCell.getName());
        calories.setText("Calories: " + productCell.getCalories());
        carbs.setText("Carbs: " + productCell.getCarbs() + "g");
        fat.setText("Fat: " + productCell.getFat() + "g");
        protein.setText("Protein: " + productCell.getProtein() + "g");
    }

    public void back(View view) {
        finish();
    }
}