package com.rzzkan.scatsinging.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.rzzkan.scatsinging.R;

public class RefferenceActivity extends AppCompatActivity {

    public WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refference);
        mWebView = (WebView) findViewById(R.id.refference);
        mWebView.loadUrl("file:///android_asset/refference.html");
        getSupportActionBar().setTitle("Pustaka");

    }
}
