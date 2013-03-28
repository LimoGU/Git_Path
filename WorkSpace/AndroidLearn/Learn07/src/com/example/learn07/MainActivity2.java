package com.example.learn07;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends Activity{
	static final String FILE_NAME="temp.txt";
	EditText re,we;
	Button rb,wb,cg;
	String msg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		re=(EditText) findViewById(R.id.readEditText);
		we=(EditText) findViewById(R.id.writeEditText);
		rb=(Button) findViewById(R.id.readButton);
		wb=(Button) findViewById(R.id.writeButton);
		cg=(Button) findViewById(R.id.changeButton);
		
		rb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				msg=read();
				if(msg!=null){
					re.setText(msg);
					
				}
				
			}
		});
		
		wb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				msg=we.getText().toString();
				if(msg!=null){
					write(msg);
					
				}
				
			}
		});
		
		cg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity2.this, MainActivity3.class);
				startActivity(intent);
				
			}
		});
		
		
	}

	/**
	 * 读取数据的方法
	 * @return
	 */
	String read(){
		try{
		FileInputStream fis=openFileInput(FILE_NAME);
		byte[] buffer=new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return new String(buffer);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * 写入数据的方法
	 * @param msg
	 */
	void write(String msg){
		try{
		FileOutputStream fos=openFileOutput(FILE_NAME, MODE_PRIVATE);
		fos.write(msg.getBytes());
		fos.close();
	
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	
	}	
}
