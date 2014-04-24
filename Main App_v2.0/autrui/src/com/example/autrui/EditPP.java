package com.example.autrui;

import com.parse.GetCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
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

public class EditPP extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editpp);
		final Button confirmChangeEditPP = (Button) findViewById(R.id.bconfirmChangeEditPP);
		final EditText fullName = (EditText) findViewById(R.id.etFullName);
		final EditText email = (EditText) findViewById(R.id.etEmail);

		// final ParseUser currentUser = new ParseUser();
		final ParseUser currentUser = ParseUser.getCurrentUser();
		System.out.println(currentUser);
		String objectId = currentUser.getObjectId();
		System.out.println(objectId);
		String fName = currentUser.getString("fullName");
		fullName.setText(fName);
		email.setText(currentUser.getString("email"));

		confirmChangeEditPP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				currentUser.put("fullName", fullName.getText().toString());
				System.out.println(fullName.getText().toString());
				currentUser.put("email", email.getText().toString());
				System.out.println(email .getText().toString());
				currentUser.saveInBackground();
				showUserDetailsActivity();
			}
		});
	}

	@Override
	public void onBackPressed() {
		finish();

	}

	private void showUserDetailsActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
