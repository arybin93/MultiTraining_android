package com.example.multitraining;

import java.util.ArrayList;
import java.util.Arrays;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.example.multitraining.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class StatActivity extends Activity {
	private XYPlot plot;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stat);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		DBHelper db = new DBHelper(this);

		// Inflate the menu; this adds items to the action bar if it is present.
		plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
				
		ArrayList<Integer> arrList;
		arrList = db.returnQuantity();
				
		XYSeries series1 = new SimpleXYSeries(arrList,
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");	
		XYSeries series2 = new SimpleXYSeries(Arrays.asList(0),
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");	
		XYSeries series3 = new SimpleXYSeries(Arrays.asList(100),
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");	

		LineAndPointFormatter series1Format = new LineAndPointFormatter();
		series1Format.setPointLabelFormatter(new PointLabelFormatter());

		// add a new series' to the xyplot:
		plot.addSeries(series1, series1Format);
		plot.addSeries(series2, series1Format);
		plot.addSeries(series3, series1Format);		
	}
}
