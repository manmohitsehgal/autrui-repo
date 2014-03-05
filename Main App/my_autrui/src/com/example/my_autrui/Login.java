package com.example.my_autrui;

import com.parse.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends Activity {
	private EditText username = null;
	private EditText password = null;
	private Button Login; 
	private Button Register;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		
		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp", "h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		//ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
		Login = (Button)findViewById(R.id.Login);
		Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				username = (EditText)findViewById(R.id.Username);
				password = (EditText)findViewById(R.id.Password);
				
				
				ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
					  public void done(ParseUser user, ParseException e) {
					    if (user != null) {
					      // Hooray! The user is logged in.
					    	
					       Intent intent = new Intent(v.getContext(), MainActivity.class);
					       startActivityForResult(intent, 0);
					    } else {
					      // Signup failed. Look at the ParseException to see what happened.
					    	System.out.println("failed\n"+username.getText().toString()+password.getText().toString());
					    }
					  }
					});
				
				/*if(username.getText().toString().equals("Autrui")&&
						password.getText().toString().equals("Autrui")){
					
				    Intent intent = new Intent(v.getContext(), MainActivity.class);
					startActivityForResult(intent, 0);*/
				//}
			}
		});

	
		
		Register = (Button)findViewById(R.id.Register);
		Register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Register.class);
				startActivityForResult(intent, 0);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

