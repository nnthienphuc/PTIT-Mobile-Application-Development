package com.example.activitylifecycle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class activity_3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("AAA", "Start Main Activity 2");
        //Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("AAA", "On Restart Main Activity 2");
        //Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.e("AAA", "onResume Main Activity 2");
        //Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause(){        super.onPause();
        Log.e("AAA", "onPause Main Activity 2");
        //Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("AAA", "onStop Main Activity 2");
        //Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("AAA", "onDestroy Main Activity 2");
        //Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }
    public void ToActivity1(View view) {
        Intent intent = new Intent(activity_3.this, MainActivity.class);
        startActivity(intent);
    }
    public void CloseActivity2(View view) { finish();
    }
}
