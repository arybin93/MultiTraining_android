package com.example.multitraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	private ContentValues contVal = new ContentValues(); // ������ ��� ������
	private SQLiteDatabase db = this.getWritableDatabase();	

	public DBHelper(Context context) {
		super(context, "myDB.db", null, 1);
		//contVal = new ContentValues();
		//db = this.getWritableDatabase();
	}
	
	@Override	
	public void onCreate(SQLiteDatabase db){ // ����������, ���� �� �� ����������
		Log.d("DB", "--- onCreate database ---");
		db.execSQL("create table mytable ("
          + " id integer primary key autoincrement, " 
          + " date text, "
          + " correctly INTEGER, "
          + " incorrectly INTEGER);");
		Log.d("DB", "DB created!");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // ����������, ���� �� ����������		
	}
	
	public void insertIntoDatabase(String date, String correctly, String incorrectly) { // ��������� ������ � �������
		// ���������� ������ ��� �������
		contVal.put("date", date);
		contVal.put("correctly", correctly);
		contVal.put("incorrectly", incorrectly);
		
		// ������� ������ � �������
		db.insert("mytable", null, contVal);	
		Log.d("DB", "Insert in mytable complite!");
		contVal.clear();
	}
	
	public void read(){
		Cursor c = db.query("mytable", null, null, null, null, null, null);
		
		// ���� � ������� ��� �����, �������� false
		if (c.moveToFirst()) {

	        // ���������� ������ �������� �� ����� � �������
	        int idColIndex = c.getColumnIndex("id");
	        int dateColIndex = c.getColumnIndex("date");
	        int correctlyColIndex = c.getColumnIndex("correctly");
	        int incorrectlyColIndex = c.getColumnIndex("incorrectly");

	        do {
	          // �������� �������� �� ������� �������� � ����� ��� � ���
	          Log.d("DB",
	              "ID = " + c.getInt(idColIndex) + 
	              ", date = " + c.getString(dateColIndex) + 
	              ", correctly = " + c.getString(correctlyColIndex) +
	              ", incorrectly = " + c.getString(incorrectlyColIndex));
	          // ������� �� ��������� ������ 
	          // � ���� ��������� ��� (������� - ���������), �� false - ������� �� �����
	        } while (c.moveToNext());
	      } else
	        Log.d("DB", "0 rows");
	      c.close();				
	}
	
}
