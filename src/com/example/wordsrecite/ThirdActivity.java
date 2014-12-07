package com.example.wordsrecite;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.model.WordList;

public class ThirdActivity extends Activity {

	private WordList wl;
	private TextView words;
	private TextView explaination;
	private int index = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		//得到各种组件
		words = (TextView)this.findViewById(R.id.words);
		explaination = (TextView)this.findViewById(R.id.explaination);
		
		wl = new FightActivity().getWordlist(1);
		//设置初始内容
		words.setText(wl.words[0].english);
		explaination.setText(wl.words[0].chinese);
		//
		
		
	}
	//通过单词改变界面的方法
	private void changeWord(int index){
		words.setText(wl.words[index].english);
		explaination.setText(wl.words[index].chinese);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}
	public void select(View view){
		
		switch(view.getId()){
		case R.id.leftPg:
			if(index > 0){
				index--;
			}
			break;
		case R.id.rightPg:
			if(index < 9){
				index++;
			}
			break;
		}
		
		this.changeWord(index);
	}

}
