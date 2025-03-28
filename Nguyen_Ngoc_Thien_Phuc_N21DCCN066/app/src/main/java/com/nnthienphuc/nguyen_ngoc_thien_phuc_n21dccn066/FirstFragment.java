package com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model.Combo;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    GridView gridView;
    ArrayList<Combo> comboList;
    ComboGridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        gridView = view.findViewById(R.id.gridFood);

        // Dữ liệu mẫu
        comboList = new ArrayList<>();
        comboList.add(new Combo("Celery Smashes", R.drawable.combo1, 15));
        comboList.add(new Combo("Celery Smashes", R.drawable.combo2, 30));
        comboList.add(new Combo("Celery Smashes", R.drawable.combo3, 60));
        comboList.add(new Combo("Celery Smashes", R.drawable.combo4, 90));


        adapter = new ComboGridAdapter(getContext(), comboList, R.layout.fragment_1_gridview);
        gridView.setAdapter(adapter);

        return view;
    }
}
