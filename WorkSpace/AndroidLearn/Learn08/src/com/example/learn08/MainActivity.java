package com.example.learn08;

import java.util.Random;

import com.example.learn08.Employess.Employee;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView;
	private Button b1,b2,b3,b4;
	private int id=0;
	private final Random random=new Random();
	private int ID=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView) findViewById(R.id.textView1);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				insert();
				query();
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				update();
				query();
				
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				del();
				query();
				
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				query();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void del(){
			Uri uri=ContentUris.withAppendedId(Employee.CONTENT_URI, 1);
			getContentResolver().delete(uri, "_id=?", new String[]{query()+""});

	}
	private void update(){
		Uri uri=ContentUris.withAppendedId(Employee.CONTENT_URI, 1);
		ContentValues cv=new ContentValues();
		cv.put(Employee.NAME, random.nextBoolean()?"小红":"小明");
		cv.put(Employee.GENDER, random.nextBoolean()?"男":"女");
		cv.put(Employee.AGE, random.nextBoolean()?10:11);
		getContentResolver().update(uri, cv,"_id=?", new String[]{query()+""});
	}
	
	private int query(){
		StringBuilder sb=new StringBuilder();
		int tempId=-1;
		String PROJECTION[]=new String[]{
			Employee._ID,
			Employee.NAME,
			Employee.GENDER,
			Employee.AGE,
		};
		Cursor c=managedQuery(Employee.CONTENT_URI, PROJECTION, null, null, null);
		if(c!=null){
			while(c.moveToNext()){
				if(tempId==-1){
					tempId=c.getInt(0);
				}
				sb.append(c.getInt(0)+"\t");
				sb.append(c.getString(1)+"\t");
				sb.append(c.getString(2)+"\t");
				sb.append(c.getInt(3)+"\n");
			}
		}
		textView.setText(sb.toString());
		return tempId;
	}

	private void insert(){
		Uri uri=Employee.CONTENT_URI;
		ContentValues cv=new ContentValues();
		cv.put(Employee.NAME, random.nextBoolean()?"小红":"小明");
		cv.put(Employee.GENDER, random.nextBoolean()?"男":"女");
		cv.put(Employee.AGE, random.nextBoolean()?10:11);
		getContentResolver().insert(uri, cv);
		id++;
	}
}
