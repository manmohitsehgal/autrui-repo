package com.example.autrui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rish on 20/04/2014.
 */
public class HelpOne extends Fragment {
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Log.d("Rish","onAttach");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            //Log.d("Rish","onCreate FIRST TIME");
        }
        else
        {
            //Log.d("Rish","onCreate SUBSEQUENT TIME");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        //Log.d("Rish","onCreateView");
        return inflater.inflate(R.layout.help_one, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Log.d("Rish","onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        //Log.d("Rish","onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        //Log.d("Rish","onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        //Log.d("Rish","onPause");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Log.d("Rish","onSaveInstanceState");

    }

    @Override
    public void onStop() {
        super.onStop();
        //Log.d("Rish","onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Log.d("Rish","onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Log.d("Rish","onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Log.d("Rish","onDetach");

    }
}