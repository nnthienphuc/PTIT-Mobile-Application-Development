package com.nnthienphuc.gridviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<HinhAnh> arrayHinhAnh;
    GridView gridView;
    HinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gvHinhAnh);

        arrayHinhAnh = new ArrayList<>();
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_1, "Hình số 1"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_2, "Hình số 2"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_3, "Hình số 3"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_4, "Hình số 4"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_5, "Hình số 5"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_6, "Hình số 6"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_7, "Hình số 7"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_8, "Hình số 8"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.hinh_9, "Hình số 9"));

        adapter = new HinhAnhAdapter(this, R.layout.cell_hinh_anh, arrayHinhAnh);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HinhAnh hinhAnh = arrayHinhAnh.get(position);

                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("anh", hinhAnh);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}