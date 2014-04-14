package com.example.autrui;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;


public class MainActivity extends FragmentActivity implements TabListener 
{

	ActionBar actionBar;
	ViewPager viewPgaer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPgaer=(ViewPager) findViewById(R.id.pager);
		viewPgaer.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPgaer.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				//To get an idea about which page is being selected
				actionBar.setSelectedNavigationItem(arg0);
				//Log.d("VIVZ", "onPageselected at "+" position "+arg0);

			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				//To get an idea about the change of position from 0 to 1
				//Log.d("VIVZ", "onPageScrolled at "+" position "+arg0+ " from "+arg1+" with number of pixels= "+arg2);

			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				// To get an idea about what is happening when the state of the page is changed
				/*if(arg0==ViewPager.SCROLL_STATE_IDLE)
				{
					Log.d("VIVZ","onPageScrollStateChanged Idle");
				}
				if(arg0==ViewPager.SCROLL_STATE_DRAGGING)
				{
					Log.d("VIVZ","onPageScrollStateChanged Dragging");
				}
				if(arg0==ViewPager.SCROLL_STATE_SETTLING)
				{
					Log.d("VIVZ","onPageScrollStateChanged Settling");
				}*/
			}
		});
		actionBar=getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1=actionBar.newTab();
		tab1.setText("My Movements");
		tab1.setTabListener(this);
		
		ActionBar.Tab tab2=actionBar.newTab();
		tab2.setText("Global Impact");
		tab2.setTabListener(this);
		
		ActionBar.Tab tab3=actionBar.newTab();
		tab3.setText("Settings");
		tab3.setTabListener(this);
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		//To get an idea about which tab is selected
		//Log.d("VIVZ", "onTabReselected at "+" position "+tab.getPosition()+" name "+tab.getText());
		viewPgaer.setCurrentItem(tab.getPosition());
	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		//To get an about which tab was unselected
		//Log.d("VIVZ", "onTabReselected at "+" position "+tab.getPosition()+" name "+tab.getText());
	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		//To get an idea about which tab was selected AGAIN
		//Log.d("VIVZ", "onTabReselected at "+" position "+tab.getPosition()+" name "+tab.getText());
	}
}

class MyAdapter extends FragmentPagerAdapter
{

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Fragment getItem(int arg0){
		
		Fragment fragment =null;
		if(arg0 ==0)
		{
			fragment=new Movement_frag();
		}
		if(arg0 ==1)
		{
			fragment=new Global_Impact_frag();
		}
		if(arg0 ==2)
		{
			fragment=new Settings_frag();
		}
		return fragment;
	}
	
	@Override
	public int getCount(){
		return 3;
	
	}
}