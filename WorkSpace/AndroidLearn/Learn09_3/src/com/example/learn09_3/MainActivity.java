package com.example.learn09_3;

import java.io.File;
import java.io.IOException;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	ImageButton start,stop;
	MediaRecorder mr;
	String path;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start=(ImageButton) findViewById(R.id.imageButton1);
		stop=(ImageButton) findViewById(R.id.imageButton2);
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				record();
				
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				stop();
				
			}
		});
		
		setup();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void setPath() throws IOException{
		path="sdcard/test1.mp3";
		String stats=android.os.Environment.getExternalStorageState();
		if(!stats.equals(android.os.Environment.MEDIA_MOUNTED)){
			throw new IOException("SD卡没有安装。他的状态"+stats+".");
		}
		
		File directory=new File(path).getParentFile();
		if(!directory.exists()&&!directory.mkdirs()){
			throw new IOException("文具不能创建");
		}
		
	}

	@Override
	protected void onDestroy() {
		if(stop.isEnabled()){
			stop();
		}
		super.onDestroy();
	}
	
	private void record(){
		
		try {
			mr.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mr.start();
		start.setEnabled(false);
		stop.setEnabled(true);
		
	}
	
	
	public void stop(){
		mr.stop();
		stop.setEnabled(false);
		start.setEnabled(true);
		mr.release();
		
	}
	
	public void setProperty(){
		
		mr=new MediaRecorder();
		
		mr.setAudioSource(MediaRecorder.AudioSource.MIC);
		mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		
		try {
			setPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mr.setOutputFile(path);
		
		
	}
	
	private void  setup(){
		setProperty();
		start.setEnabled(true);
		stop.setEnabled(false);
		
		
	}
	
}
