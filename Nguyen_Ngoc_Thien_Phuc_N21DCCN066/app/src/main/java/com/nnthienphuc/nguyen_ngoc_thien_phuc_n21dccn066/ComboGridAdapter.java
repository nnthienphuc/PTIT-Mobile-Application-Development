package com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nnthienphuc.nguyen_ngoc_thien_phuc_n21dccn066.model.Combo;

import java.util.List;

public class ComboGridAdapter extends BaseAdapter {
    private Context context;
    private List<Combo> comboList;
    private int layout;

    public ComboGridAdapter(Context context, List<Combo> comboList, int layout) {
            this.context = context;
            this.comboList = comboList;
            this.layout = layout;
    }

    @Override
    public int getCount() {
        return comboList.size();
    }

    @Override
    public Object getItem(int position) {
        return comboList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);

        ImageView img = convertView.findViewById(R.id.imgFood);
        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView info = convertView.findViewById(R.id.txtInfo);

        Combo f = comboList.get(position);
        img.setImageResource(f.getImage());
        title.setText(f.getName());
        info.setText(f.getTime() + " minutes");

        return convertView;
    }
}
