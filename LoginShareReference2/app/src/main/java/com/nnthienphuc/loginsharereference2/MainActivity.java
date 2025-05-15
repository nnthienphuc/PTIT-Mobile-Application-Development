package com.nnthienphuc.loginsharereference2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    CheckBox rememberMe;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.initAndMappingViews();
        this.checkLogin();  //--Check if "Remember me" is checked & User's already logged-in.

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("123123")) {
                    if (rememberMe.isChecked()) {
                        SharedPreferences sharedPreferences =
                                getSharedPreferences("login_check", MODE_PRIVATE);
                        SharedPreferences.Editor editor =
                                sharedPreferences.edit();
                        editor.putString("login", "true");
                        editor.apply();
                    }

                    Intent intent = new
                            Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initAndMappingViews() {
        username = findViewById(R.id.username_edt);
        password = findViewById(R.id.password_edt);
        btnLogin = findViewById(R.id.login_btn);
        rememberMe = findViewById(R.id.rememberMe);
    }

    private void checkLogin() {
        var sharedPreferences = this.getSharedPreferences("login_check", MODE_PRIVATE);
        String login = sharedPreferences.getString("login", "");
        if (login.equals("true")) {
            Intent homePage = new Intent(MainActivity.this, Home.class);
            this.startActivity(homePage);
        }
    }
}