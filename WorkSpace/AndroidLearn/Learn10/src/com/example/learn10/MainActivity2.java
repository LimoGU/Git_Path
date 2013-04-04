package com.example.learn10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends Activity {
	Button b1,b2,b3,b4;
	Button b5,b6,b7,b8,b9;
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main01);
		imageView=(ImageView) findViewById(R.id.imageView2);
		b1=(Button) findViewById(R.id.button11);
		b2=(Button) findViewById(R.id.button22);
		b3=(Button) findViewById(R.id.button33);
		b4=(Button) findViewById(R.id.button44);
		b5=(Button) findViewById(R.id.button55);
		b6=(Button) findViewById(R.id.button66);
		b7=(Button) findViewById(R.id.button77);
		b8=(Button) findViewById(R.id.button88);
		b9=(Button) findViewById(R.id.button99);
		
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation scaleAnimation=new ScaleAnimation(0f, 1f, 0f, 1f,
						Animation.RELATIVE_TO_SELF,.5f,
						Animation.RELATIVE_TO_SELF,.5f						
						);
				scaleAnimation.setDuration(3000);
				imageView.startAnimation(scaleAnimation);
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation alphaAnimation=new AlphaAnimation(0.1f, 1.0f);
				alphaAnimation.setDuration(3000);
				imageView.startAnimation(alphaAnimation);
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation translateAnimation=new TranslateAnimation(10, 100, 10, 100);
				translateAnimation.setDuration(3000);
				imageView.startAnimation(translateAnimation);
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation rotateAnimation=new RotateAnimation(0f, +360f,
						Animation.RELATIVE_TO_SELF,0.5f,
						Animation.RELATIVE_TO_SELF,0.5f						
				);
				rotateAnimation.setDuration(3000);
				imageView.startAnimation(rotateAnimation);
			}
			
		});
		b5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation scaleAnimation=AnimationUtils.loadAnimation(MainActivity2.this, R.anim.my_alpha);
				imageView.startAnimation(scaleAnimation);
			}
		});
		b6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation alphaAnimation=AnimationUtils.loadAnimation(MainActivity2.this, R.anim.my_rotate);
				imageView.startAnimation(alphaAnimation);
			}
		});
		b7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation translateAnimation=AnimationUtils.loadAnimation(MainActivity2.this, R.anim.my_scale);
				imageView.startAnimation(translateAnimation);
			}
		});
		b8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation rotateAnimation=AnimationUtils.loadAnimation(MainActivity2.this, R.anim.my_translate);
				imageView.startAnimation(rotateAnimation);
			}
			
		});
		b9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i=new Intent(MainActivity2.this, MainActivity3.class);
				startActivity(i);
			}
			
		});
		
	}
	
}
