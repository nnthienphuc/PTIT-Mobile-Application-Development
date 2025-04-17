package com.nnthienphuc.demowebview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        editText = findViewById(R.id.editTextUrl);
        webView.setWebViewClient(new WebViewClient());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onBackButtonClicked(View view) {
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }

    public void onForwardButtonClicked(View view) {
        if (webView.canGoForward()) {
            webView.goForward();
        }
    }

    public void onReloadButtonClicked(View view) {
        webView.reload();
    }

    public void onGoButtonClicked(View view) {
        webView.loadUrl(editText.getText().toString());
    }
}