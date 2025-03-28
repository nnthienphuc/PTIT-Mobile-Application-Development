package com.example.advancedgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.advancedgridview.model.image;

import java.util.List;
public class HinhAnhAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<image> imageList;

    public HinhAnhAdapter(Context context, int layout, List<image> imageList) {
        this.context = context;
        this.layout = layout;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // gan view để ánh xạ
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ImageView imageView = view.findViewById(R.id.imgHinhAnh); // anh xa thong qua view
        image img = imageList.get(i); // lay doi tuong
        imageView.setImageResource(img.getHinh()); // set gia tri len view
        return view;
    }
}
