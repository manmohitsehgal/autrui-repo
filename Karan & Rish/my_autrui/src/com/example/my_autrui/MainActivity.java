package com.example.my_autrui;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TabHost th = (TabHost) findViewById (R.id.tabhost);
		Resources res =getResources();
		th.setup();
		
		//For the tab - My Autrui
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("My Autrui");
		th.addTab(specs);
		
		//For the tab - Global Impact
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Global Impact");
		th.addTab(specs);
		
		//For the tab - Settings
		specs = th.newTabSpec("tag3");
		specs.setIndicator("Settings",res.getDrawable(R.drawable.tab_icon));
		specs.setContent(R.id.tab3);
		
		th.addTab(specs);
		
		th.setCurrentTabByTag("tag1");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
