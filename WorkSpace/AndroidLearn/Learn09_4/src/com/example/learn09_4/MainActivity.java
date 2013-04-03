package com.example.learn09_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends Activity {
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	Camera camera;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		surfaceView=(SurfaceView) findViewById(R.id.surfaceView1);
		surfaceHolder=surfaceView.getHolder();
		
		SurfaceHolder.Callback surCallback=new SurfaceHolder.Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				camera.stopPreview();
				camera.release();
				camera=null;
				
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				camera=Camera.open();
				
				try {
					camera.setPreviewDisplay(holder);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				Camera.Parameters parameters=camera.getParameters();
				parameters.setPreviewSize(width, height);
				parameters.setPictureFormat(PixelFormat.JPEG);
				camera.setParameters(parameters);
				camera.startPreview();
				
			}
		};
		
		surfaceHolder.addCallback(surCallback);
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
	class SavePictureTask extends AsyncTask<byte[], String, String>{

		@Override
		protected String doInBackground(byte[]... params) {
			File picture=new File(Environment.getExternalStorageDirectory(), "picture.jpg");
			if(picture.exists()){
				picture.delete();
			}
			
			
			try {
				FileOutputStream fos=new FileOutputStream(picture.getPath());
				fos.write(params[0]);
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
	}
	
	Camera.PictureCallback pictureCallback=new PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			new SavePictureTask().execute(data);
			camera.startPreview();
			
		}
	};
	
	private void takePic(){
		camera.stopPreview();
		camera.takePicture(null, null, pictureCallback);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_CAMERA||keyCode==KeyEvent.KEYCODE_SEARCH){
			takePic();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	
}
