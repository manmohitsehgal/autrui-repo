package com.example.my_autrui;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.Button;
import android.widget.EditText;

public class PostDeed extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_deed);
		
		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp", "h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		//ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
		Button  postDeed = (Button) findViewById(R.id.PostDeedButton);
		final EditText editDeed = (EditText) findViewById(R.id.etPostDeed);

		/*if (getIntent() != null && getIntent().getExtras() != null) {
			 String value = getIntent().getExtras().getString("selectedText");
			editDeed.setText(value);
		}*/
		
		postDeed.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				ParseObject deedObject = new ParseObject("GameScore");
				deedObject.put("deedDescription", editDeed.getContext().toString());
				Log.e("Message","this is before");
				deedObject.saveInBackground();
				Log.e("Message","After");
				
				
			}
			
		});
		
	}
	

}

