package com.example.my_autrui;

import java.util.List;
import java.util.Vector;

import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FbPassword extends ListActivity {
	
	private String[] classes;
	private static Vector<String> friends = new Vector<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp", "h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		//ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
		Session session = ParseFacebookUtils.getSession();
				
		Request request = Request.newMyFriendsRequest(session, new Request.GraphUserListCallback() {
			
			@Override
			public void onCompleted(List<GraphUser> users, Response response) {
				// TODO Auto-generated method stub
				for(int i = 0; i < users.size(); i++)
				{
					friends.add(i, users.get(i).getName());
				}				
			}
		});
		
		classes = new String[friends.size()];
		for(int i = 0; i < friends.size(); i++)
		{
			classes[i] = friends.get(i);
		}
		//request.executeAsync();

		setListAdapter(new ArrayAdapter<String>(FbPassword.this,
				android.R.layout.simple_list_item_1, classes));
		request.executeAsync();

	}
	

}
