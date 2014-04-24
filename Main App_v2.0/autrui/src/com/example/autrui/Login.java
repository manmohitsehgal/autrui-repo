package com.example.autrui;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphUser;
import com.parse.*;
import android.app.Activity;
import com.facebook.Session;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.Parse;
import com.parse.SignUpCallback;

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
		ParseACL defaultACL = new ParseACL();

		defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
		ParseFacebookUtils.initialize("268313903329951");

		username = (EditText) findViewById(R.id.Username);
		password = (EditText) findViewById(R.id.Password);
		Login = (Button) findViewById(R.id.Login);
		final Context context = this;
		Login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View v) {

				if ((username.getText().length() == 0) && (password.getText().length() == 0)) {
					AlertDialog.Builder alertBox = new AlertDialog.Builder(
							Login.this);
					alertBox.setTitle(" No Login Information");
					alertBox.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// exit the app and go to the HOME
									Intent positveActivity = new Intent(getApplicationContext(),Login.class);
								}
							});
					AlertDialog alert = alertBox.create();
					alert.show();
				}
				
				else if ((username.getText().length() == 0)){
					AlertDialog.Builder alertBox = new AlertDialog.Builder(
							Login.this);
					alertBox.setTitle(" Username Required");
					alertBox.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// exit the app and go to the HOME
									Intent positveActivity = new Intent(getApplicationContext(),Login.class);
								}
							});
					AlertDialog alert = alertBox.create();
					alert.show();
				}
				
				else if ((password.getText().length() == 0)){
					AlertDialog.Builder alertBox = new AlertDialog.Builder(
							Login.this);
					alertBox.setTitle(" Password Required");
					alertBox.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// exit the app and go to the HOME
									Intent positveActivity = new Intent(getApplicationContext(),Login.class);
								}
							});
					AlertDialog alert = alertBox.create();
					alert.show();
				}
				
				

				ParseUser.logInInBackground(username.getText().toString(),
						password.getText().toString(), new LogInCallback() {
							public void done(ParseUser user, ParseException e) {
								if (user != null) {

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

		fbLogin = (Button) findViewById(R.id.fbLogin);
		fbLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onLoginButtonClicked();
			}
		});
	}

	private void makeMeRequest() {

		Session session = ParseFacebookUtils.getSession();

		Request request = Request.newMeRequest(ParseFacebookUtils.getSession(),
				new Request.GraphUserCallback() {
					@Override
					public void onCompleted(GraphUser user, Response response) {
						if (user != null) {
							// Create a JSON object to hold the profile info
							JSONObject userProfile = new JSONObject();
							try {
								// Populate the JSON object
								userProfile.put("facebookId", user.getId());
								userProfile.put("name", user.getName());
								
								ParseUser currentUser = ParseUser
										.getCurrentUser();
								currentUser.put("fullName",
										userProfile.get("name"));
								currentUser.setUsername(user.getUsername());
								currentUser.setEmail(user.getProperty("email")
										.toString());
								currentUser.saveInBackground();
								// Show the user info
								// updateViewsWithProfileInfo();
							} catch (JSONException e) {
								Log.d("Autrui",
										"Error parsing returned user data.");
							}

						} else if (response.getError() != null) {
							if ((response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_RETRY)
									|| (response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_REOPEN_SESSION)) {
								Log.d("Autrui",
										"The facebook session was invalidated.");
								// onLogoutButtonClicked();
							} else {
								Log.d("Autrui", "Some other error: "
										+ response.getError().getErrorMessage());
							}
						}
					}
				});
		request.executeAsync();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

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
		List<String> permissions = Arrays
				.asList("basic_info", "user_about_me", "user_relationships",
						"user_birthday", "user_location", "email");
		ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				Login.this.progressDialog.dismiss();
				if (user == null) {
					System.out.println("Login Cancelled");
				} else if (user.isNew()) {
					makeMeRequest();
					showUserDetailsActivity();
				} else {
					makeMeRequest();
					System.out.println("Login Succesful");

					showUserDetailsActivity();
				}
			}
		});
	}

	private void showUserDetailsActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void onBackPressed() {
		return;
	}

}

