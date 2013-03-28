package com.example.learn06;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String str=intent.getStringExtra("msg");
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
		
	}

}
