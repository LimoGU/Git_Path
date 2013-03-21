package com.example.learn01;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView hello;
	private ImageView show;
	private MenuInflater mf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources r=getResources();
        mf=new MenuInflater(this);
        hello=(TextView) findViewById(R.id.textView1);
        show=(ImageView) findViewById(R.id.imageView1);
        Drawable d=r.getDrawable(R.drawable.show);
        d.setBounds(new Rect(0, 0, 90, 90));
        show.setImageDrawable(d);
        
        StringBuilder sb=new StringBuilder("");
        
        XmlPullParser xrp=r.getXml(R.xml.data);
        try {
			while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT){
				if(xrp.getEventType()==XmlResourceParser.START_TAG){
					String name=xrp.getName();
					if("people".equals(name)){
						sb.append("People:\n");
						sb.append(xrp.getAttributeValue(0)+"\n");
						sb.append(xrp.getAttributeValue(1)+"\n");
						sb.append(xrp.getAttributeValue(2)+"\n");
						sb.append(xrp.getAttributeValue(3)+"\n");
					}
				}else if(xrp.getEventType()==XmlResourceParser.END_TAG){}
				else if(xrp.getEventType()==XmlResourceParser.TEXT){}
				
				xrp.next();
			}
			
			hello.setText(sb.toString());
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        mf.inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.new_file:{
			longToast("newFile");
		}break;
		case R.id.open_file:{
			longToast("openFile");
		}break;
		case R.id.save_file:{
			longToast("saveFile");
		}break;
		case R.id.cut:{
			longToast("cutFile");
		}break;
		case R.id.copy:{
			longToast("copyFile");
		}break;
		case R.id.past:{
			longToast("pastFile");
		}break;
		case R.id.about:{
			longToast("aboutFile");
		}break;
		case R.id.exit:{
			longToast("exitFile");
		}break;
		}
		
		
		return true;
	}

	
	public void longToast(String str){
		Toast.makeText(this, str, Toast.LENGTH_LONG).show();
	}

    
}
