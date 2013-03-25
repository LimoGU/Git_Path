package com.example.learn05;

import android.os.RemoteException;

public class IPersonImpl extends IPerson.Stub {
	private int age;
	private String name;
	@Override
	public void setAge(int age) throws RemoteException {
		this.age=age;
		
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name=name;
		
	}

	@Override
	public String display() throws RemoteException {
		
		return "Name:"+name+"\nAge:"+age;
	}


}
