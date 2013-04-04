package com.example.learn10_01;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	MyView v ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v=new MyView(this, null);
		setContentView(v);
	}

	class MyView extends View implements Runnable{
		private int x=20,y=20;
		public MyView(Context context, AttributeSet attrs) {
			super(context, attrs);
			setFocusable(true);
			//new Thread(this).start();
		}
		@Override
		public void run() {
			RefreshHandler mRefreshHandler=new RefreshHandler();
			while(!Thread.currentThread().isInterrupted()){
				Message msg=new Message();
				msg.what=0x101;
				mRefreshHandler.sendMessage(msg);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
			
		}
		
		class RefreshHandler extends Handler{
			@Override
			public void handleMessage(Message msg) {
				if(msg.what==0x101){
					MyView.this.update();
					MyView.this.invalidate();
				}
				super.handleMessage(msg);
			}
			
			
		}
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			Paint paint=new Paint();
			paint.setColor(Color.GREEN);
			canvas.drawCircle(x, y, 10, paint);
			
			update();
			invalidate();
		}
		
		
		
		private void update(){
			int h=getHeight();
			y+=5;
			if(y>=h){
				y=20;
			}
			
			
		}
		
	}
	
}
