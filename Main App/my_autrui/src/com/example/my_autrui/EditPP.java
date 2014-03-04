package com.example.my_autrui;

import android.app.Activity;
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
		EditText firstName = (EditText) findViewById(R.id.etFirstName);
		EditText lastName = (EditText) findViewById(R.id.etLastName);
		EditText email = (EditText) findViewById(R.id.etEmail);
		EditText hobbies = (EditText) findViewById(R.id.etHobbies);

		
		confirmChangeEditPP.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				case R.id.bconfirmChangeEditPP:
					
					break;
				case R.id.etFirstName:
					
					break;
				case R.id.etLastName:
					
					break;
				case R.id.etEmail:
					
					break;
				case R.id.etHobbies:
					
					break;
				}
			}
		});
	}
	

}
