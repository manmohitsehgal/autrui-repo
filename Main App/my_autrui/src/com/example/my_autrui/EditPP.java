package com.example.my_autrui;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditPP extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editpp);
		Button confirmChangeEditPP = (Button) findViewById(R.id.bconfirmChangeEditPP);
		final EditText fullName = (EditText) findViewById(R.id.etFullName);
		final EditText email = (EditText) findViewById(R.id.etEmail);
		
		final ParseUser userProfile = new ParseUser();
		fullName.setText((String)userProfile.getString("username"));
		email.setText((String)userProfile.getString("email"));
		
		confirmChangeEditPP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					userProfile.put("username", fullName.getText().toString());
					userProfile.put("email", email.getText().toString());
					Intent intent = new Intent(v.getContext(), MainActivity.class);
					startActivityForResult(intent, 0);
			}
		});
	}
	

}
