package com.example.learn02.testevent;

import java.util.ArrayList;
import java.util.List;

/**
 * 房子类
 * @author 顾玉龙
 *
 */
public class House {
	//定义标示
	private boolean flag =false;
	//监听器列表
	private List listeners=new ArrayList();
	
	/**
	 * 获得标示
	 * @return
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * 设置标示
	 * @param flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
		if(flag){
			ntf();
		}
		
	}
	/**
	 * 添加监听器
	 * @param l
	 */
	public void addListener(Listener l){
		listeners.add(l);
	}
	/**
	 * 获得监听器
	 * @return
	 */
	public List getListeners() {
		return listeners;
	}
	
	/**
	 * 通知方法
	 */
	public void ntf(){
		for(int i=0;i<listeners.size();i++){
			//获得监听器
			Listener l=(Listener) listeners.get(i);
			//监听
			l.listen(new FireEvent(this));
		}
		
		
	}
	
	
	
}
