package com.example.learn04;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button button10;
	Button button11;
	Button button12;
	String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		str="这是要传入第二个Activity的值";
		setContentView(R.layout.activity_main);
		button1=(Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				//切换Activity，传递数据
				Intent i=new Intent(MainActivity.this,Activity2.class);
				i.putExtra("data", str);
				
				startActivity(i);
				
			}
		});
		button2=(Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序显示网页
				Uri uri=Uri.parse("http://www.baidu.com");
				Intent i=new Intent(Intent.ACTION_VIEW,uri);
				startActivity(i);
				
			}
		});
		button3=(Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序显示地图
				Uri uri=Uri.parse("geo:38.899533,-77.036476");
				Intent i=new Intent(Intent.ACTION_VIEW,uri);
				startActivity(i);
				
			}
		});
		button4=(Button) findViewById(R.id.button4);
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序打电话
				Uri uri=Uri.parse("tel:123456");
				Intent i=new Intent(Intent.ACTION_DIAL,uri);
				startActivity(i);
				
			}
		});
		button5=(Button) findViewById(R.id.button5);
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序发短信
				Uri uri=Uri.parse("smsto:123456");
				Intent i=new Intent(Intent.ACTION_SENDTO,uri);
				i.putExtra("sms_body", "******这是发送短信的内容");
				startActivity(i);
				
			}
		});
		button6=(Button) findViewById(R.id.button6);
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序发彩信
				Uri uri=Uri.parse("content://media/external/images/media/23");
				Intent i=new Intent(Intent.ACTION_SENDTO);
				i.putExtra("sms_body", "Some Text");
				i.putExtra(Intent.EXTRA_STREAM, uri);
				i.setType("image/png");
				startActivity(i);
				
			}
		});
		button7=(Button) findViewById(R.id.button7);
		button7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序发邮件
				Uri uri=Uri.parse("mailto:380451491@qq.com");
				Intent i=new Intent(Intent.ACTION_SENDTO,uri);
				startActivity(i);
				
			}
		});
		button8=(Button) findViewById(R.id.button8);
		button8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序发邮件
				Uri uri=Uri.parse("mailto:380451491@qq.com");
				Intent i=new Intent(Intent.ACTION_SENDTO,uri);
				startActivity(i);
				
			}
		});
		button9=(Button) findViewById(R.id.button9);
		button9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序多媒体播放
				Uri uri=Uri.parse("file:///sdcard/music/song.mp3");
				Intent i=new Intent(Intent.ACTION_VIEW);
				i.setDataAndType(uri, "audio/mp3");
				startActivity(i);
				/*
				Uri uri2=Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
				Intent it=new Intent(Intent.ACTION_VIEW,uri2);
				startActivity(it);
				*/
			}
		});
		button10=(Button) findViewById(R.id.button10);
		button10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//调用外部程序发邮件
				Uri uri=Uri.fromParts("package", "com.example.learn04", null);
				Intent i=new Intent(Intent.ACTION_DELETE,uri);
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

}
