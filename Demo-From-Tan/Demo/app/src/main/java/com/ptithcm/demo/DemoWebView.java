package com.ptithcm.demo;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DemoWebView extends AppCompatActivity {
    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_webview);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goButton(View v){
        String URL = editText.getText().toString();
        webView.loadUrl(URL);
    }
    public void backButton(View v){
        if (webView.canGoBack()){
            webView.goBack();
        }
    }
    public void reloadButton(View v){
        webView.reload();
    }
    public void forwardButton(View v){
        if (webView.canGoForward()){
            webView.goForward();
        }
    }
}