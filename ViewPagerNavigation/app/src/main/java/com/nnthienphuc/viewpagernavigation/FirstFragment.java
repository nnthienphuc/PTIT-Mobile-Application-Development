package com.nnthienphuc.viewpagernavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ListView lvProduct;
    ArrayList<Product> productArrayList = new ArrayList<>();
    ProductAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        lvProduct = v.findViewById(R.id.lvProduct);
        productArrayList.add(new Product("Item1", R.drawable.i1, "Information of Item1", 6));
        productArrayList.add(new Product("Item2", R.drawable.i2, "Information of Item2", 5));
        productArrayList.add(new Product("Item3", R.drawable.i3, "Information of Item3", 4));
        productArrayList.add(new Product("Item4", R.drawable.i4, "Information of Item4", 4));
        productArrayList.add(new Product("Item5", R.drawable.i5, "Information of Item5", 10));
        adapter = new ProductAdapter(requireContext(), R.layout.listview_item, productArrayList);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int i, long l) {
            }
        });
        return v;
    }
}
