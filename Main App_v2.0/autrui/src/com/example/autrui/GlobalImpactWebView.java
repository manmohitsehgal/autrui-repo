package com.example.autrui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class GlobalImpactWebView extends Activity {
	
	private WebView mwebview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.global_impact_web_view);
		mwebview =(WebView) findViewById(R.id.webview);
		mwebview.getSettings().setJavaScriptEnabled(true);
		mwebview.loadUrl("http://www.mihirjham.com");
	
	}

}
