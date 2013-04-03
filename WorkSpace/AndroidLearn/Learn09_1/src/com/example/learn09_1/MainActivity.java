package com.example.learn09_1;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements MediaPlayer.OnCompletionListener {
    ImageButton start,pause,stop;
    MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start=(ImageButton) findViewById(R.id.imageButton1);
		pause=(ImageButton) findViewById(R.id.imageButton2);
		stop=(ImageButton) findViewById(R.id.imageButton3);
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				play();
				
			}
		});
		pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pause();
				
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
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

	@Override
	public void onCompletion(MediaPlayer mp) {
		stop();
		
	}

	@Override
	protected void onDestroy() {
		if(stop.isEnabled()){
			stop();
		}
		super.onDestroy();
	}
	
	
	public void play(){
		mp.start();
		start.setEnabled(false);
		pause.setEnabled(true);
		stop.setEnabled(true);
	}
	
	public void stop(){
		mp.stop();
		pause.setEnabled(false);
		stop.setEnabled(false);
		try{
			mp.prepare();
			mp.seekTo(0);
			start.setEnabled(true);
		}catch(Throwable t){
			error(t);
		}
	}
	
	public void pause(){
		mp.pause();
		start.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(true);
	}

	public void loadClip(){
		
		try{
			mp=MediaPlayer.create(this, R.raw.test);
			mp.setOnCompletionListener(this);
		}catch(Throwable t){
			error(t);
		}
		
	}
	public void setup(){
		loadClip();
		start.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(false);
	}
	
	
	public void error(Throwable t){
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("报错了")
		.setMessage(t.toString())
		.setPositiveButton("确定", null)
		.show();
		
	}
}
