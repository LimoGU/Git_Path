package com.example.learn05;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button startButton,stopButton,binButton,unbindButton;
	final String actionStr="com.example.learn05.action.MY_SERVICE";
	final String actionStr2="com.example.learn05.action.MY_REMOTE_SERVICE";
	Button testButton;
	IPerson iPerson;
	ServiceConnection rsconn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
	  synchronized	public void onServiceConnected(ComponentName name, IBinder service) {
			iPerson=IPerson.Stub.asInterface(service);
			if(iPerson!=null){
				try{
				iPerson.setName("顾玉龙");
				iPerson.setAge(24);
				String msg=iPerson.display();
				Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton=(Button) findViewById(R.id.button1);
		stopButton=(Button) findViewById(R.id.button2);
		binButton=(Button) findViewById(R.id.button3);
		unbindButton=(Button) findViewById(R.id.button4);
		testButton=(Button) findViewById(R.id.button5);
		
		startButton.setOnClickListener(new MyButtonListener());
		stopButton.setOnClickListener(new MyButtonListener());
		binButton.setOnClickListener(new MyButtonListener());
		unbindButton.setOnClickListener(new MyButtonListener());
		testButton.setOnClickListener(new MyButtonListener());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	ServiceConnection conn=	new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.v("test", "断开成功..........");
			Toast.makeText(MainActivity.this,  "断开成功..........", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.v("test", "连接成功..........");
			Toast.makeText(MainActivity.this,  "连接成功..........", Toast.LENGTH_SHORT).show();
		}
	};
	
	
	class MyButtonListener implements OnClickListener{

		
		@Override
		public void onClick(View v) {
			if(v==startButton){
				Intent i=new Intent();
				i.setAction(actionStr);
				startService(i);
				
			}else if(v==stopButton){
				Intent i=new Intent();
				i.setAction(actionStr);
				stopService(i);
				
				
			}else if(v==binButton){
				Intent i=new Intent();
				i.setAction(actionStr);
				
				bindService(i,conn , Service.BIND_AUTO_CREATE);
				
				
			}else if(v==unbindButton){
				Intent i=new Intent();
				i.setAction(actionStr);
				unbindService(conn);
				
			}else if(v==testButton){
				Intent i=new Intent();
				i.setAction(actionStr2);
				bindService(i,rsconn , Service.BIND_AUTO_CREATE);
		}
			
		}
	}
	
	
}
