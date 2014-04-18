package com.example.multitraining;

import java.util.Random;

import com.example.multitraining.DownFragment.onEventListener;

import android.app.Fragment;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.text.style.UpdateLayout;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class TrainingActivity extends Activity implements onEventListener {
	//TextView textExample;
	String answer; 
	int result;
	int countRight = 0;
	int countError = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training);	
	}
	
	public int OnStart(View v)
	{
		Random r =new Random();
		int num1 = r.nextInt(9)+1;
		int num2 = r.nextInt(9)+1;
	    result = num1 * num2;
	    
		Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentUp);
		    ((TextView) fragUp.getView().findViewById(R.id.textRightAnswer)).setVisibility(4);
		    ((TextView) fragUp.getView().findViewById(R.id.textAnswerMessage)).setVisibility(4);
		    ((TextView) fragUp.getView().findViewById(R.id.textExample)).setText(num1 + " x " + num2);
		    ((TextView) fragUp.getView().findViewById(R.id.textRightAnswer)).setText(""+result);
			((TextView)fragUp.getView().findViewById(R.id.textAnswer)).setText("");
		    return result;
	}
	
	 public void addNumberEvent(String s) {
		  Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentUp);
	     if(((TextView)fragUp.getView().findViewById(R.id.textAnswer)).getText()=="") {
	    	 ((TextView)fragUp.getView().findViewById(R.id.textAnswer)).setText(s);
	     } else {
	    	 answer = (String) ((TextView)fragUp.getView().findViewById(R.id.textAnswer)).getText();
	    	 ((TextView)fragUp.getView().findViewById(R.id.textAnswer)).setText(answer + s);
	     }
	  }
	
		public void numberClearEvent() {
			Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentUp);
			((TextView)fragUp.getView().findViewById(R.id.textAnswer)).setText("");
		}

	   public void SolverEvent() {
		   Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentUp);
		   answer = (String) ((TextView)fragUp.getView().findViewById(R.id.textAnswer)).getText();
		   String res = (String) ((TextView)fragUp.getView().findViewById(R.id.textRightAnswer)).getText();
		   String res1;
		   
		   Log.i("!", res);
		   Log.i("!!", answer);
		   
		   if(answer.equals(res))
		   {
			   ++countRight;
			   res1 =   String.valueOf(countRight); 
			   ((TextView) fragUp.getView().findViewById(R.id.textRightAnswer)).setVisibility(0);
			   ((TextView) fragUp.getView().findViewById(R.id.textAnswerMessage)).setText("True!");
			   ((TextView) fragUp.getView().findViewById(R.id.textAnswerMessage)).setVisibility(0);
			   Log.e("countRight", res1);
		   } 
		   else
		   {
			   ++countError;
			   ((TextView) fragUp.getView().findViewById(R.id.textRightAnswer)).setVisibility(0);
			   ((TextView) fragUp.getView().findViewById(R.id.textAnswerMessage)).setText("False!");
			   ((TextView) fragUp.getView().findViewById(R.id.textAnswerMessage)).setVisibility(0);
			   res1 =   String.valueOf(countError); 
			   Log.e("countError", res1);
		   }
		  /// Work with BD:
		  Log.i("DB","DataBase");
		   
		   
		   
		  ///
		  // DBHelper db = new DBHelper(this);
		  // db.insertIntoDatabase("16-Apr-2014", 5, 0);
		  // db.close();
		  
		   //String res2 =   String.valueOf(countRight); 
		   //Log.i("countRight", res1);
		   //Log.i("countRight", res2);
	   }
	  
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig); 
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	    	Log.i("L","LANDSCAPE");
	    	
	    	Fragment fm1 = getFragmentManager().findFragmentById(R.id.fragmentUp);
	    	RelativeLayout.LayoutParams lp1 = (RelativeLayout.LayoutParams) fm1.getView().getLayoutParams();
	    	lp1.addRule(RelativeLayout.BELOW, R.id.buttonStart);
	    	lp1.width = LayoutParams.WRAP_CONTENT;
	    	fm1.getView().setLayoutParams(lp1);
	    	fm1.getView().requestLayout();
	    	
	    	Fragment fm2 = getFragmentManager().findFragmentById(R.id.fragmentDown);
	    	RelativeLayout.LayoutParams lp2 = (RelativeLayout.LayoutParams) fm2.getView().getLayoutParams();
	    	lp2.addRule(RelativeLayout.RIGHT_OF, R.id.fragmentUp);
	    	lp2.addRule(RelativeLayout.BELOW, R.id.buttonStart);
	    	fm2.getView().setLayoutParams(lp2);
	    	fm2.getView().requestLayout();
	    } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
	    {
	    	Log.i("P","PORTRAIT");
	    	Fragment fm1 = getFragmentManager().findFragmentById(R.id.fragmentUp);
	    	RelativeLayout.LayoutParams lp1 = (RelativeLayout.LayoutParams) fm1.getView().getLayoutParams();
	    	lp1.addRule(RelativeLayout.BELOW, R.id.buttonStart);
	    	lp1.width = LayoutParams.MATCH_PARENT;
	    	fm1.getView().setLayoutParams(lp1);
	    	fm1.getView().requestLayout();
	    	
	    	Fragment fm2 = getFragmentManager().findFragmentById(R.id.fragmentDown);
	    	RelativeLayout.LayoutParams lp2 = (RelativeLayout.LayoutParams) fm2.getView().getLayoutParams();
	    	lp2.addRule(RelativeLayout.BELOW, 0);
	    	lp2.addRule(RelativeLayout.RIGHT_OF, 0);
	    	lp2.addRule(RelativeLayout.BELOW, R.id.fragmentUp);
	    	//lp2.addRule(RelativeLayout.BELOW, R.id.buttonStart);
	    	fm2.getView().setLayoutParams(lp2);
	    	fm2.getView().requestLayout();
	    } 
	}
}

//fm1.getView().setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));


//
//lp1.removeRule(LayoutParams.MATCH_PARENT);
//lp1.addRule(LayoutParams.WRAP_CONTENT);
//lp1.addRule(LayoutParams.MATCH_PARENT);
//lp1.addRule(LayoutParams.WRAP_CONTENT, R.id.fragmentUp);

//fm1.getView().setLayoutParams(lp1);
//RelativeLayout.LayoutParams lp1 = (RelativeLayout.LayoutParams) fm1.getView().getLayoutParams();
//lp1.addRule(RelativeLayout.LayoutParams.));
//lp.removeRule(RelativeLayout.BELOW);
//lp.addRule(RelativeLayout.LayoutParams.WRAP_CONTENT,R.id.fragmentUp);
//lp.addRule(RelativeLayout.BELOW, R.id.buttonStart);
 //requestLayout();
//lp.addRule(RelativeLayout.RIGHT_OF, R.id.fragmentUp);



//        android:layout_toRightOf="@id/fragmentUp"
//        android:layout_below="@+id/button1"


//android:screenOrientation="portrait"
//android:screenOrientation="landscape"
//


//Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentDown);
	  //  if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

	    	//Fragment fragUp = getFragmentManager().findFragmentById(R.id.fragmentDown);
	    	//answer = (String) ((TextView)fragUp.getView().findViewById(R.id.textAnswer)).getText();
	    	
			
		   //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
	  //  } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
	       // Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
	  //  }


/////   android:name="com.example.multitraining.DownFragment"
	/*
	 * 
	 * 	
	private String getScreenOrientation(){    
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
		    return "Portret";
		else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			return "Albom";
		else
			return "";
	}
	
	 * 
    	<FrameLayout
    	    android:id="@+id/fragmentUp"
    	    android:layout_width="match_parent"
    	    android:layout_height="wrap_content" >

		</FrameLayout>

    	<FrameLayout
    	    android:id="@+id/fragmentDown"
    	    android:layout_width="match_parent"
    	    android:layout_height="wrap_content" >
    	</FrameLayout>
	 * 
	 * 
	 * <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity" >

    
    	
</LinearLayout>
	 * 
	 * public void GenerationExample()
	{
		
		textExample = (TextView)findViewById(R.id.textExample);
		textExample.setText(num1 + " x " + num2);
	
	 public void onClick(View v) {
    Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
    ((TextView) frag1.getView().findViewById(R.id.textView))
        .setText("Access to Fragment 1 from Activity");

    Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
    ((TextView) frag2.getView().findViewById(R.id.textView))
        .setText("Access to Fragment 2 from Activity");
  }
	
	   <fragment
        android:id="@+id/fragmentDown"
        android:name="com.example.multitraining.DownFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="2" />
	
	 <fragment
        android:id="@+id/fragmentUp"
        android:name="com.example.multitraining.UpFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="2" />
	
	
	}*/
	//
	
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
/*
 * 
 * 
 * 
 * 
 * LinearLayout1
 * 
 * 
 * 
 * 
 * 		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
 * 
 * 
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.multitraining.MainActivity"
    tools:ignore="MergeRootFrame" />
	
	
	
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.multitraining.MainActivity$PlaceholderFragment" >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />

</RelativeLayout>

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent" 
    android:gravity="center">
    
    <fragment android:name="com.example.multitraining.MainFragment"
            android:id="@+id/fragment"
            android:layout_width="0dp"
            android:layout_height="match_parent" />
</RelativeLayout>
	
	
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin" 
    tools:context="com.example.multitraining.MainFragment" >

    <TextView
        android:id="@+id/textHello"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />
   
</LinearLayout>


// Button start = (Button)findViewById(R.id.button1);
		 
		// FragmentManager fm = getFragmentManager();
	   //  FragmentTransaction ft = fm.beginTransaction();
	     
	    // UpFragment uf = new UpFragment();
	    // DownFragment df = new DownFragment();
	     
	     //onConfigurationChanged(getResources().getConfiguration());
	     
	    /* 
	     if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
	           /// setContentView(R.layout.qwerty);
	    	 Log.i("1","LANDSCAPE");
	     } else
	     {
	    	  Log.i("2","Portret");
	     }
	     */
	    // ft.add(R.id.fragmentUp, uf);
	   //  ft.add(R.id.fragmentDown, df);
	   //  ft.addToBackStack(null);
	   //  ft.commit();



