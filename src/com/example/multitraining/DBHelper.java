package com.example.multitraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	private ContentValues contVal; // Объект для данных
	private SQLiteDatabase db;

	public DBHelper(Context context) {
		super(context, "myDB", null, 1);
		contVal = new ContentValues();
		db = this.getWritableDatabase();
	}
	
	@Override	
	public void onCreate(SQLiteDatabase db){ // Происходит, если БД не существует
		//Log.d(LOG_TAG, "--- onCreate database ---");
		db.execSQL("create table mytable ("
          + " id integer primary key autoincrement," 
          + " date text,"
          + " correctly INTEGER"
          + " incorrectly INTEGER);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // Происходит, если БД существует		
	}
	
	public void insertIntoDatabase(String date, int correctly, int incorrectly) { // Вставляет данные в таблицу
		// Подготовка данных для вставки
		contVal.put("date", date);
		contVal.put("correctly", correctly);
		contVal.put("incorrectly", incorrectly);
		
		// Вставка данных в таблицу
		db.insert("mytable", null, contVal);	
		contVal.clear();
	}
	
	
}
