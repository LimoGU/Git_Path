package com.example.learn08;

import java.util.HashMap;

import com.example.learn08.Employess.Employee;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class EmployeeProvider extends ContentProvider {
	private DBHelper dbHelper;
	private static final  UriMatcher SURI_MATCHER;
	private static final int EMPLOYEE=1;
	private static final int EMPLOYEE_ID=2;
	private static HashMap<String , String> empProjectionMap;
	static{
		SURI_MATCHER=new UriMatcher(UriMatcher.NO_MATCH);
		SURI_MATCHER.addURI(Employess.AUTHORITY, "employee", EMPLOYEE);
		SURI_MATCHER.addURI(Employess.AUTHORITY, "employee/#", EMPLOYEE);
			
		empProjectionMap=new HashMap<String, String>();
		empProjectionMap.put(Employee._ID, Employee._ID);
		empProjectionMap.put(Employee.NAME, Employee.NAME);
		empProjectionMap.put(Employee.GENDER, Employee.GENDER);
		empProjectionMap.put(Employee.AGE, Employee.AGE);
	
		
		
	}
	@Override
	public int delete(Uri uri, String arg1, String[] arg2) {
		SQLiteDatabase db=dbHelper.getWritableDatabase();
		int count;
		switch(SURI_MATCHER.match(uri)){
		case EMPLOYEE:{
			count=db.delete(DBHelper.EMPLOYEES_TABLE_NAME, arg1, arg2);
		}break;
		case EMPLOYEE_ID:{
			String noteId=uri.getPathSegments().get(1);
			count=db.delete(DBHelper.EMPLOYEES_TABLE_NAME, Employee._ID+"="+(!TextUtils.isEmpty(arg1)?"AND("+arg1+')':""), arg2);
		}break;
		
		default:{
			throw new IllegalArgumentException("错误的URI"+uri);
		}

		}
		
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
		
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues cv) {
		SQLiteDatabase db=dbHelper.getWritableDatabase();
		long rodId=db.insert(DBHelper.EMPLOYEES_TABLE_NAME, Employee.NAME, cv);
		if(rodId>0){
			Uri empUri=ContentUris.withAppendedId(Employee.CONTENT_URI, rodId);
			getContext().getContentResolver().notifyChange(empUri, null);
			return empUri;
		}
		
		
		return null;
	}

	@Override
	public boolean onCreate() {
		dbHelper=new DBHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
		switch (SURI_MATCHER.match(uri)) {
		case EMPLOYEE:{
			qb.setTables(DBHelper.EMPLOYEES_TABLE_NAME);
			qb.setProjectionMap(empProjectionMap);
		}
			
			break;
		case EMPLOYEE_ID:{
			qb.setTables(DBHelper.EMPLOYEES_TABLE_NAME);
			qb.setProjectionMap(empProjectionMap);
			qb.appendWhere(Employee._ID+"="+uri.getPathSegments().get(1));
			
		}
			
			break;

		default:{
			throw new IllegalArgumentException("错误的URI"+uri);
		}
		}
		String orderBy;
		if(TextUtils.isEmpty(sortOrder)){
			orderBy=Employee.DEFAULT_SORT_ORDER;
		}else{
			orderBy=sortOrder;
		}
		
		SQLiteDatabase db=dbHelper.getReadableDatabase();
		Cursor c=qb.query(db,projection, selection, selectionArgs, null, null, orderBy);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues cv, String selection, String[] selectionArgs) {
		SQLiteDatabase db=dbHelper.getWritableDatabase();
		int count;
		switch (SURI_MATCHER.match(uri)) {
		case EMPLOYEE:
			count=db.update(DBHelper.EMPLOYEES_TABLE_NAME, cv, selection, selectionArgs);
			break;
		case EMPLOYEE_ID:
			String noteId=uri.getPathSegments().get(1);
			count=db.delete(DBHelper.EMPLOYEES_TABLE_NAME, Employee._ID+"="+(!TextUtils.isEmpty(selection)?"AND("+selection+')':""), selectionArgs);
			break;

		default:
			throw new IllegalArgumentException("错误的URI"+uri);
		}
		
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

}
