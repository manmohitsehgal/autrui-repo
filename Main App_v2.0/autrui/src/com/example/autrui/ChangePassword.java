package com.example.autrui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class ChangePassword extends Activity {

	//EditText previousPass = (EditText) findViewById(R.id.etPreviousPassword);
	//EditText newPass = (EditText) findViewById(R.id.etNewPassword);

	
	
	/*public void resetPassword() {
		final ParseUser currentUser = ParseUser.getCurrentUser();
		final Button resetPassword = (Button) findViewById(R.id.bResetPassword);
		final EditText emailBox = (EditText) findViewById(R.id.etEmailBox);
		ParseQuery<ParseUser> query = new ParseQuery<ParseUser>("User");
		query.whereEqualTo("email", emailBox.getText().toString());
		String myId = currentUser.getObjectId().toString();
		query.getInBackground(currentUser.getObjectId().toString(), new GetCallback<ParseUser>(){
			@Override
			public void done(ParseUser object, ParseException e) {
				// TODO Auto-generated method stub
				if (emailBox.toString() == currentUser.getEmail()) {
					Log.d("score", "The getFirst request failed.");
				} else {
					Log.d("score", "Retrieved the object.");
				}
			}
		});
//		try {
//			query.getFirst();
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepassword);
		final Button resetPassword = (Button) findViewById(R.id.bResetPassword);

		resetPassword.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showUserDetailsActivity();
			}

		});

	}
	

	private void showUserDetailsActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	/*@Override
	public void onBackPressed() {
		finish();
		// Go to settings
		if(MainActivity.s.isEmpty())
			return;
		else {
			View v = MainActivity.s.pop();
			Class c = MainActivity.s2.pop();
			Intent intent = new Intent(v.getContext(), c);
			startActivityForResult(intent, 0);
		}*/
}

