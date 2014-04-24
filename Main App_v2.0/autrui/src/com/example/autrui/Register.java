package com.example.autrui;

import com.parse.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp",
				"h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		// ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

		fullName = (EditText) findViewById(R.id.FullName);
		userName = (EditText) findViewById(R.id.userName);
		password = (EditText) findViewById(R.id.PasswordField);
		confirmPassword = (EditText) findViewById(R.id.ConfirmPasswordFields);
		email = (EditText) findViewById(R.id.Email);

		Register = (Button) findViewById(R.id.RegisterNewUser);
		Register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View v) {

				if ((fullName.getText().length() == 0)
						|| (userName.getText().length() == 0)
						|| (password.getText().length() == 0)
						|| (confirmPassword.getText().length() == 0)
						|| (email.getText().length() == 0)) {
					AlertDialog.Builder alertBox = new AlertDialog.Builder(
							Register.this);
					alertBox.setTitle(" Form is incomplete");
					alertBox.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent positveActivity = new Intent(
											getApplicationContext(),
											Register.class);
								}
							});
					AlertDialog alert = alertBox.create();
					alert.show();
				} else {
					if (!(password.getText().toString()
									.equals(confirmPassword.getText()
											.toString()))) {
						AlertDialog.Builder alertBox = new AlertDialog.Builder(
								Register.this);
						alertBox.setTitle("Password doesnot match");
						alertBox.setNeutralButton("Ok",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// exit the app and go to the HOME
										Intent positveActivity = new Intent(
												getApplicationContext(),
												Register.class);
									}
								});
						AlertDialog alert = alertBox.create();
						alert.show();
					} else {
						ParseUser user = new ParseUser();
						user.setUsername(userName.getText().toString());
						user.setPassword(password.getText().toString());
						user.setEmail(email.getText().toString());
						user.put("numPFRem", 0);
						user.put("PayItForward", 0);
						user.put("fullName", fullName.getText().toString());

						user.signUpInBackground(new SignUpCallback() {
							public void done(ParseException e) {
								if (e == null) {
									Log.e("Messege", "new user has been found");
									Intent intent = new Intent(v.getContext(),
											MainActivity.class);
									startActivityForResult(intent, 0);
								} else {

								}
							}
						});
					}
				}
			}
		});
	}

	@Override
	public void onBackPressed() {
		Intent setIntent = new Intent(this, Login.class);
		startActivity(setIntent);
		finish();
	}

}
