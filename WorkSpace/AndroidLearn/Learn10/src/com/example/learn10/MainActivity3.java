package com.example.learn10;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends Activity {
	ImageView imageView;
	Button  b1,b2;
	AnimationDrawable animationDrawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main02);
		imageView=(ImageView) findViewById(R.id.imageView11);
		b1=(Button) findViewById(R.id.buttona);
		b2=(Button) findViewById(R.id.buttonb);
		animationDrawable=(AnimationDrawable) imageView.getDrawable();
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				animationDrawable.start();
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				animationDrawable.stop();
				
			}
		});
		
	}
	
}
