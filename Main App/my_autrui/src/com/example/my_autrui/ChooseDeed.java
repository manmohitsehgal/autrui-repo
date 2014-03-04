package com.example.my_autrui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChooseDeed extends ListActivity {

	String classes[] = { "Cooked food for", "Bought coffee for", "Helped Carry luggage for","Paid for groceries for",
			"Helped take out the trash for","Held the door open at","Donated groceries at","Donated clothes at"
			,"Gave a generous tip at","Let    cut in front of me in a line","Let someonecut in front of me in a line at"
			,"Gave a home person a cup of cofee at ","Volunteered to do a task at","Washed dishes for","Left a thank you not for",
			"Baked cookies for", "Offered to babysit for","Paid bull for     in line behind me","Sent flowers for ","Made breakfast for",
			"Planted a tree with   at    ","Recycled waste for    ,at   "};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(ChooseDeed.this,
				android.R.layout.simple_list_item_1, classes));
	}

		//Doesnt work. So ya lol. 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		//String cheese= classes[position];
		//Class ourClass = Class.forName("."+cheese);
		Intent ourIntent = new Intent(ChooseDeed.this, PostDeed.class);
		ourIntent.putExtra("selectedText", classes[position]);
		startActivity(ourIntent);
	}

}
