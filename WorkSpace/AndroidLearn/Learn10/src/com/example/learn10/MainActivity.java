package com.example.learn10;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView imageView;
	Button loadButton,nextButton;
	String path;
	Bitmap bm;
	BitmapDrawable bd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView=(ImageView) findViewById(R.id.imageView1);
		loadButton=(Button) findViewById(R.id.button1);
		nextButton=(Button) findViewById(R.id.button2);
		path="/sdcard/pic2.jpg";
	    bm=BitmapFactory.decodeFile(path);
		loadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				imageView.setImageBitmap(bm);
			}
		});
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this, MainActivity2.class);
				startActivity(i);
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
