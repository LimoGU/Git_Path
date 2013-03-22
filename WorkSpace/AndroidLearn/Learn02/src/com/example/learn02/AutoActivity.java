package com.example.learn02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class AutoActivity extends Activity {
	AutoCompleteTextView autoCompleteTextView;
	Button changeButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto);
		autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		String strs[]={
				"abc",
				"apple",
				"bed",
				"cc",
				"cat"
		};
		ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_list_item_1,strs);
		autoCompleteTextView.setAdapter(aa);
		changeButton=(Button) findViewById(R.id.autoButton);
		changeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(AutoActivity.this, TabActivity.class);
				startActivity(i);
				
			}
		});
	}
	
}
