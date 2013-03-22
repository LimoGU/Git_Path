package com.example.learn03;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("test", "onCreate............");
	}

	
	
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Log.v("test", "onBackPressed............");
		
	}





	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("test", "onDestroy............");
	}





	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("test", "onPause............");
	}





	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.v("test", "onRestart............");
	}





	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("test", "onResume............");
	}





	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("test", "onStart............");
	}





	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("test", "onStop............");
	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
