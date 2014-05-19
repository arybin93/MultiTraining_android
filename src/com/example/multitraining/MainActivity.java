package com.example.multitraining;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}	
	
	public void onStartTren(View v)
	{
		Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
	    startActivity(intent);	
	}
	
	public void onStartPlay(View v)
	{
		Intent intent = new Intent(MainActivity.this, PlayActivity.class);
	    startActivity(intent);	
	}
	
	public void onOpenStat(View v)
	{
		Intent intent = new Intent(MainActivity.this, StatActivity.class);
	    startActivity(intent);	
	}
	
//////
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

/*
 * 
 *     
     <TextView
            android:id="@+id/textAnswerMessage"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="2"
            android:textSize="20pt"
            android:text=""
            android:visibility="invisible" />
 * 
 */
