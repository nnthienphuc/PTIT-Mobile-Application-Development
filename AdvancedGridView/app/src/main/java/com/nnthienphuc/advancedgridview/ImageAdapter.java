package com.nnthienphuc.advancedgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context context;

    private List<Image> images;

    private int layout;

    public ImageAdapter(Context context, int layout, List<Image> images) {
        this.context = context;
        this.images = images;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        ImageView imageView = convertView.findViewById(R.id.img_view);
        Image image = images.get(position);
        imageView.setImageResource(image.getImage());
        return convertView;
    }
}
