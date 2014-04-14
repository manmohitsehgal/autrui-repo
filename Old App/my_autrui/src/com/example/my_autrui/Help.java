package com.example.my_autrui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Help extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
	}
	
	public void onBackPressed() {
	    finish();
	}
	

}
