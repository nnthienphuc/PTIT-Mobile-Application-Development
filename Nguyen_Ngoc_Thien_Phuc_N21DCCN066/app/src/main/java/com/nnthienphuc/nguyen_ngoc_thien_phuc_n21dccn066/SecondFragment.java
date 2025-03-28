package com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model.Food;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    ListView lvFood;
    ArrayList<Food> foodArrayList = new ArrayList<>();
    SecondFragmentAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_2, container, false);

        lvFood = v.findViewById(R.id.lvFood);

        foodArrayList.add(new Food("Bun bo Hue", R.drawable.bun_bo_hue_bowl, "Food", 7.50));
        foodArrayList.add(new Food("Banh da cua", R.drawable.banh_da_cua, "Food", 8.25));
        foodArrayList.add(new Food("Com tam", R.drawable.com_tam, "Food", 1.50));
        foodArrayList.add(new Food("Xien nuong", R.drawable.banh_da_cua, "Food", 5.60));

        adapter = new SecondFragmentAdapter(getActivity(), R.layout.fragment_2_listview, foodArrayList);
        lvFood.setAdapter(adapter);

        return v;
    }
}
