package com.nnthienphuc.n21dccn066_nguyenngocthienphuc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nnthienphuc.n21dccn066_nguyenngocthienphuc.model.Food;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ListView lvFood;
    ArrayList<Food> foodArrayList = new ArrayList<>();
    FirstFragmentAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_first, container, false);

        lvFood = v.findViewById(R.id.lvFood);

        // Add food items to the list
        foodArrayList.add(new Food("Bún bò Huế", R.drawable.bun_bo_hue_bowl, "Bún bò Huế is a popular Vietnamese soup containing rice vermicelli and beef."));
        foodArrayList.add(new Food("Cơm tấm", R.drawable.com_tam, "Cơm tấm, or broken rice, is a Vietnamese dish made from rice with fractured rice grains."));
        foodArrayList.add(new Food("Bánh đa cua", R.drawable.banh_da_cua, "Bánh đa cua is a Vietnamese noodle soup with a rich broth and crab meat."));

        adapter = new FirstFragmentAdapter(getActivity(), R.layout.fragment_first_listview, foodArrayList);
        lvFood.setAdapter(adapter);

        return v;
    }
}
