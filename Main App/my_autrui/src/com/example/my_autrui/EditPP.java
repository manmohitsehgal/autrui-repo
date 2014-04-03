package com.example.my_autrui;

import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SendCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditPP extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editpp);
		Button confirmChangeEditPP = (Button) findViewById(R.id.bconfirmChangeEditPP);
		final EditText fullName = (EditText) findViewById(R.id.etFullName);
		final EditText email = (EditText) findViewById(R.id.etEmail);
		
		
		//final ParseUser userProfile = new ParseUser();
		//fullName.setText((String)userProfile.getString("username"));
		//email.setText((String)userProfile.getString("email"));
		final ParseUser currentUser = ParseUser.getCurrentUser();
		String userId = currentUser.getObjectId();
		String fName = currentUser.getString("fullName");
		
		
		fullName.setText(fName);
		email.setText(currentUser.getString("email"));
		
		confirmChangeEditPP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					currentUser.put("fullName", fullName.getText().toString());
					currentUser.put("email", email.getText().toString());
					currentUser.saveInBackground();
					
					Intent intent = new Intent(v.getContext(), MainActivity.class);
					startActivityForResult(intent, 0);
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		finish();
		// Go to settings
		/*if(MainActivity.s.isEmpty())
			return;
		else {
			View v = MainActivity.s.pop();
			Class c = MainActivity.s2.pop();
			Intent intent = new Intent(v.getContext(), c);
			startActivityForResult(intent, 0);
		}*/
	}
	

}
