package com.example.autrui;


import java.util.List;

import com.parse.Parse;

import android.content.Context;
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
		
		ParsePush push = new ParsePush();
		
		ParseUser currentUser = ParseUser.getCurrentUser();
		ParseQuery deedQuery = new ParseQuery("Deeds");
		ParseQuery movementQuery = new ParseQuery("Movements");
		ParseQuery pfQuery = new ParseQuery("Deeds");
		ParseQuery edgeQuery = new ParseQuery("Deeds");
		
		push.setChannel(currentUser.getObjectId());
		
		edgeQuery.whereEqualTo("MovementObj", true);
		edgeQuery.whereEqualTo("ContainsID", false);
		edgeQuery.whereEqualTo("userIdSrc", currentUser.getObjectId());
		
		deedQuery.whereEqualTo("userIdSrc", currentUser.getObjectId());
		deedQuery.whereEqualTo("MovementObj", false);
		
		movementQuery.whereEqualTo("UserID", currentUser.getObjectId());
		
		pfQuery.whereEqualTo("userIdDest", currentUser.getObjectId());
		pfQuery.whereEqualTo("InMovement", false);
				
		
		try {
			List<ParseObject> pfRem = pfQuery.find();
			List<ParseObject> deeds = deedQuery.find();
			List<ParseObject> movements = movementQuery.find();
			List<ParseObject> edgeCase = edgeQuery.find();
			
			int PayItForward = currentUser.getInt("PayItForward");
			int oldPF = currentUser.getInt("PayItForward");
			int i;
			for(i = 0; i < pfRem.size(); i++) {
				if(PayItForward + i >= 5)
					break;
				pfRem.get(i).put("InMovement", true);
				System.out.println("Here");
				currentUser.add("MovementID", (String)pfRem.get(i).get("MovementID"));
				
				pfRem.get(i).saveInBackground();
			}
			currentUser.saveInBackground();
			if((PayItForward + (pfRem.size() * 2)) >= 5)
				PayItForward = 5;
			else
				PayItForward += (pfRem.size() * 2);
			System.out.println("PayItForward " + PayItForward);
			String message = "You have " + PayItForward + " new Pay It Forward(s)";
			if(oldPF != PayItForward) {
				System.out.println("Sending PF Push Notification");
				push.setMessage(message);
				push.sendInBackground();
			}
			for(i = 0; i < deeds.size(); i++) {
				deeds.get(i).put("MovementObj", true);
				deeds.get(i).saveInBackground();
			}
			
			
			int j = 0;
			ParseObject newMovement = new ParseObject("Movements");
			if((movements.size() == 0 || PayItForward == 0)) {
				if(deeds.size() != 0) {
					//message = "You created a new Movement!";
					//push.setMessage(message);
					System.out.println("Sending Movement Push Notification");
					//push.sendInBackground();
					ParseACL acl = new ParseACL();
					acl.setPublicReadAccess(true);
					acl.setPublicWriteAccess(true);
					newMovement.setACL(acl);
					newMovement.put("Access", 1);
					newMovement.put("UserID", currentUser.getObjectId());
					newMovement.addAll("Deeds", deeds);
					newMovement.saveInBackground();
				}
				if(PayItForward == 0) {
					List<String> movementIds = (List<String>) currentUser.get("MovementID");
					List<String> movRef = movementIds;
					for(i = 0; i < edgeCase.size(); i++) {
						System.out.println("Here in edge case loop");
						edgeCase.get(i).put("ContainsID", true);
						if(PayItForward == 0) {
							edgeCase.get(i).put("MovementID", movements.get(0).getObjectId());
							movements.get(0).add("Deeds", edgeCase.get(i));
							movements.get(0).saveInBackground();
						}
						else {
							PayItForward--;
							String movID = movRef.get(j++);
							if(j == movRef.size())
								j = movRef.size() - 1;
							System.out.println(movID);
							edgeCase.get(i).put("MovementID", movID);
							ParseQuery whichMovement = new ParseQuery("Movements");
							List<ParseObject> addTo = (List<ParseObject>) whichMovement.find();
							addTo.get(0).add("Deeds", edgeCase.get(i));
							addTo.get(0).saveInBackground();
						}
					}
				}
			}
			else  {
				System.out.println("Here in outer loop");
				ParseObject deedInstance = new ParseObject("Deeds");
				j = 0;
				List<String> movementIds = (List<String>) currentUser.get("MovementID");
				List<String> movRef = movementIds;
				for(i = 0; i < edgeCase.size(); i++) {
					System.out.println("Here in edge case loop");
					edgeCase.get(i).put("ContainsID", true);
					if(PayItForward == 0) {
						edgeCase.get(i).put("MovementID", movements.get(0).getObjectId());
						movements.get(0).add("Deeds", edgeCase.get(i));
						movements.get(0).saveInBackground();
					}
					else {
						PayItForward--;
						String movID = movRef.get(j++);
						if(j == movRef.size())
							j = movRef.size() - 1;
						System.out.println(movID);
						edgeCase.get(i).put("MovementID", movID);
						ParseQuery whichMovement = new ParseQuery("Movements");
						List<ParseObject> addTo = (List<ParseObject>) whichMovement.find();
						addTo.get(0).add("Deeds", edgeCase.get(i));
						addTo.get(0).saveInBackground();
					}
				}
				j = 0;
				for(i = 0; i < deeds.size(); i++) {
					deeds.get(i).put("ContainsID", true);
					deeds.get(i).saveInBackground();
					if(PayItForward == 0) {
						deeds.get(i).put("MovementID", movements.get(0).getObjectId());
						movements.get(0).add("Deeds", deeds.get(i));
						movements.get(0).saveInBackground();
					}
					else {
						System.out.println("Inside the correct place");
						PayItForward--;
						String movID = movRef.get(j++);
						if(j == movRef.size())
							j = movRef.size() - 1;
						System.out.println(movID);
						deeds.get(i).put("MovementID", movID);
						ParseQuery whichMovement = new ParseQuery("Movements");
						whichMovement.whereEqualTo("objectId", movID);
						List<ParseObject> addTo = whichMovement.find();
						System.out.println("ADD TO SIZE: " + addTo.size());
						addTo.get(0).add("Deeds", deeds.get(i));
						addTo.get(0).saveInBackground();
					}
				}
			}
			currentUser.put("PayItForward", PayItForward);
			currentUser.saveInBackground();
			
			for (i = 0; i < deeds.size(); i++) {
				System.out.println(deeds.get(i).get("deedDescription"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		mWebView =(WebView) findViewById(R.id.webview);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl("http://web.ics.purdue.edu/~mjham/example2.html");
	}
	@Override
	public void onBackPressed() {
		
		System.out.println("OnBack Successautrui");
		ParseUser currentUser = ParseUser.getCurrentUser();
		ParseQuery edgeQuery = new ParseQuery("Deeds");
		ParseQuery movementQuery = new ParseQuery("Movements");
		
		
		edgeQuery.whereEqualTo("MovementObj", true);
		edgeQuery.whereEqualTo("ContainsID", false);
		edgeQuery.whereEqualTo("userIdSrc", currentUser.getObjectId());
		movementQuery.whereEqualTo("UserID", currentUser.getObjectId());
		
		int PayItForward = currentUser.getInt("PayItForward");
		int j = 0;
		
		try {
			
			List<ParseObject> edgeCase = edgeQuery.find();
			List<ParseObject> movements = movementQuery.find();
			List<String> movementIds = (List<String>) currentUser.get("MovementID");
			List<String> movRef = movementIds;
			
			for(int i = 0; i < edgeCase.size(); i++) {
				System.out.println("Here in edge case loop");
				edgeCase.get(i).put("ContainsID", true);
				if(PayItForward == 0) {
					edgeCase.get(i).put("MovementID", movements.get(0).getObjectId());
					movements.get(0).add("Deeds", edgeCase.get(i));
					movements.get(0).saveInBackground();
				}
				else {
					PayItForward--;
					String movID = movRef.get(j++);
					if(j == movRef.size())
						j = movRef.size() - 1;
					System.out.println(movID);
					edgeCase.get(i).put("MovementID", movID);
					ParseQuery whichMovement = new ParseQuery("Movements");
					List<ParseObject> addTo = (List<ParseObject>) whichMovement.find();
					addTo.get(0).add("Deeds", edgeCase.get(i));
					addTo.get(0).saveInBackground();
				}
			}
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
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

