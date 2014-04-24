package com.example.autrui;

import java.util.List;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
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
				int PF = currentUser.getInt("PayItForward");
				ParseUser destUser;
				ParsePush push = new ParsePush();
				push.setChannel(currentUser.getObjectId());
				
				/*new code begins*/
				ParseObject newMovement = new ParseObject("Movements");
				ParseQuery movementQuery = new ParseQuery("Movements");
				movementQuery.whereEqualTo("UserID", currentUser.getObjectId());
				ParseACL acl = new ParseACL();
				int counter = currentUser.getInt("Counter");
				/*ends*/
				ParseQuery<ParseUser> query = ParseUser.getQuery();
				query.whereEqualTo("fullName", userName.getText().toString());

				try
				{
					List<ParseUser> destUserObjects = query.find();
					List<ParseObject> movements = movementQuery.find();
					
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
							acl.setPublicReadAccess(true);
							acl.setPublicWriteAccess(true);
							deedObject.setACL(acl);
							if(PF > 0)
								PF -= 1;
							
							if(PF == 0 || movements.size() == 0) {
								acl.setPublicReadAccess(true);
								acl.setPublicWriteAccess(true);
								newMovement.setACL(acl);
								newMovement.put("Access", 1);
								newMovement.put("UserID", currentUser.getObjectId());
								newMovement.add("Deeds", deedObject); //maybe wont work
								deedObject.put("MovementObj", false);
								deedObject.put("ContainsID", false);
								newMovement.saveInBackground();
								push.setMessage("You have created a new movement");
								push.sendInBackground();
							} else {
								List<String> movementIds = (List<String>) currentUser.get("MovementID");
								List<String> movRef = movementIds;
								if(counter >= movRef.size()) {
									counter = movRef.size() - 1;
								}
								deedObject.put("ContainsID", true);
								deedObject.put("MovementObj", true);
								deedObject.put("MovementID", movRef.get(counter));
								counter += 1;
								System.out.println("You have added a deed to an existing movement!");
								push.setMessage("You have added a deed to an existing movement!");
								push.sendInBackground();
								if(PF > 0)
									PF -= 1;
							}
							System.out.println("Counter " + counter);
							currentUser.put("PayItForward", PF);
							currentUser.put("Counter", counter);
							deedObject.saveInBackground();
							currentUser.saveInBackground();

						}
					}
				}catch(ParseException e){
					e.printStackTrace();
				}

				showUserDetailsActivity();
			}
		});
	}
	public void onBackPressed() {
		System.out.println("OnBack Successautrui");
		ParseUser currentUser = ParseUser.getCurrentUser();
		ParseQuery edgeQuery = new ParseQuery("Deeds");
		ParseQuery movementQuery = new ParseQuery("Movements");
		
		
		edgeQuery.whereEqualTo("MovementObj", false);
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
	}

	public void showUserDetailsActivity() {
		onBackPressed();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
