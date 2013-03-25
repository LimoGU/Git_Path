package com.example.learn05;

import com.example.learn05.IPerson.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyRemoteService extends Service {
	Stub iperson=new IPersonImpl();
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return iperson;
	}

}
