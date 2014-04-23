package com.example.autrui;

import java.util.List;
import java.util.Vector;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
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

public class ChooseDeed extends ListActivity {
	
	private String[] classes;
	
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
		
		ParseQuery deedQuery = new ParseQuery("PredefinedDeeds");
		
		try {
			List<ParseObject> deeds = deedQuery.find();
			classes = new String[deeds.size()];
			for(int i = 0; i < deeds.size(); i++)
			{
				classes[i] = deeds.get(i).getString("deedsDescription");
			}
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		setListAdapter(new ArrayAdapter<String>(ChooseDeed.this,
				android.R.layout.simple_list_item_1, classes));
	}
	private void addToArray(String[] classes, String item, int index)
	{
		classes[index++] = new String(item);
	}
	
		//Doesnt work. So ya lol. 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		//String cheese= classes[position];
		//Class ourClass = Class.forName("."+cheese);
		Intent ourIntent = new Intent(ChooseDeed.this, CreateDeed.class);
		ourIntent.putExtra("selectedText", classes[position]);
		startActivity(ourIntent);
	}
	

}
