package com.example.learn11_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView=(TextView) findViewById(R.id.textView1);
		button=(Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Socket socket=new Socket("192.168.1.100", 8888);
					InputStream in=socket.getInputStream();
					byte[] buffer=new byte[14];
					in.read(buffer);
					String msg=new String(buffer);
					msg+=msg.length();
					textView.setText(msg);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
