package com.example.my_autrui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePassword extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepassword);
		
		Button confirmChange = (Button) findViewById(R.id.bconfirmChange);
		EditText oldpassword = (EditText) findViewById(R.id.etOldPass);
		EditText newpassword = (EditText) findViewById(R.id.etNewPass);
		EditText retypepassword = (EditText) findViewById(R.id.etRTPass);
		
		confirmChange.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				case R.id.bconfirmChange:
					
					break;
				case R.id.etOldPass:
					
					break;
				case R.id.etNewPass:
					
					break;
				case R.id.etRTPass:
					
					break;
				}
			}
		});
		
	}
	

}
