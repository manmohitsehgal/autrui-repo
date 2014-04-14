package com.example.autrui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class Movement_frag extends Fragment implements OnClickListener {

	Intent intent = new Intent();

	public Movement_frag() {
		// Required empty public constructor
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		
		return inflater.inflate(R.layout.movement_frag, container,
				false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		

		Button cDeed = (Button) getActivity().findViewById (R.id.bDeed);
		Button myMovement = (Button) getActivity().findViewById (R.id.bMovements);
		Button chooseDeed = (Button) getActivity().findViewById (R.id.bChoosedeed);
		
		cDeed.setOnClickListener(this);
		myMovement.setOnClickListener(this);
		chooseDeed.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.bDeed) {
			intent = new Intent(v.getContext(), CreateDeed.class);
			startActivityForResult(intent, 0);
		} else if (id == R.id.bMovements) {
			intent = new Intent(v.getContext(), MyMovement.class);
			startActivityForResult(intent, 0);
		} else if (id == R.id.bChoosedeed) {
			intent = new Intent(v.getContext(), ChooseDeed.class);
			startActivityForResult(intent, 0);
		}
	}

}
