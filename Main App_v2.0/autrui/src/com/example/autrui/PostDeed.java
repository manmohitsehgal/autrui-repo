package com.example.autrui;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.Button;
import android.widget.EditText;

public class PostDeed extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_deed_for_predefined_deed);
		
		Button  postDeed = (Button) findViewById(R.id.PostDeedButton);
		final EditText editDeed = (EditText) findViewById(R.id.etPostDeed);
		Intent intent = getIntent();
		editDeed.setText(intent.getExtras().getString("selectedText"));
		postDeed.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
			}
			
		});
		
	}
	

}

