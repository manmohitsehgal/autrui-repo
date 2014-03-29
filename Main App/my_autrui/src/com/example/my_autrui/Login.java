package com.example.my_autrui;

import java.util.Arrays;
import java.util.List;

import com.parse.*;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	private EditText username = null;
	private EditText password = null;
	private Button Login;
	private Button Register;
	private Button fbLogin;
	private Dialog progressDialog;

	// private MainFragment mainFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);

		Parse.initialize(this, "bF0ORwBlwjrv46DVMgfVswkFwMRo4KI67yfn4oWp",
				"h7eVgwYn0ZRlIxkGAg7jwUPrDC7GMaNnMo8htmoy");
		ParseFacebookUtils.initialize("268313903329951");
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

		Login = (Button) findViewById(R.id.Login);
		Login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				username = (EditText) findViewById(R.id.Username);
				password = (EditText) findViewById(R.id.Password);

				ParseUser.logInInBackground(username.getText().toString(),
						password.getText().toString(), new LogInCallback() {
							public void done(ParseUser user, ParseException e) {
								if (user != null) {
									// Hooray! The user is logged in.

									Intent intent = new Intent(v.getContext(),
											MainActivity.class);
									startActivityForResult(intent, 0);
								} else {
									System.out.println("failed\n"
											+ username.getText().toString()
											+ password.getText().toString());
								}
							}
						});

			}
		});

		Register = (Button) findViewById(R.id.Register);
		Register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Register.class);
				startActivityForResult(intent, 0);
			}
		});

		fbLogin = (Button) findViewById(R.id.facebookLogin);
		fbLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// onLoginButtonClicked();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	private void onLoginButtonClicked() {
		Login.this.progressDialog = ProgressDialog.show(Login.this, "",
				"Logging in...", true);
		List<String> permissions = Arrays.asList("basic_info", "user_about_me",
				"user_relationships", "user_birthday", "user_location");
		ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
			public void done(ParseUser user, ParseException err) {
				Login.this.progressDialog.dismiss();
				if (user == null) {
					System.out.println("Login Cancelled");
				} else if (user.isNew()) {
					showUserDetailsActivity();
				} else {
					System.out.println("Login Succesful");
					showUserDetailsActivity();
				}
			}
		});
	}

	private void showUserDetailsActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
