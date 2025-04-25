package com.nnthienphuc.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    TextView tv;
//    Button btnStart, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

//        tv = (TextView) findViewById(R.id.textView);
//        btnStart = (Button) findViewById(R.id.buttonStart);
//        btnClose = (Button) findViewById(R.id.buttonClose);

        setContentView(R.layout.activity_main);
        Log.e("AAA", "On Create Main Activity");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e("AAA", "Start Main Activity");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("AAA", "On Restart Main Activity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e("AAA", "On Resume Main Activity");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e("AAA", "On Pause Main Activity");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e("AAA", "On Stop Main Activity");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("AAA", "On Destroy Main Activity");
    }

    public void ToActivity2(View view) {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public void ClosemainActivity(View view) {
        finish();
    }
}