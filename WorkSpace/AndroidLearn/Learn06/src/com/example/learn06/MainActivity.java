package com.example.learn06;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button sendButton;
	Button sendButton2;
	Button cancelButton;
	Button setButton;
	Button cancelButton2;
	final String actionStr="com.example.learn06.action.My_Action";
	final String BC_ACTION="com.example.learn06.action.BC_ACTION";
	String service=NOTIFICATION_SERVICE;
	int ID=0;
	AlarmManager am;
	PendingIntent pi2;
	long time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		am=(AlarmManager) getSystemService(ALARM_SERVICE);
		Intent intent2=new Intent();
		intent2.setAction(BC_ACTION);
		intent2.putExtra("msg", "时间到了..........");
		pi2=PendingIntent.getBroadcast(MainActivity.this, 0, intent2, 0);
		
		
		final NotificationManager nm=(NotificationManager) getSystemService(service);
		final Notification n=new Notification();
		int icon=n.icon=R.drawable.ic_launcher;
		String str="Test 通知";
		long when =System.currentTimeMillis();
		n.icon=icon;
		n.tickerText=str;
		n.when=when;
		
		sendButton=(Button) findViewById(R.id.button1);
		sendButton2=(Button) findViewById(R.id.button2);
		cancelButton=(Button) findViewById(R.id.button3);
		setButton=(Button) findViewById(R.id.button4);
		cancelButton2=(Button) findViewById(R.id.button5);
		sendButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setAction(actionStr);
				intent.putExtra("msg", "这是广播的内容.......");
				sendBroadcast(intent);
				
			}
		});
		sendButton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				PendingIntent pi=PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
				n.setLatestEventInfo(MainActivity.this, "标题", "内容", pi);	
				ID++;
				nm.notify(ID, n);
				sendBroadcast(intent);
				
			}
		});
		cancelButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(ID>=1){
					for(int i=ID;i>0;i--){
						nm.cancel(i);
					}
				}
			}
		});
		setButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.v("test", am.toString());
				Log.v("test", time+"");
				Log.v("test", pi2.toString());
				time=System.currentTimeMillis();
				am.setRepeating(AlarmManager.RTC_WAKEUP, time, 15*1000, pi2);
			}
		});
		cancelButton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				am.cancel(pi2);
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
