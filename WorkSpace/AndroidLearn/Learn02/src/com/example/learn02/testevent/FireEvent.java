package com.example.learn02.testevent;

import java.util.EventObject;
/**
 * 着火事件类
 * @author 顾玉龙
 *
 */
public class FireEvent extends EventObject {
	private Object fireObject;
	public FireEvent(Object source) {
		super(source);
		this.fireObject=source;
	}
	public Object getFireObject() {
		return fireObject;
	}
	
}
