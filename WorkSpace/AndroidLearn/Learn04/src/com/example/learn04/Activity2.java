package com.example.learn04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity{
	TextView textView;
	String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		textView=(TextView) findViewById(R.id.textView1);
		Intent i=getIntent();
		str=i.getStringExtra("data");
		textView.setText(str);
		
	}
	
}
