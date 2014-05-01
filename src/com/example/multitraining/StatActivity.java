package com.example.multitraining;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class StatActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stat);	
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//DBHelper db = new DBHelper(this);
		
		//db.deleteDB();
		//Log.i("DB", "Delete DB");
	}
}
