package com.huwenmin.worryfree.myapplication;

/**
 * 使用WebView播放视频时需要注意的地方：
 * 1、加网络访问权限（及其他所需要的权限）；
 * 2、WebViewClient中方法shouldOverrideUrlLoading可用来实现点击webView页面的链接；
 * 3、WebView中播放视频需要添加webView.setWebChromeClient(new WebChromeClient())；
 * 4、视频竖屏时，点击全屏，想要切换到横屏全屏的状态，那么必须在Manifest.xml配置文件该Activity的
 * 	配置文件中添加android:configChanges="orientation|screenSize"语句。
 * 5、如果视频不能播放，或者播放比较卡，可以采用硬件加速，即在Application，或所在的Activity的配置文件中添加
 * 	android:hardwareAccelerated="true"即可。
 * @author zhongyao
 */

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.web_view);
        WebSettings ws = mWebView.getSettings();
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setSavePassword(true);
        ws.setSaveFormData(true);// 保存表单数据
        ws.setJavaScriptEnabled(true);
        ws.setGeolocationEnabled(true);// 启用地理定位
        ws.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");// 设置定位的数据库路径
        ws.setDomStorageEnabled(true);
        ws.setSupportMultipleWindows(true);// 新加
        WebChromeClient xwebchromeclient = new WebChromeClient();
        String userAgentString = mWebView.getSettings().getUserAgentString();
        Log.e("hahah",userAgentString);
        mWebView.setWebChromeClient(xwebchromeclient);
        mWebView.setWebViewClient(new myWebViewClient());
        mWebView.loadUrl("http://v.qq.com/x/page/y0021331xyl.html?ptag=huashu.tv&noapp=1");
    }

    public class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }




    @Override
    protected void onResume() {
        super.onResume();
        super.onResume();
        mWebView.onResume();
        mWebView.resumeTimers();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
        mWebView.pauseTimers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.loadUrl("about:blank");
        mWebView.stopLoading();
        mWebView.setWebChromeClient(null);
        mWebView.setWebViewClient(null);
        mWebView.destroy();
        mWebView = null;
    }

}
