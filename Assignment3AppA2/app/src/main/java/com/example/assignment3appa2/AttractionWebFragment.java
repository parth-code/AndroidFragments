package com.example.assignment3appa2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AttractionWebFragment extends Fragment {
    WebView webView;
    String url = null;

    void getUrlForWebsite(String url){
        if(webView !=null){
            webView.loadUrl(url);
        } else {
            webView.loadUrl("https://www.google.com");
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webview_fragment, container, false);
        webView = view.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return view;
    }

}
