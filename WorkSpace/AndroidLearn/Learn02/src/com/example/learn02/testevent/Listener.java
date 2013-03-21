package com.example.learn02.testevent;

import java.util.EventListener;
/**
 * 着火监听器
 * @author 顾玉龙
 *
 */
public interface Listener extends EventListener {
	public void listen(FireEvent e);
}
