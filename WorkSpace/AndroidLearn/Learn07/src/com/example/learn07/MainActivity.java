package com.example.learn07;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText editText;
	TextView textView;
	Button button;
	Button button2;
	String msg="";
	private final String pathName="temp_pre";
	SharedPreferences sharedPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText=(EditText) findViewById(R.id.editText1);
		textView=(TextView) findViewById(R.id.textView1);
		button=(Button) findViewById(R.id.button1);
		button2=(Button) findViewById(R.id.button2);
	    sharedPreferences=getSharedPreferences(pathName, MODE_WORLD_WRITEABLE);
		msg=sharedPreferences.getString("msg", "");
		if(!msg.equals("")){
			textView.setText(msg);
		}
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				msg=editText.getText().toString();
				if(!"".equals(msg)){
					sharedPreferences.edit().putString("msg", msg).commit();
					textView.setText(msg);
				}
				
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, MainActivity2.class);
				startActivity(intent);
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
