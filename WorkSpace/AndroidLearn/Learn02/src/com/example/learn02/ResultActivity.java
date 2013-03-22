package com.example.learn02;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ResultActivity extends Activity {
	ListView listView;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		listView=(ListView) findViewById(R.id.listView1);
		button=(Button) findViewById(R.id.button123);
		Intent i=getIntent();
		Bundle data=i.getBundleExtra("data");
		List l=new ArrayList();
		l.add(data.getString("userName"));
		l.add(data.getString("passWord"));
		l.add(data.getString("postition"));
		l.add(data.getString("gender"));
		l.add(data.getString("hobby"));
		l.add(data.getString("marriged"));
		
		
		
		ArrayAdapter aa=new ArrayAdapter(this, android.R.layout.simple_list_item_checked,l);
		listView.setAdapter(aa);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(ResultActivity.this, AutoActivity.class);
				startActivity(i);
			}
		});
		
	}
	
}
