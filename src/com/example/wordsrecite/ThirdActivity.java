package com.example.wordsrecite;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.model.WordList;

public class ThirdActivity extends Activity {

	private WordList wl;
	private TextView words;
	private TextView explaination;
	private int index = 0;
	public Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		// 得到各种组件
		words = (TextView) this.findViewById(R.id.words);
		explaination = (TextView) this.findViewById(R.id.explaination);

		wl = new FightActivity().getWordlist(1);

		handler = new Handler(callback);

		words.setText("aaaaa");
		explaination.setText("啊啊啊啊啊啊");
		// 设置初始内容
		//this.changeWord(index);

		
	}

	// 通过单词改变界面的方法
	private void changeWord(int index) {
		Message msg = new Message();
		msg.arg1 = 1;
		msg.arg2 = index;
		handler.sendMessage(msg);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

	public void select(View view) {

		switch (view.getId()) {
		case R.id.leftPg:
			if (index > 0) {
				index--;
			}
			break;
		case R.id.rightPg:
			if (index < 9) {
				index++;
			}
			break;
		}

		this.changeWord(index);
	}

	Handler.Callback callback = new Handler.Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			if (msg.arg1 == 1) {
				words.setText(wl.words[msg.arg2].english);
				explaination.setText(wl.words[msg.arg2].chinese);
			}
			return true;
		}

	};

}
