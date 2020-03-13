package com.rzzkan.scatsinging.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.rzzkan.scatsinging.R;

public class DeveloperActivity extends AppCompatActivity {

    public WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        mWebView = (WebView) findViewById(R.id.profil);
        mWebView.loadUrl("file:///android_asset/profil.html");
        getSupportActionBar().setTitle("Pengembang");

    }
}
