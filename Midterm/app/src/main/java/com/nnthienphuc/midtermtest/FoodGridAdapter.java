package com.nnthienphuc.midtermtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nnthienphuc.midtermtest.model.Food;
import com.nnthienphuc.midtermtest.model.Food2;

import java.util.List;

public class FoodGridAdapter extends BaseAdapter {
    private Context context;
    private List<Food2> foodList;
    private int layout;

    public FoodGridAdapter(Context context, int layout, List<Food2> foodList) {
        this.context = context;
        this.foodList = foodList;
        this.layout = layout;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);

        ImageView img = convertView.findViewById(R.id.imgFood);
        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView info = convertView.findViewById(R.id.txtInfo);

        Food2 f = foodList.get(position);
        img.setImageResource(f.getImage());
        title.setText(f.getName());
        info.setText("Calories: " + f.getCalories() +
                " | Protein: " + f.getProtein() +
                "g | Fat: " + f.getFat() + "g");

        return convertView;
    }
}

