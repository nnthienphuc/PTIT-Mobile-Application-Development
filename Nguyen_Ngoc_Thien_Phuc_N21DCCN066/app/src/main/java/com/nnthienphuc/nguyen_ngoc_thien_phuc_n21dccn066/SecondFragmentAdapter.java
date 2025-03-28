package com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model.Food;

import java.util.ArrayList;
import java.util.List;

public class SecondFragmentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;

    public SecondFragmentAdapter(Context context, int layout, ArrayList<com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model.Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtName = convertView.findViewById(R.id.txtTen);
        TextView txtDescription = convertView.findViewById(R.id.txtMoTa);
        ImageView imgPicture = convertView.findViewById(R.id.imgHinh);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);

        Food food = foodList.get(position);

        txtName.setText(food.getName());
        txtDescription.setText(food.getDescription());
        imgPicture.setImageResource(food.getImage());
        txtPrice.setText("£" + String.format("%.2f", food.getPrice()));

        return convertView;
    }
}
