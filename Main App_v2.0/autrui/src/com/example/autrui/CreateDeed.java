package com.example.autrui;

import java.util.List;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateDeed extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_deed);
		
		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp", "h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		//ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
		Button postDeed = (Button) findViewById(R.id.bPostDeed);
		final EditText customdeed = (EditText) findViewById(R.id.etCustomDeed);		
		final EditText userName = (EditText) findViewById(R.id.etUserName);
		
		postDeed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method 
				ParseUser currentUser = ParseUser.getCurrentUser();
				ParseUser destUser;
				ParseQuery<ParseUser> query = ParseUser.getQuery();
				query.whereEqualTo("fullName", userName.getText().toString());
				try
				{
					List<ParseUser> destUserObjects = query.find();
					
					if(destUserObjects.size() == 1)
	 			{
						if(currentUser != null)
						{
							destUser = destUserObjects.get(0);
							System.out.println(currentUser.getObjectId());
							System.out.println(destUser.getObjectId());
							String userId = currentUser.getObjectId();
							ParseObject deedObject = new ParseObject("Deeds");
							deedObject.put("deedDescription", customdeed
									.getText().toString());
							deedObject.put("userIdSrc", userId);
							deedObject.put("userIdDest", destUser.getObjectId()
									.toString());
							deedObject.put("InMovement", false);
							deedObject.put("MovementObj", false);
							deedObject.put("ContainsID", false);
							ParseACL acl = new ParseACL();
							acl.setPublicReadAccess(true);
							acl.setPublicWriteAccess(true);
							deedObject.setACL(acl);
							deedObject.saveInBackground();

						}
					}
				}
				catch(ParseException e)
				{
					
				}
			}
		});
	}
	

}
