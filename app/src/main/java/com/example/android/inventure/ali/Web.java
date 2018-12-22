package com.example.android.inventure.ali;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.android.inventure.R;

public class Web extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);


        webView =findViewById(R.id.web);
        webView.loadUrl("http://myaquar.com");

    }


}
