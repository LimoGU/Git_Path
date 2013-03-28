package com.example.learn07;

import java.io.File;
import java.util.Random;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends Activity {
	final String DATA_BASE_NAME="students.db";
	final String TABLE_NAME="students";
	SQLiteDatabase sqLiteDatabase;
	File f;
	FileUtils fileUtils;
	TextView showText;
	Button b11,b22,b33,b44;
	ContentValues cvs[];
	Random random=new Random();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		showText=(TextView) findViewById(R.id.showTextView);
		b11=(Button) findViewById(R.id.button11);
		b22=(Button) findViewById(R.id.button22);
		b33=(Button) findViewById(R.id.button33);
		b44=(Button) findViewById(R.id.button44);
		fileUtils=new FileUtils();
		initDataBase();
		f = new File(fileUtils.getSDPATH()+"learn07/"+DATA_BASE_NAME);
		sqLiteDatabase=SQLiteDatabase.openOrCreateDatabase(f, null);
		cvs=new ContentValues[4];
		cvs[0]=new ContentValues();
		cvs[1]=new ContentValues();
		cvs[2]=new ContentValues();
		cvs[3]=new ContentValues();
		cvs[0].put("name", "小红");
		cvs[1].put("name", "小白");
		cvs[2].put("name", "小花");
		cvs[3].put("name", "小绿");
		cvs[0].put("age", "11");
		cvs[1].put("age", "12");
		cvs[2].put("age", "13");
		cvs[3].put("age", "14");
		cvs[0].put("sex", "F");
		cvs[1].put("sex", "M");
		cvs[2].put("sex", "M");
		cvs[3].put("sex", "F");
		
		
		
		b11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				add();
				search();
			}
		});
		
		b22.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				edit();
				search();
			}
		});
		
		b33.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				del();
				search();
			}
		});
		
		b44.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				search();
			}
		});
		
	}
	
	void initDataBase(){
		if(!fileUtils.isFileExist("learn07/"+DATA_BASE_NAME)){
			fileUtils.createSDDir("learn07");
			try{
				fileUtils.write2SDFromInput("learn07/", DATA_BASE_NAME, getResources().getAssets().open("students.db"));
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
			
		}
		
	}
	
	
	/**
	 * 增加数据的方法
	 */
	void add(){
		int n=random.nextInt(4);
		sqLiteDatabase.insert(TABLE_NAME, null, cvs[n]);
	}
	
	/**
	 * 修改数据
	 */
	
	void edit(){
		int id=queryID();
		if(id!=-1){
			int n=random.nextInt(4);
			sqLiteDatabase.update(TABLE_NAME, cvs[n], "id=?", new String[]{""+id});
			
		}

	}
	
	void del(){
		int id=queryID();
		if(id!=-1){
			sqLiteDatabase.delete(TABLE_NAME, "id=?", new String[]{""+id});
		}
		
	}
	
	/**
	 * 查询方法
	 */
	Cursor query(){
		Cursor c=sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
		return c;
	}
	/**
	 * int
	 * @return
	 */
	int queryID(){
		int id=-1;
		Cursor c=sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
		if(c!=null){
			if(c.moveToNext()){
				id=c.getInt(0);
			}
		}
		return id;
	}
	
	/**
	 * 查询数据
	 */
	void search(){
		StringBuilder sbf=new StringBuilder("");
		Cursor c=query();
		if(c!=null){
			while(c.moveToNext()){
				
				sbf.append(c.getInt(0)+" ");
				sbf.append(c.getString(1)+" ");
				sbf.append(c.getString(2)+" ");
				sbf.append(c.getString(3)+"\n");
			}
		}
		
		showText.setText(sbf.toString());
	}
}
