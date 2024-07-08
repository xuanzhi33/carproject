package cn.xuanzhi33.carproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.Manifest;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 屏幕常亮
        getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
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
        wv = findViewById(R.id.mainWV);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setGeolocationEnabled(true);
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

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (url.startsWith("https://gh.xuanzhi33.cn/carproject/") ||
                        url.startsWith("file:///android_asset/")) {
                    return false;
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            }
        });

        //webchromeclient
        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, android.webkit.GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                // 使用AlertDialog.Builder来构建自定义的对话框
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Info")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok, (dialog, which) -> result.confirm())
                        .create()
                        .show();

                // 返回true表示我们已经处理了这个对话框
                return true;
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
                // 创建一个EditText用于输入
                final EditText input = new EditText(MainActivity.this);
                input.setText(defaultValue);

                // 创建AlertDialog
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Info")
                        .setMessage(message)
                        .setView(input)
                        .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                            String value = input.getText().toString();
                            result.confirm(value); // 使用输入的值调用confirm
                        })
                        .setNegativeButton(android.R.string.cancel, (dialog, which) -> result.cancel())
                        .create()
                        .show();

                return true; // 返回true表示我们已经处理了这个对话框
            }
        });


        this.requestPermission();
    }

    private void requestPermission() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            this.startAPP();
        }
    }

    private void startAPP() {
        wv.loadUrl("file:///android_asset/load.html");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) { // 与requestPermissions请求中的requestCode相对应
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 权限被授予
                // 在这里执行您需要的操作，例如启动定位功能
                // load
                this.startAPP();
            } else {
                // 权限被拒绝
                // 在这里处理权限被拒绝的情况
                new AlertDialog.Builder(this)
                        .setTitle("Please grant permission")
                        .setMessage("We need location access to collect GPS data. If you do not give this permission, the APP will not be able to run." +
                                "You can go to the app settings to grant the permission.")
                        .setPositiveButton(android.R.string.ok, (dialog, which) -> requestPermission())
                        .create()
                        .show();
            }
            // 可以处理其他的权限请求
        }
    }
}