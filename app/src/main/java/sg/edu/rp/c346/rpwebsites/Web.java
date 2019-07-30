package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Web extends AppCompatActivity {
   WebView wv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        wv = findViewById(R.id.web);

        Intent intentReceived = getIntent();

        String url = intentReceived.getStringExtra("web");

        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true); //enable java script execution
        wv.getSettings().setAllowFileAccessFromFileURLs(false); //disable file access within webview
        wv.getSettings().setDisplayZoomControls(true); //enable the built-in zoom control for the webview


        wv.loadUrl(url);
    }
}
