package com.nnthienphuc.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    Button btnClickMe;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edtName = findViewById(R.id.edtName);
        btnClickMe = findViewById(R.id.btnClickMe);
        txtName = findViewById(R.id.txtName);

        // Gắn sự kiện cho nút bấm
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtName.getText().toString().trim();
                if (!username.isEmpty()) {
                    txtName.setText("Welcome " + username);
                } else {
                    txtName.setText("Please enter your name!");
                }
            }
        });
    }
}
