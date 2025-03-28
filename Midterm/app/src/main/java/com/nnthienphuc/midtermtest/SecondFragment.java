package com.nnthienphuc.midtermtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nnthienphuc.midtermtest.model.Food2;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    GridView gridFood;
    ArrayList<Food2> foodList;
    FoodGridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        gridFood = view.findViewById(R.id.gridFood);

        // Dữ liệu mẫu
        foodList = new ArrayList<>();
        foodList.add(new Food2("Celery Smashes", R.drawable.bun_bo_hue_bowl, 47, 3, 1));
        foodList.add(new Food2("Brussels Sprouts", R.drawable.bun_bo_hue_bowl, 102, 4, 3));
        foodList.add(new Food2("Baked Fennel", R.drawable.bun_bo_hue_bowl, 110, 6, 2));
        foodList.add(new Food2("Kale Coconut", R.drawable.bun_bo_hue_bowl, 127, 5, 2));

        adapter = new FoodGridAdapter(getContext(), R.layout.fragment_second_gridview, foodList);
        gridFood.setAdapter(adapter);

        return view;
    }
}

