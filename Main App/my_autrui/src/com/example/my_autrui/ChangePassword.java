package com.example.my_autrui;

import java.util.List;
import android.net.Uri;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePassword extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepassword);
		
		final Button confirmChange = (Button) findViewById(R.id.bconfirmChange);
		final EditText oldpassword = (EditText) findViewById(R.id.etOldPass);
		final EditText newpassword = (EditText) findViewById(R.id.etNewPass);
		final EditText retypepassword = (EditText) findViewById(R.id.etRTPass);
		final ParseUser currentUser = ParseUser.getCurrentUser();	

		confirmChange.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				/*ParseUser.logInInBackground(currentUser.getUsername(), oldpassword.getContext().toString(), new LogInCallback(){

					@Override
					public void done(ParseUser user, ParseException e) {
						// TODO Auto-generated method stub
						if(user != null){
							Log.e("Message","User Sucess");
						}
						else{
							Log.e("Message","User Fail");
						}
					}
					
				});
				
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
			    emailIntent.setData(Uri.parse(currentUser.getEmail()));
			    emailIntent.setType("text/plain");
				ParseUser.r(emailIntent.setData(Uri.parse(currentUser.getEmail())),new RequestPasswordResetCallback(){

					@Override
					public void done(ParseException e) {
						// TODO Auto-generated method stub
					         if (e == null) {
					           Log.e("Message","Success");
					         } else {
					        	 Log.e("Message","Fail");
					         }
					}
				});*/
			/*	try {
					ParseUser.requestPasswordResetInBackground(currentUser.getEmail(),new RequestPasswordResetCallback());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				/*String username = currentUser.getUsername();
				final ParseUser user = null;
				
				try {
					currentUser.logOut();
					Log.e("message", oldpassword.getText().toString());
					ParseUser.logIn(username, oldpassword.getText().toString());
					Log.e("message", user.getUsername());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					Log.e("message", "log in failed.");
					//e.printStackTrace();
				}
				
				if(user.getObjectId().equals(currentUser.getObjectId()))
				{
					if(newpassword.getText().toString().equals(retypepassword.getText().toString()))
					{
						currentUser.setPassword(newpassword.getText().toString());
						//currentUser
						Intent intent = new Intent(v.getContext(), Login.class);
						startActivityForResult(intent, 0);
					}
				}
			}
		});*/
			}
		});
	}
}
	
				
