package com.example.learn05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		Log.d("test", "绑定Server...........");
		return null;
	}
	//
	@Override
	public void onCreate() {
		Log.d("test", "创建Server...........");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d("test", "删除Server...........");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("test", "调用Server...........");
		return super.onStartCommand(intent, flags, startId);
	}

	
	
}
