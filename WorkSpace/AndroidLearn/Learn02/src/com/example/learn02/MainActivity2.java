package com.example.learn02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;
/**
 * 测试各种组件的Activity
 * @author 顾玉龙
 *
 */
public class MainActivity2 extends Activity {
	Button register,cancel;
	ToggleButton marriged;
	RadioButton male,female;
	EditText useName,passWord;
	Spinner position;
	CheckBox reading,swiming;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linear);
		useName=(EditText) findViewById(R.id.editText1);
		passWord=(EditText) findViewById(R.id.editText2);
		male=(RadioButton) findViewById(R.id.radioButton1);
		female=(RadioButton) findViewById(R.id.radioButton2);

		reading=(CheckBox) findViewById(R.id.checkBox1);
		swiming=(CheckBox) findViewById(R.id.checkBox2);
		marriged=(ToggleButton) findViewById(R.id.toggleButton1);
		position=(Spinner) findViewById(R.id.spinner1);
		String[] strs={"CEO","CFO","PM"};
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strs);
		position.setAdapter(aa);
		register=(Button) findViewById(R.id.button11);
		cancel=(Button) findViewById(R.id.button22);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle b=new Bundle();
				b.putString("userName", useName.getText().toString());
				b.putString("passWord", passWord.getText().toString());
				if(male.isChecked()){
					b.putString("gender", "性别：男");
				}else{
					b.putString("gender", "性别：女");
				}
				String temp="爱好:";
				
				if(reading.isChecked()){
					temp+="阅读\t";
				}
				else if(swiming.isChecked()){
					temp+="游泳";
				}
				
				b.putString("hobby", temp);
				if(marriged.isChecked()){
					b.putString("marriged", "婚否：已婚");
				}else{
					b.putString("marriged", "婚否：未婚");
				}
				b.putString("postition", "职位:"+position.getSelectedItem().toString());
				
				Intent i=new Intent(MainActivity2.this, ResultActivity.class);
				i.putExtra("data", b);
				startActivity(i);
				
			}
		});
		
		
	}

	
	
}
