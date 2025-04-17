package com.nnthienphuc.viewpagernavigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Product> productList;

    public ProductAdapter(Context context, int layout, List<Product> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
//anh xạ
        TextView title = convertView.findViewById(R.id.itemTitle);
        TextView description = convertView.findViewById(R.id.itemDescription);
        ImageView image = convertView.findViewById(R.id.itemImage);
        TextView price = convertView.findViewById(R.id.itemPrice);

        Product product = productList.get(position);
        title.setText(product.getName());
        description.setText(product.getDescription());
        image.setImageResource(product.getImage());
        price.setText(product.getPrice() + "$");
        return convertView;
    }
}
