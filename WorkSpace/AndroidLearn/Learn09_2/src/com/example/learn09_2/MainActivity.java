package com.example.learn09_2;

import java.io.File;

import android.os.Bundle;
import android.provider.MediaStore.Video;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
	VideoView videoView;
	MediaController ctlr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(R.layout.activity_main);
		File f=new File("sdcard/Learn09/vtest.mp4");
		if(f.exists()){
			videoView=(VideoView) findViewById(R.id.videoView1);
			videoView.setVideoPath(f.getAbsolutePath());
			ctlr=new MediaController(this);
			ctlr.setMediaPlayer(videoView);
			videoView.setMediaController(ctlr);
			videoView.requestFocus();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
