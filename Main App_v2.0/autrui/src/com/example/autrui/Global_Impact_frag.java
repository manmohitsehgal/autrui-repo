package com.example.autrui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */

public class Global_Impact_frag extends Fragment implements OnClickListener  {

	Intent intent = new Intent();
	public Global_Impact_frag() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.global_impact_web_view,
				container, false);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		WebView mWebView;
		mWebView = (WebView) getActivity().findViewById(R.id.webview);
		mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.loadUrl("http://web.ics.purdue.edu/~mjham/global.html");
		

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int ides=v.getId();
		if(ides==R.id.bglobalImpactView)
		{
			String url = "http://web.ics.purdue.edu/~mjham/global.html";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
		}
	}

}