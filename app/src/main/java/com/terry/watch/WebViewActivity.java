package com.terry.watch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.util.os.NetworkUtil;
import com.terry.watch.webview.LoadingBar;

/**
 * @author 张全
 */
public class WebViewActivity extends FragmentActivity {
    private WebView webView;
    private ProgressBar progressBar;
    private LoadingBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_webview);
        init();
    }

    private void init() {
        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.pb);
        loadingBar = findViewById(R.id.loadingBar);
        loadingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!loadingBar.canLoading()) {
                    return;
                }
                if (!NetworkUtil.isNetworkAvailable(WebViewActivity.this)) {
                    Toast.makeText(WebViewActivity.this, R.string.net_noconnection, Toast.LENGTH_SHORT).show();
                    return;
                }
                webView.reload();
            }
        });


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        //
        webSettings.setUserAgentString("Android");
        //设置缓存
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.clearCache(true);

//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setAllowUniversalAccessFromFileURLs(true);


//        webViewParam.url = "file:///android_asset/test2.html";


        webView.loadUrl("http://monitor.ppsyw.cn/live/user/homepage?uid=fvs");
        webView.setWebChromeClient(new DWebChromeClient());
        webView.setWebViewClient(new DWebViewClient());
        webView.setDownloadListener(new DWebViewDownLoadListener());
    }

    /**
     * 辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
     */
    private final class DWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
//            AlertDialogView dialogView = new AlertDialogView(webView.getContext())
//                    .setTitle("提示")
//                    .setContent(message)//
//                    .setSingleBtn("确定", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            result.confirm();
//                        }
//                    });
//
//            new EffectDialogBuilder(webView.getContext())
//                    .setCancelable(false)
//                    .setCancelableOnTouchOutside(false)
//                    .setContentView(dialogView).show();
//            return true;

            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            return super.onJsBeforeUnload(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
//            AlertDialogView dialogView = new AlertDialogView(webView.getContext())
//                    .setContent(message)//
//                    .setRightBtn("确定", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            result.confirm();
//                        }
//                    })
//                    .setLeftBtn("取消", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            result.cancel();
//                        }
//                    });
//            new EffectDialogBuilder(webView.getContext())
//                    .setCancelable(false)
//                    .setCancelableOnTouchOutside(false)
//                    .setContentView(dialogView).show();
//            return true;

            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }


        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);

//            if (webViewParam.shouldResetTitle) {
//                if (null != titleBarView) {
//                    titleBarView.setTitleText(title);
//                }
//            }
        }

    }

    /**
     * 主要帮助WebView处理各种通知、请求事件的
     */
    private final int LOAD_START = 1;
    private final int LOAD_ERROR = 2;
    private final int LOAD_FINISHED = 3;
    private int loadStatus = LOAD_FINISHED;

    private class DWebViewClient extends WebViewClient {

        @Override
        public void onLoadResource(WebView view, String url) {
            progressBar.setProgress(view.getProgress());
            super.onLoadResource(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            loadStatus = LOAD_START;
            progressBar.setProgress(1);
            progressBar.setVisibility(View.VISIBLE);
//            if (webViewParam.shouldResetTitle) {
//                if (null != titleBarView) {
//                    titleBarView.setTitleText(view.getTitle());
//                }
//            }
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setProgress(100);
            progressBar.setVisibility(View.GONE);
            if (loadStatus != LOAD_ERROR) {
                loadingBar.setLoadingStatus(LoadingBar.LoadingStatus.SUCCESS);
            }
            loadStatus = LOAD_FINISHED;
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            loadStatus = LOAD_ERROR;
            //显示上层的错误页面
            if (!NetworkUtil.isNetworkAvailable(WebViewActivity.this)) {
                loadingBar.setLoadingStatus(LoadingBar.LoadingStatus.NOCONNECTION, R.drawable.icon_fail);
            } else {
                loadingBar.setLoadingStatus(LoadingBar.LoadingStatus.RELOAD, R.drawable.icon_fail);
            }
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                       SslError error) {
            // super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    /**
     * 下载
     *
     * @author zhangquan
     */
    private class DWebViewDownLoadListener implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent,
                                    String contentDisposition, String mimetype, long contentLength) {
            try {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean handleBackEvent() {
        if (null != webView && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return false;
    }


    @Override
    public void onBackPressed() {
        if (!handleBackEvent()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseWebView();
    }

    private void releaseWebView() {
        try {
            if (null != webView) {
                webView.setVisibility(View.GONE);
                webView.removeAllViews();
                webView.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
