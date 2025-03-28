package com.nnthienphuc.n21dccn066_nguyenngocthienphuc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nnthienphuc.n21dccn066_nguyenngocthienphuc.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FirstFragmentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;

    public FirstFragmentAdapter(Context context, int layout, ArrayList<com.nnthienphuc.n21dccn066_nguyenngocthienphuc.model.Food> foodList) {
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
        TextView txtQuantity = convertView.findViewById(R.id.txtQuantity);
        ImageButton btnPlus = convertView.findViewById(R.id.btnPlus);
        ImageButton btnMinus = convertView.findViewById(R.id.btnMinus);

        Food food = foodList.get(position);

        txtName.setText(food.getName());
        txtDescription.setText(food.getDescription());
        imgPicture.setImageResource(food.getImage());
        txtQuantity.setText(String.valueOf(food.getQuantity()));

        // Bắt sự kiện nút +
        btnPlus.setOnClickListener(v -> {
            food.setQuantity(food.getQuantity() + 1);
            notifyDataSetChanged();
        });

        // Bắt sự kiện nút -
        btnMinus.setOnClickListener(v -> {
            if (food.getQuantity() > 0) {
                food.setQuantity(food.getQuantity() - 1);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

}
