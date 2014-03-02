package com.example.my_autrui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity implements View.OnClickListener   {
	Intent intent = new Intent();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost tbht = (TabHost) findViewById (R.id.tabhost);
		Resources res =getResources();
		
		//Buttons in all of the tabs
		Button cDeed = (Button) findViewById (R.id.bDeed);
		Button myMovement = (Button) findViewById (R.id.bMovements);
		Button aboutUs = (Button) findViewById (R.id.bAboutUs);
		Button help = (Button) findViewById (R.id.bHelp);
		Button editPP = (Button) findViewById (R.id.bEditPP);
		Button logout = (Button) findViewById (R.id.bLogOut);
		Button changePass = (Button) findViewById (R.id.bChangePass);
		Button chooseDeed = (Button) findViewById (R.id.bChoosedeed);
		
		//On click listeners for all the buttons in all of the tabs
		cDeed.setOnClickListener(this);
		myMovement.setOnClickListener(this);
		aboutUs.setOnClickListener(this);
		help.setOnClickListener(this);
		editPP.setOnClickListener(this);
		logout.setOnClickListener(this);
		changePass.setOnClickListener(this);		
		chooseDeed.setOnClickListener(this);
		
		tbht.setup();
		
		//For the tab - My Autrui
		TabSpec specsTab = tbht.newTabSpec("tag1");
		specsTab.setContent(R.id.tab1);
		specsTab.setIndicator("My Autrui");
		tbht.addTab(specsTab);
		
		//For the tab - Global Impact
		specsTab = tbht.newTabSpec("tag2");
		specsTab.setContent(R.id.tab2);
		specsTab.setIndicator("Global Impact");
		tbht.addTab(specsTab);
		
		//For the tab - Settings
		specsTab = tbht.newTabSpec("tag3");
		specsTab.setIndicator("Settings",res.getDrawable(R.drawable.tab_icon));
		specsTab.setContent(R.id.tab3);
		
		tbht.addTab(specsTab);
		
		tbht.setCurrentTabByTag("tag1");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Left blank so that it doesn't go back. 
	@Override
	   public void onBackPressed() {
	    
		
	} 
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bDeed:
			intent = new Intent(v.getContext(), CreateDeed.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bMovements:
			intent = new Intent(v.getContext(), MyMovement.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bChoosedeed:
			intent = new Intent(v.getContext(), ChooseDeed.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bAboutUs:
			intent = new Intent(v.getContext(), AboutUs.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bChangePass:
			intent = new Intent(v.getContext(), ChangePassword.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bEditPP:
			intent = new Intent(v.getContext(), EditPP.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bLogOut:
			
			break;
		case R.id.bHelp:
			intent = new Intent(v.getContext(), Help.class);
			startActivityForResult(intent, 0);
			break;
			
		}
		
	}

}
