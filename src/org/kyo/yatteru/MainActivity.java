package org.kyo.yatteru;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.KeyEvent;

public class MainActivity extends Activity {

  private WebView wv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    wv = (WebView) findViewById(R.id.webview);
    wv.getSettings().setJavaScriptEnabled(true);
    wv.setWebViewClient(new WebViewClient() {
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
      }
    });
    wv.loadUrl(getString(R.string.uri));
  }

  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
      wv.goBack();
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

}
