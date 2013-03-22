package com.example.learn02;

import com.example.learn02.testevent.FireEvent;
import com.example.learn02.testevent.House;
import com.example.learn02.testevent.Listener;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 主要Activity类
 * @author 顾玉龙
 *
 */
public class MainActivity extends Activity {
	TextView textView;
	Button showFire;
	Button showDialog;
	Button changeButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView) findViewById(R.id.textView1);
		showFire=(Button) findViewById(R.id.button1);
		showDialog=(Button) findViewById(R.id.button2);
		changeButton=(Button) findViewById(R.id.button3);
		showFire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TestEvent();		//模拟着火
				
			}
		});
		
		showDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				showInfoDialog("这是一个对话框！");
			}
		});
	
		changeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this, MainActivity2.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * 测试房子着火的事件处理
	 */
	public void TestEvent(){
		//实例化屋子
		House h=new House();
		//添加监听器
		h.addListener(new Listener() {
			
			@Override
			public void listen(FireEvent e) {
				textView.setText("着火了\n");
				
			}
		});
		
		h.setFlag(true);
	}
	
	/**
	 * 显示信息的dialog
	 * @param str
	 */
	public void showInfoDialog(String str){
	  final	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	  builder.setMessage(str).setPositiveButton("确定", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
			
		}

	});
	  
	  AlertDialog ad=builder.create();
	  ad.show();
		
	}
	
}
