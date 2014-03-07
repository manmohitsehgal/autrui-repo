package com.example.my_autrui;
import com.parse.*;	

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
//import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
	private Button Register;
	private EditText fullName;
	private EditText userName;
	private EditText password;
	private EditText confirmPassword;
	private EditText email;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp", "h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		//ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
		Register = (Button)findViewById(R.id.RegisterNewUser);
		Register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				fullName = (EditText)findViewById(R.id.FullName);
				userName = (EditText)findViewById(R.id.userName);
				password = (EditText)findViewById(R.id.PasswordField);
				confirmPassword = (EditText)findViewById(R.id.ConfirmPasswordFields);
				email =  (EditText)findViewById(R.id.Email);
				
				if(password.getText().toString().equals(confirmPassword.getText().toString()))
				{
					ParseUser user = new ParseUser();
					user.setUsername(userName.getText().toString());
					user.setPassword(password.getText().toString());
					user.setEmail(email.getText().toString());
					user.put("fullName", fullName.getText().toString());
					//Log.e("Message", "User object created: "+user.getUsername());
					user.signUpInBackground(new SignUpCallback() 
					{
						public void done(ParseException e) 
						{
							if (e == null) 
							{
								Log.e("Messege","new user has been found");
								// Hooray! Let them use the app now.
								Intent intent = new Intent(v.getContext(), MainActivity.class);
								startActivityForResult(intent, 0);
							} 
							else 
							{
								// Sign up didn't succeed. Look at the ParseException
								// to figure out what went wrong
							}
						}	
					});
				}
			}	
				
		});
	}
	
	@Override
	   public void onBackPressed() {
	    Intent setIntent = new Intent(this,Login.class);
	    startActivity(setIntent); 
	    finish();
	}
		
}
