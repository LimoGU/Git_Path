package com.example.learn08_2;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Employess {
	public static final String AUTHORITY="com.example.learn08.Employess";
	private Employess(){}
	public static final class Employee implements BaseColumns{
		private Employee() {}
		
		public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/employee");
		public static final String CONTENT_TYPE="vnd.android.cursor.dir/vnd.learn08.employess";
		public static final String CONTENT_ITEM_TYPE="vnd.android.cursor.item/vnd.learn08.employess";
		
		public static final String DEFAULT_SORT_ORDER="name DESC";
		
		public static final String NAME="name";
		public static final String GENDER="gender";
		public static final String AGE="age";
		
	}
	
}
