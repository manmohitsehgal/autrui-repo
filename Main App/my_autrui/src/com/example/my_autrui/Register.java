package com.example.my_autrui;
import com.parse.*;	

import android.app.Activity;
import android.content.Intent;
//import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
	private Button Register;
	private EditText firstName;
	private EditText lastName;
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
				firstName = (EditText)findViewById(R.id.FirstName);
				lastName = (EditText)findViewById(R.id.LastName);
				email =  (EditText)findViewById(R.id.Email);
				
				ParseUser user = new ParseUser();
				user.setUsername(firstName.getText().toString()+lastName.getText().toString());
				user.setPassword("Autrui");
				user.setEmail(email.getText().toString());
				user.signUpInBackground(new SignUpCallback() {
				  public void done(ParseException e) {
				    if (e == null) {
				      // Hooray! Let them use the app now.
						Intent intent = new Intent(v.getContext(), MainActivity.class);
						startActivityForResult(intent, 0);
				    } else {
				      // Sign up didn't succeed. Look at the ParseException
				      // to figure out what went wrong
				    }
				  }
				});
			}	
				
			});
	}

	//Left blank so that it doesn't go back to the Login.java activity
	@Override
	   public void onBackPressed() {
	      
	    } 
	

}
