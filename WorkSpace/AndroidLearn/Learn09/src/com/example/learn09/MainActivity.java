package com.example.learn09;

import java.io.IOException;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button startButton;
	Button stopButton;
	Button startButton2;
	Button stopButton2;
	Button startButton3;
	Button stopButton3;
	MediaPlayer mediaPlayer;
	MediaPlayer mediaPlayer2;
	MediaPlayer mediaPlayer3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton=(Button) findViewById(R.id.button1);
		stopButton=(Button) findViewById(R.id.button2);
		startButton2=(Button) findViewById(R.id.button3);
		stopButton2=(Button) findViewById(R.id.button4);
		startButton3=(Button) findViewById(R.id.button5);
		stopButton3=(Button) findViewById(R.id.button6);
		mediaPlayer=MediaPlayer.create(this, R.raw.test);
		mediaPlayer2=new MediaPlayer();
		mediaPlayer3=new MediaPlayer();
		String urlPath="http://192.168.1.100:8080/test.mp3";
		Uri uri=Uri.parse(urlPath);
		mediaPlayer3=MediaPlayer.create(this, uri);
		
		
		
		String path="/sdcard/Learn09/test.mp3";
		try {
			mediaPlayer2.setDataSource(path);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			mediaPlayer2.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mediaPlayer.start();
			}
		});
		stopButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mediaPlayer.stop();
			}
		});
		startButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mediaPlayer2.start();
			}
		});
		stopButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mediaPlayer2.stop();
			}
		});
		startButton3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mediaPlayer3.start();
			}
		});
		stopButton3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mediaPlayer3.stop();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
