package com.example.autrui;


import java.util.List;

import com.parse.Parse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

public class MyMovement extends Activity {        
       
	private WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_movement);
		setVisible(true);

		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp",
				"h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		// ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

		//setContentView(new MyView(this));
		
		mWebView =(WebView) findViewById(R.id.webview);
		mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.loadUrl("http://web.ics.purdue.edu/~mjham/d2PdnlSLfn.html");
		//mWebView.loadUrl("http://web.ics.purdue.edu/~kapur0/graph4.html");
		
		
	}
	@Override
	public void onBackPressed() {
		finish();
	}
}

/*class MyView extends View {
        public MyView(Context context) {
                super(context);
                // TODO Auto-generated constructor stub
        }

        
        @Override
        protected void onDraw(Canvas canvas) {
                // TODO Auto-generated method stub

                ParseUser currentUser = ParseUser.getCurrentUser();
                ParseQuery movementQuery = new ParseQuery("Deeds");
                int n = 0;
                movementQuery.whereEqualTo("userIdSrc", currentUser.getObjectId());
                try {
                        List<ParseObject> deeds = movementQuery.find();
                        n = deeds.size();
                        for (int i = 0; i < deeds.size(); i++) {
                                System.out.println(deeds.get(i).get("deedDescription"));
                        }
                } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                System.out.println(n);
                
                super.onDraw(canvas);
                int x = getWidth()/2;
                int y = getHeight()/2;
                int radius;
                radius = 50;
                Paint paint = new Paint();
                
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);
                // Use Color.parseColor to define HTML colors
                paint.setColor(Color.parseColor("#CD5C5C"));
                canvas.drawCircle(x, y, radius, paint);
                
                int m = Math.min(x, y);
        int r = 4 * m / 5;
        int r2 = Math.abs(m - r) / 2;
        for (int i = 0; i < n; i++) {
            double t = 2 * Math.PI * i / n;
            int a = (int) Math.round(x + r * Math.cos(t));
            int b = (int) Math.round(y + r * Math.sin(t));
            Paint circleColor = new Paint();
            circleColor.setColor(Color.GREEN);
            canvas.drawCircle(a - r2, b - r2, r2, circleColor);
            Paint lineColor = new Paint();
            lineColor.setColor(Color.BLACK);
            canvas.drawLine(x, y, a - r2, b - r2, lineColor);
        }
        }

}*/
