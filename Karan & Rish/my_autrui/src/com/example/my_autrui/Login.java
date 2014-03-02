package com.example.my_autrui;


import android.app.Activity;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);

		Login = (Button)findViewById(R.id.Login);
		Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				username = (EditText)findViewById(R.id.Username);
				password = (EditText)findViewById(R.id.Password);
				if(username.getText().toString().equals("Autrui")&&
						password.getText().toString().equals("Autrui")){
					Intent intent = new Intent(v.getContext(), MainActivity.class);
					startActivityForResult(intent, 0);
				}
			}
		});
	
		
		Register = (Button)findViewById(R.id.Register);
		Register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent moveToRegister = new Intent(getApplicationContext(),Register.class);
				startActivity(moveToRegister);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

