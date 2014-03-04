package com.example.my_autrui;

import android.app.Activity;
import android.content.Intent;
//import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
/*import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;*/
//import android.widget.Toast;
//import android.app.Activity;
//import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
	//private Button Register;
	//private EditText firstName = null;
	//private EditText lastName = null;
	//private EditText email = null;
	//private Button Register;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		/*Parse.initialize(this, "02Y6HfL19JtM03Rg6ZCZqYD5nfQvtkXEba7hojcn", "VzJxedGzq3xbF1tlowX7Jgph9BdIO2a7FPuc54eu");
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);*/
		
		/*Register = (Button)findViewById(R.id.Register);
		Register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				firstName = (EditText)findViewById(R.id.Username);
				lastName = (EditText)findViewById(R.id.Username);
				email =  (EditText)findViewById(R.id.Username);
				
				ParseUser user = new ParseUser();
				user.setUsername(firstName+lastName);
				user.setPassword("Autrui");
				user.setEmail(email);
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
				
			});*/
	}

	//Left blank so that it doesn't go back to the Login.java activity
	@Override
	   public void onBackPressed() {
	      
	    } 
	

}
