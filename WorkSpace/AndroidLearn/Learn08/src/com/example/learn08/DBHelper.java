package com.example.learn08;

import com.example.learn08.Employess.Employee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME="Employees.db";
	private static final int DATABASE_VERSION=1;
	public static final String EMPLOYEES_TABLE_NAME="employee";
	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+EMPLOYEES_TABLE_NAME+"("
				+Employee._ID+" INTEGER PRIMARY KEY,"
				+Employee.NAME+" TEXT,"
				+Employee.GENDER+" TEXT,"
				+Employee.AGE+" INTEGER"
				+")");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS employee");
		onCreate(db);
	}

}
