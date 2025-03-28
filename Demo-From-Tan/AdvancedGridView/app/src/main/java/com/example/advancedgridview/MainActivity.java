package com.example.advancedgridview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.advancedgridview.model.image;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<image> arrayImg;
    GridView gridView;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gvHinhAnh);
        arrayImg = new ArrayList<>();
        arrayImg.add(new image(R.drawable.a1,"Ngầu"));
        arrayImg.add(new image(R.drawable.a2,"Quá"));
        arrayImg.add(new image(R.drawable.a3,"Đi"));
        arrayImg.add(new image(R.drawable.a4,"Thật"));
        arrayImg.add(new image(R.drawable.a5,"Tuyệt"));
        arrayImg.add(new image(R.drawable.a7,"VỜi"));
        arrayImg.add(new image(R.drawable.a8,"Người"));
        arrayImg.add(new image(R.drawable.a9,"Ới"));
        arrayImg.add(new image(R.drawable.a10,"!!!!"));
        adapter = new HinhAnhAdapter(this,R.layout.cell_hinh_anh,arrayImg);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                image img = arrayImg.get(i);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("a",img);
                intent.putExtra("data",bundle);
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