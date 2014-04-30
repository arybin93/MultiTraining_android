package com.example.multitraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	private ContentValues contVal = new ContentValues(); 
	private SQLiteDatabase db = this.getWritableDatabase();	

	public DBHelper(Context context) {
		super(context, "myDB.db", null, 1);		
	}
	
	@Override	
	public void onCreate(SQLiteDatabase db){ // Occurs if the DB doesn't exist
		Log.d("DB", "--- onCreate database ---");
		db.execSQL("create table mytable ("
          + " id integer primary key autoincrement, " 
          + " date text, "
          + " correctly INTEGER, "
          + " incorrectly INTEGER);");
		Log.d("DB", "DB created!");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // Occurs if the DB exist	
	}
	
	public void insertIntoDatabase(String date, int correctly, int incorrectly) { // Insert data
		// Preparation of data for an insert
		contVal.put("date", date);
		contVal.put("correctly", correctly);
		contVal.put("incorrectly", incorrectly);
		
		// Insert of data in the table
		db.insert("mytable", null, contVal);	
		Log.d("DB", "Insert in mytable complite!");
		contVal.clear();
	}
	
	public void read(){
		Cursor c = db.query("mytable", null, null, null, null, null, null);
		
		// if in selection there are no lines, false will return
		if (c.moveToFirst()) {

	        // define numbers of columns by name in selection
	        int idColIndex = c.getColumnIndex("id");
	        int dateColIndex = c.getColumnIndex("date");
	        int correctlyColIndex = c.getColumnIndex("correctly");
	        int incorrectlyColIndex = c.getColumnIndex("incorrectly");

	        do {
	          // write
	          Log.d("DB",
	              "ID = " + c.getInt(idColIndex) + 
	              ", date = " + c.getString(dateColIndex) + 
	              ", correctly = " + c.getString(correctlyColIndex) +
	              ", incorrectly = " + c.getString(incorrectlyColIndex));
	          // next line 	          
	        } while (c.moveToNext());
	      } else
	        Log.d("DB", "0 rows");
	      c.close();				
	}
	
	protected String searchMaximumId(){
		String rez = null;
		Cursor c = db.rawQuery("SELECT MAX(id) AS maxId FROM mytable;", null);
		if(c.moveToFirst()){
			rez = c.getString(c.getColumnIndex("maxId"));		
		}
		c.close();		
		return rez;
	}
	
	public void updateLastRecord(int correctly, int incorrectly){
		db.execSQL("UPDATE mytable SET correctly = '" + String.valueOf(correctly) + "' , incorrectly = '" + String.valueOf(incorrectly) + "' WHERE id = " + searchMaximumId() + ";");		
	}	
	
	public void deleteDB()
	{
		db.execSQL("DELETE FROM mytable;");  //  DELETE * FROM mytable;
	}
	
}
