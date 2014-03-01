package com.example.my_autrui;

import android.os.Bundle;
import android.app.Activity;
//import android.widget.Button;
import android.widget.EditText;

public class PostDeed extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post_deed);
		
		//Button  postDeed = (Button) findViewById(R.id.bPostDeed);
		EditText edt = (EditText) findViewById(R.id.ePostDeed);

		if (getIntent() != null && getIntent().getExtras() != null) {
			 String value = getIntent().getExtras().getString("selectedText");
			edt.setText(value);
		}
	}
	

}

