package com.nnthienphuc.viewpagernavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductCellAdapter extends BaseAdapter {
    private Context context;

    private List<ProductCell> productCells;

    private int layout;

    public ProductCellAdapter(Context context, int layout, List<ProductCell> productCells) {
        this.context = context;
        this.productCells = productCells;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return productCells.size();
    }

    @Override
    public Object getItem(int position) {
        return productCells.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView title = convertView.findViewById(R.id.itemTitle);
        TextView calories = convertView.findViewById(R.id.itemCalories);
        TextView carbs = convertView.findViewById(R.id.itemCarbs);
        TextView fat = convertView.findViewById(R.id.itemFat);
        TextView protein = convertView.findViewById(R.id.itemProtein);
        ProductCell productCell = productCells.get(position);
        imageView.setImageResource(productCell.getImage());
        title.setText(productCell.getName());
        calories.setText("Calories: " + productCell.getCalories());
        carbs.setText("Carbs: " + productCell.getCarbs() + "g");
        fat.setText("Fat: " + productCell.getFat() + "g");
        protein.setText("Protein: " + productCell.getProtein() + "g");
        return convertView;
    }
}
