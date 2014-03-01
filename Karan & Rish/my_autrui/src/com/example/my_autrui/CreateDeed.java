package com.example.my_autrui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateDeed extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_deed);
		
		Button postDeed = (Button) findViewById(R.id.bPostDeed);
		TextView customdeed = (TextView) findViewById(R.id.etCustomDeed);
		
		postDeed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				case R.id.bPostDeed:
					
					break;
				case R.id.etCustomDeed:
					
					break;
				}
				
			}
		});
	}
	

}
