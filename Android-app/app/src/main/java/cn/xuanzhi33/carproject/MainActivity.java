package cn.xuanzhi33.carproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWV();
    }

    @SuppressLint("SetJavaScriptEnabled")
    void initWV() {
        View mv = findViewById(R.id.mainView);
        // 获取当前的状态栏颜色
        int color = getWindow().getStatusBarColor();
        // 设置 mv 的背景色
        mv.setBackgroundColor(color);

        // id: mainWV
        WebView wv = findViewById(R.id.mainWV);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        // ua
        String ua = ws.getUserAgentString();
        ws.setUserAgentString(ua + " SensorAPP/1.0");

        //client
        wv.setWebViewClient(new WebViewClient() {
            //完成加载
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //淡入
                wv.animate().alpha(1).setDuration(500);
            }
        });

        //webchromeclient
        wv.setWebChromeClient(new WebChromeClient());

        // load
        wv.loadUrl("https://gh.xuanzhi33.cn/carproject/sensor.html");
    }
}