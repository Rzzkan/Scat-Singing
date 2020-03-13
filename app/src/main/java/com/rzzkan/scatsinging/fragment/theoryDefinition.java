package com.rzzkan.scatsinging.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


import com.rzzkan.scatsinging.R;


public class theoryDefinition extends Fragment {

    public WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_theory_definition, container, false);

        mWebView = (WebView) v.findViewById(R.id.definition);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/definition.html");
        mWebView.requestFocus();

        // Inflate the layout for this fragment
        return v;
    }

}
