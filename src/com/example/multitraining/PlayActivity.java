package com.example.multitraining;

import java.util.Date;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayActivity extends Activity {
	
	 private static final int MILLIS_PER_SECOND = 1000;
	 private static final int SECONDS_TO_COUNTDOWN = 31;
	 private TextView     countdownDisplay;
	 private CountDownTimer timer;
	
	 String answer; 
	 private int result;
	 private int countRight = 0;
	 private int countError = 0;
	 
	 DBHelper dbHelper;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);	
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		OnGenerationExample();  // generation example
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		Button btn5 = (Button) findViewById(R.id.button5);
		Button btn6 = (Button) findViewById(R.id.button6);
		Button btn7 = (Button) findViewById(R.id.button7);
		Button btn8 = (Button) findViewById(R.id.button8);
		Button btn9 = (Button) findViewById(R.id.button9);
		Button btn0 = (Button) findViewById(R.id.buttonZero);
		Button btnC = (Button) findViewById(R.id.buttonClear);
		Button btnAnswer = (Button) findViewById(R.id.buttonAnswer);
		
		btn1.setOnClickListener(clikBtn);
		btn2.setOnClickListener(clikBtn);
		btn3.setOnClickListener(clikBtn);
		btn4.setOnClickListener(clikBtn);
		btn5.setOnClickListener(clikBtn);
		btn6.setOnClickListener(clikBtn);
		btn7.setOnClickListener(clikBtn);
		btn8.setOnClickListener(clikBtn);
		btn9.setOnClickListener(clikBtn);
		btn0.setOnClickListener(clikBtn);
		btnC.setOnClickListener(clikBtn);
		btnAnswer.setOnClickListener(clikBtn);

		
		dbHelper = new DBHelper(this);
		
		CharSequence currentDateTimeString = DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date());		
		dbHelper.insertIntoDatabase(String.valueOf(currentDateTimeString), 0, 0);
		dbHelper.removeSuperfluousRecords();
		
		countdownDisplay = (TextView) findViewById(R.id.textTime);
	    showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);    // run Timer	    
	}
	
	private void showTimer(int countdownMillis) { 
		  if(timer != null) { timer.cancel(); }
		  timer = new CountDownTimer(countdownMillis, MILLIS_PER_SECOND) {
		  @Override
		  public void onTick(long millisUntilFinished) {
			  countdownDisplay.setText("" +
		    millisUntilFinished / MILLIS_PER_SECOND);
			
			  if( (millisUntilFinished / MILLIS_PER_SECOND)>=100)
			  {
				   countdownDisplay.setText("You win!");
				   timer.onFinish();
			  }  
		  }
		  @Override
		    public void onFinish() {
			  Log.e("FINISH", "Time finish");
			  Log.e("FINISH", (String) countdownDisplay.getText());

		      String c = new String();
		      c = (String) countdownDisplay.getText();
		      
		      if(c.equals("You win!"))
		      {
		    	  countdownDisplay.setText("You win!");
		      } else {
		    	  countdownDisplay.setText("Game over!");
		      }
		    }
		  }.start();
		  		  
		}

	
	
	public void OnGenerationExample()
	{
		Random r =new Random();
		int num1 = r.nextInt(9)+1;
		int num2 = r.nextInt(9)+1;
	    result = num1 * num2;
	    
	    TextView Example = (TextView) findViewById(R.id.textExample);
	    Example.setText(num1 + " x " + num2);
	   
	 //  TextView AnsMessage = (TextView) findViewById(R.id.textAnswerMessage);
	 //  AnsMessage.setText("");    
	}
	
	//TextView Example = (TextView) findViewById(R.id.textExample);
	//TextView AnsMessage = (TextView) findViewById(R.id.textAnswerMessage);
	//EditText editTextAnswer = (EditText)findViewById(R.id.editTextAnswer);
	
	OnClickListener clikBtn = new OnClickListener() {
	       @Override
	       public void onClick(View v) {
	    	   switch(v.getId()) {
	   	    case R.id.button1:
	   	    	addNumberEvent("1");
	   	        break;
	   	    case R.id.button2:
	   	    	addNumberEvent("2");
	   	        break;
	   	    case R.id.button3:
	   	    	addNumberEvent("3");
	   	        break;
	   	    case R.id.button4:
	   	    	addNumberEvent("4");
	   	        break;
	   	    case R.id.button5:
	   	    	addNumberEvent("5");
	   	        break;
	   	    case R.id.button6:
	   	    	addNumberEvent("6");
	   	        break;
	   	    case R.id.button7:
	   	    	addNumberEvent("7");
	   	        break;
	   	    case R.id.button8:
	   	    	addNumberEvent("8");
	   	        break;
	   	    case R.id.button9:
	   	    	addNumberEvent("9");
	   	        break;
	   	    case R.id.buttonZero:
	   	    	addNumberEvent("0");
	   	        break; 
	   	    case R.id.buttonClear:
	   	    	EditText editTextAnswer = (EditText)findViewById(R.id.editTextAnswer);
	   	    	editTextAnswer.setText("");
	   	        break;  
	   	    case R.id.buttonAnswer:
	   	    		editTextAnswer = (EditText)findViewById(R.id.editTextAnswer);	
	   	    		answer = editTextAnswer.getText().toString();
	   	    		String res = String.valueOf(result);
	   	    		String resTest;
	   	    		TextView AnsMessage = (TextView) findViewById(R.id.textAnswerMessage);
	   	    		
	   	    		String currentTime;
	   	    		int new_time;
	   	    		
	   	    	    countdownDisplay = (TextView) findViewById(R.id.textTime);
 				    currentTime =  countdownDisplay.getText().toString();
 				    Log.e("Time", currentTime);
 				    
 				    if(currentTime.equals("Game over!") || currentTime.equals("You win!") )
 				    {  
 				    	 timer.cancel();
 				    	 Log.e("Time", currentTime);
 				    	 Intent intent = new Intent(PlayActivity.this, MainActivity.class);  // time solver
 					     startActivity(intent);		    	
 				    }
 				    else
 				    {
 				    	new_time =Integer.parseInt(currentTime);
 				    	if(answer.equals(res))
 				    	{
 				    		++countRight;
 				    		resTest =   String.valueOf(countRight); 
 				    		Log.e("countRight", resTest);

 				    		AnsMessage.setText("True!"); 
		    		
 				    		dbHelper.updateLastRecord(countRight, countError);	   		
 				    		dbHelper.read();
 				    			
 				    		new_time = new_time + 5;   /// plus time
 				    		showTimer( (new_time) * MILLIS_PER_SECOND);
	   				    
 				    	} else {
 				    		++countError;
 				    		resTest =   String.valueOf(countError); 
 				    		Log.e("countError", resTest);
 				    		AnsMessage.setText("False!");
 				    		dbHelper.updateLastRecord(countRight, countError);
 				    		dbHelper.read();
 				    		new_time = new_time - 5;      //// minus time
 				    		if(new_time>0)
 				    		{
 				    			showTimer( (new_time) * MILLIS_PER_SECOND);
 				    		}
	   	    		}
 				    }
	   	    		OnGenerationExample();
	   	    		editTextAnswer.setText("");
	   	        break; 
	    	  }        
	       }
	     };
	     
	     public void addNumberEvent(String s) {
	    	 EditText editTextAnswer = (EditText)findViewById(R.id.editTextAnswer);
	    	 if(editTextAnswer.getText().toString()=="") {
		    	 editTextAnswer.setText(s);
		     } else {
		    	 answer = editTextAnswer.getText().toString();
		    	 editTextAnswer.setText(answer + s);
		     }	 
	     }
}


	
	 /* try {
			TimeUnit.SECONDS.sleep(1); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			   	    	Intent intent = getIntent();
						finish();
						startActivity(intent);
	 */	