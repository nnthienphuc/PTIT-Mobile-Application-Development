package com.nnthienphuc.viewpagernavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    ArrayList<ProductCell> productCells;
    GridView gridView;
    ProductCellAdapter productCellAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        gridView = v.findViewById(R.id.grid_view);

        productCells = new ArrayList<>();
        productCells.add(new ProductCell(R.drawable.g1, "Celary Smashers with Cream Gravy", 471, 4.5, 10, 1));
        productCells.add(new ProductCell(R.drawable.g2, "Brussels Sprouts with Browned Butter", 152, 4.5, 10, 1));
        productCells.add(new ProductCell(R.drawable.g3, "Baked Fennel with Parmesan", 300, 12.3, 25.9, 6.8));
        productCells.add(new ProductCell(R.drawable.g4, "Sautéed Kale with Coconut Milk", 129, 13.1, 3.1, 6.8));
        productCells.add(new ProductCell(R.drawable.g5, "Roasted Carrots with Orange", 129, 13.1, 3.1, 6.8));
        productCells.add(new ProductCell(R.drawable.g6, "Cauliflower with Brown Butter", 129, 13.1, 3.1, 6.8));

        productCellAdapter = new ProductCellAdapter(requireContext(), R.layout.gridview_item, productCells);
        gridView.setAdapter(productCellAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            ProductCell productCell = productCells.get(position);
            Intent intent = new Intent(requireContext(), ImageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("productCell", productCell);
            intent.putExtra("data", bundle);
            startActivity(intent);
        });
        return v;
    }
}
