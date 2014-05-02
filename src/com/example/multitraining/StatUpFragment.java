package com.example.multitraining;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class StatUpFragment extends ListFragment {
		
	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
		 View fragment = inflater.inflate(R.layout.fragment_stat_up, null);
		 
		 
		 Button button = (Button) fragment.findViewById(R.id.butClear);
		    button.setOnClickListener(new OnClickListener() {
		      public void onClick(View v) {
		    	    DBHelper db = new DBHelper(getActivity());
			  		db.deleteAll();
		    		Log.i("DB", "Delete DB");
		      }
		    });
		    
		    return  fragment; //inflater.inflate(R.layout.fragment_stat_up, null);
		  }
	
	  public void onActivityCreated(Bundle savedInstanceState) {
		    super.onActivityCreated(savedInstanceState);

		    DBHelper db = new DBHelper(getActivity());
			ArrayList<String> dataList = new ArrayList<String>();
			ArrayList<String> data = new ArrayList<String>();
			dataList = db.select();

			if(dataList.size()==0)
			{
				String dataEmpty[] = new String[] { };
				   ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				   android.R.layout.simple_list_item_1, dataEmpty);
				   setListAdapter(adapter);
			}
			else
			{	
				int len = dataList.size();
				if(len>=5)
				{
					for (int i = dataList.size() - 5; i < dataList.size()  ; i++) {
						Log.e("DB", dataList.get(i)); // last 5 count
						data.add(dataList.get(i));
					}
				}
				else
				{
					for (int i = 0; i < dataList.size()  ; i++) {
						Log.e("DB", dataList.get(i)); // last  count
						data.add(dataList.get(i));
					}
				}
				   ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
			       android.R.layout.simple_list_item_1, data);
				   setListAdapter(adapter);				
			}
			
		  }
}


/*	
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	this.setRetainInstance(true);
	
	
	
	DBHelper db = new DBHelper(getActivity());
	ArrayList<String> dataList = new ArrayList<String>();
	dataList = db.select();
	
	for (int i = dataList.size() - 5; i < dataList.size()  ; i++) {
		Log.e("DB", dataList.get(i)); // last 5 count
	}
	
	
	 ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
		        android.R.layout.simple_list_item_1, data);
	 setListAdapter(adapter);
	
	//ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dataList);
	
	
	lv.setAdapter(dataAdapter);
	registerForContextMenu(lv);
    
	return fragment;
}
*/
	