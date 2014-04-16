package com.example.multitraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	private ContentValues contVal; // ������ ��� ������
	private SQLiteDatabase db;

	public DBHelper(Context context) {
		super(context, "myDB", null, 1);
		contVal = new ContentValues();
		db = this.getWritableDatabase();
	}
	
	@Override	
	public void onCreate(SQLiteDatabase db){ // ����������, ���� �� �� ����������
		//Log.d(LOG_TAG, "--- onCreate database ---");
		db.execSQL("create table mytable ("
          + " id integer primary key autoincrement," 
          + " date text,"
          + " correctly INTEGER"
          + " incorrectly INTEGER);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // ����������, ���� �� ����������		
	}
	
	public void insertIntoDatabase(String date, int correctly, int incorrectly) { // ��������� ������ � �������
		// ���������� ������ ��� �������
		contVal.put("date", date);
		contVal.put("correctly", correctly);
		contVal.put("incorrectly", incorrectly);
		
		// ������� ������ � �������
		db.insert("mytable", null, contVal);	
		contVal.clear();
	}
	
	
}
