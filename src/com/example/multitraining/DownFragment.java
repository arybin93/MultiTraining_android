package com.example.multitraining;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DownFragment extends Fragment {
	
	 public interface onEventListener {
		    public void addNumberEvent(String s);
		    public void numberClearEvent();
		    public void SolverEvent();
		  }
		  
		  onEventListener EventListener;
	
    @Override
		  public void onAttach(Activity activity) {
		    super.onAttach(activity);
		        try {
		          EventListener = (onEventListener) activity;
		        } catch (ClassCastException e) {
		            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
		        }
		  }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View fragment = inflater.inflate(R.layout.fragment_down, container, false);
		this.setRetainInstance(true);
		Button button1 = (Button) fragment.findViewById(R.id.button1);
	    button1.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("1"); 
	    	  //    ((Button)getActivity().findViewById(R.id.btnFind)).setText("Access from Fragment1");
	      }
	    });
	    
	    Button button2 = (Button) fragment.findViewById(R.id.button2);
	    button2.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("2"); 
	      }
	    });
	    
	    Button button3 = (Button) fragment.findViewById(R.id.button3);
	    button3.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("3"); 
	      }
	    });
	    
	    Button button4 = (Button) fragment.findViewById(R.id.button4);
	    button4.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("4"); 
	      }
	    });
	    
	    Button button5 = (Button) fragment.findViewById(R.id.button5);
	    button5.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("5"); 
	      }
	    });
	    
	    
	    Button button6 = (Button) fragment.findViewById(R.id.button6);
	    button6.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("6"); 
	      }
	    });
	    
	    
	    Button button7 = (Button) fragment.findViewById(R.id.button7);
	    button7.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("7"); 
	      }
	    });
	    
	    Button button8 = (Button) fragment.findViewById(R.id.button8);
	    button8.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("8"); 
	      }
	    });
	    
	    Button button9 = (Button) fragment.findViewById(R.id.button9);
	    button9.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("9"); 
	      }
	    });
	    
	    Button buttonZero = (Button) fragment.findViewById(R.id.buttonZero);
	    buttonZero.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.addNumberEvent("0"); 
	      }
	    });
	    
	    Button buttonClear = (Button) fragment.findViewById(R.id.buttonClear);
	    buttonClear.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.numberClearEvent(); 
	      }
	    });
	    
	    Button buttonAnswer = (Button) fragment.findViewById(R.id.buttonAnswer);
	    buttonAnswer.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	  EventListener.SolverEvent(); 
	      }
	    });
	    
		return fragment;
	}
}
