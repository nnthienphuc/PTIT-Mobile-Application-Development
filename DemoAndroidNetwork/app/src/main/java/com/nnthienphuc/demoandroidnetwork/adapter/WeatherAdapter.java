package com.nnthienphuc.demoandroidnetwork.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nnthienphuc.demoandroidnetwork.R;
import com.nnthienphuc.demoandroidnetwork.model.WeatherForecastModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<WeatherForecastModel> arrayList;

    public WeatherAdapter(Context context, int layout, List<WeatherForecastModel> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_weather_item, null);
        }
        TextView txtTimeForecast =
                convertView.findViewById(R.id.txtTimeForecast);
        TextView txtTemperatureForecast =
                convertView.findViewById(R.id.txtTemperatureForecast);
        TextView txtWindForecast =
                convertView.findViewById(R.id.txtWindForecast);
        ImageView imgForecast =
                convertView.findViewById(R.id.imgForecast);
        WeatherForecastModel weatherForecastModel =  arrayList.get(position);
        txtTimeForecast.setText( "" +weatherForecastModel.getTime());
        txtTemperatureForecast.setText(weatherForecastModel.getTemperature()+"°C");
        txtWindForecast.setText(weatherForecastModel.getWindSpeed()+"km");
        Picasso.get().load("https:"+weatherForecastModel.getIcon()).into(imgForecast);
//imgForecast.src(weatherForecastModel.getTemperature());
        return convertView;
    }
}
