package com.example.multitraining;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class StatUpFragment extends Fragment  {
	
	
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.setRetainInstance(true);
		View fragment = inflater.inflate(R.layout.fragment_stat_up, container, false);
		
		Button button1 = (Button) fragment.findViewById(R.id.butClear);
	    button1.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	//DBHelper db = new DBHelper(getActivity());
	  		//db.deleteDB();
	  		Log.i("DB", "Delete DB");
	      }
	    });
		
		DBHelper db = new DBHelper(getActivity());
		ArrayList<String> dataList = new ArrayList<String>();
		dataList = db.select();
		
		for (int i = dataList.size() - 5; i < dataList.size()  ; i++) {
			Log.e("DB", dataList.get(i)); // last 5 count
		}
		/*
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataList);
		
		Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentStatUp);
		ListView lv = ((ListView) fragUp.getView().findViewById(R.id.list));
		lv.setAdapter(dataAdapter);
		registerForContextMenu(lv);
	    */
		return fragment;
	}

		
		
	
}
