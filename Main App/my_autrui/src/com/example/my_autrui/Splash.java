package com.example.my_autrui;

import android.app.Activity;	
import android.content.Intent;
import android.os.Bundle;

import com.parse.*;


public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openAutrui = new Intent("com.example.my_autrui.LOGIN");
					startActivity(openAutrui);
			}
		}
		
	};
	timer.start();
	
	}
}
