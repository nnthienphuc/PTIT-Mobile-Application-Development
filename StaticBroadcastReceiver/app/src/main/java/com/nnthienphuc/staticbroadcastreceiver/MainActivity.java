package com.nnthienphuc.staticbroadcastreceiver;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Button btnTurnOnWifi ;
// WifiManager wifiManager;
    private ExampleBroadcastReceiver exampleBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exampleBroadcastReceiver = new ExampleBroadcastReceiver();
// wifiManager = (WifiManager)
        getApplicationContext().getSystemService(Context.WIFI_SERVICE);
// btnTurnOnWifi = findViewById(R.id.btnTurnOnWifi);
// if(wifiManager.isWifiEnabled()){
// btnTurnOnWifi.setText("Turn wifi Off");
// } else if(!wifiManager.isWifiEnabled()) {
// btnTurnOnWifi.setText("Turn wifi On");
//
// }
// btnTurnOnWifi.setOnClickListener(new View.OnClickListener() {
// @Override
// public void onClick(View view) {
// //Toast.makeText(MainActivity.this, "" +
//        wifiManager.isWifiEnabled() , Toast.LENGTH_SHORT).show();
// if(wifiManager.isWifiEnabled() == true){
// btnTurnOnWifi.setText("Turn wifi On");
// wifiManager.setWifiEnabled(true);
// } else if(wifiManager.isWifiEnabled()== false) {
// btnTurnOnWifi.setText("Turn wifi Off");
// wifiManager.setWifiEnabled(false);
// }
// }
// });
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(exampleBroadcastReceiver,intentFilter);
    }
    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(exampleBroadcastReceiver);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}