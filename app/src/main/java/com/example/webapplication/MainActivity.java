package com.example.webapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("file:///android_asset/index.html");
        editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)){
                    if (editText.getText().toString().contains("index.html")){
                        webView.loadUrl("file:///android_asset/index.html");
                    }
                    else{
                        webView.loadUrl("http://"+editText.getText().toString());
                    }

                }
                return false;
            }
        });
    }
    public void refreshPage(View v){
        webView.reload();
    }

    public void nextPage(View v){
        if (webView.canGoForward()){
            webView.goForward();
        }
        else{
        }

    }
    public void previousPage(View v){
        if( webView.canGoBack()){
            webView.goBack();
        }
        else {
        }
    }


}
