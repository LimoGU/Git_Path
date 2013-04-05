package com.example.learn11_2;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ImageView imageView;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView=(ImageView) findViewById(R.id.imageView1);
		button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String urlStr="http://192.168.1.100:8080/test.jpg";
				try{
					URL url=new URL(urlStr);
					URLConnection urlConnection=url.openConnection();
					InputStream io=urlConnection.getInputStream();
					Bitmap bm=BitmapFactory.decodeStream(io);
					imageView.setImageBitmap(bm);
				}catch(Exception ex){
					ex.printStackTrace();
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
