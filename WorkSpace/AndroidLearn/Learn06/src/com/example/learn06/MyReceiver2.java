package com.example.learn06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "系统启动完成.....", Toast.LENGTH_LONG).show();
		
	}

}
