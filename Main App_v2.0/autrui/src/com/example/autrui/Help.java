package com.example.autrui;

//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
/**
 * Created by Rish on 20/04/2014.
 */
public class Help extends FragmentActivity {

    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        viewPager= (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapters(fragmentManager));
        
        /*ColorDrawable background = new ColorDrawable(Color.parseColor("#00A9FF"));
		background.setAlpha(150);
		getActionBar().setBackgroundDrawable(background);*/
    }

}

class MyAdapters extends FragmentStatePagerAdapter
{

    public MyAdapters(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
//        Log.d("Rish", "get Item is called "+i);
        if(i==0)
        {
            fragment=new HelpOne();
        }
        if(i==1)
        {
            fragment=new HelpTwo();
        }
        if(i==2)
        {
            fragment=new HelpThree();
        }
        return fragment;
    }

    @Override
    public int getCount() {
//        Log.d("Rish", "get Count is called");
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
        {
            return "CREATE DEED";
        }
        if(position==1)
        {
            return "CUSTOM DEED";
        }
        if(position==2)
        {
            return "MOVEMENTS";
        }
        return null;
    }
}