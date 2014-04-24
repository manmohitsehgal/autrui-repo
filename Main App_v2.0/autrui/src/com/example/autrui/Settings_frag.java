package com.example.autrui;

import com.parse.ParseUser;

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
public class Settings_frag extends Fragment implements OnClickListener {

	Intent intent = new Intent();

	public Settings_frag() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.settings_frag, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Button aboutUs = (Button) getActivity().findViewById(R.id.bAboutUs);
		Button help = (Button) getActivity().findViewById(R.id.bHelp);
		Button editPP = (Button) getActivity().findViewById(R.id.bEditPP);
		Button logout = (Button) getActivity().findViewById(R.id.bLogOut);
		Button changePass = (Button) getActivity().findViewById(
				R.id.bChangePass);

		aboutUs.setOnClickListener(this);
		help.setOnClickListener(this);
		editPP.setOnClickListener(this);
		logout.setOnClickListener(this);
		changePass.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.bAboutUs) {
			intent = new Intent(v.getContext(), AboutUs.class);
			startActivityForResult(intent, 0);
		} else if (id == R.id.bChangePass) {
			intent = new Intent(v.getContext(), ChangePassword.class);
			startActivityForResult(intent, 0);
		} else if (id == R.id.bEditPP) {
			intent = new Intent(v.getContext(), EditPP.class);
			startActivityForResult(intent, 0);
		} else if (id == R.id.bLogOut) {
			ParseUser currentUser = ParseUser.getCurrentUser();
			currentUser.logOut();
			intent = new Intent(v.getContext(), Login.class);
			startActivityForResult(intent, 0);
		} else if (id == R.id.bHelp) {
			intent = new Intent(v.getContext(), Help.class);
			startActivityForResult(intent, 0);
		}
	}

}
