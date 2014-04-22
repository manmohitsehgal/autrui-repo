package com.example.autrui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class Global_Impact_frag extends Fragment {

	//private WebView mWebView2;

	public Global_Impact_frag() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.global__impact_frag,
				container, false);
	}
	/*
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mWebView2 = (WebView) getActivity().findViewById(R.id.webviewglobal);
		mWebView2.getSettings().setJavaScriptEnabled(true);
		mWebView2.loadUrl("http://www.mihirjham.com");
	
		
	}*/

}
