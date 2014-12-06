package com.example.wordsrecite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends Activity {

	Button StudyBeginbtn;
	ImageButton back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	
		StudyBeginbtn = (Button) findViewById(R.id.StudyBegin);
		// 给StudyBeginbtn按钮对象绑定监听器
		StudyBeginbtn.setOnClickListener(new WordsReciteListener());
	}
	
	// 第二个布局StudyBeginbtn按钮的监听器
	private class WordsReciteListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// 加载第二个布局文件
			setContentView(R.layout.activity_third);
			
			back = (ImageButton) findViewById(R.id.back);
			back.setOnClickListener(new BackListener());
		}

	}
	
	// 第二个布局back按钮的监听器
	private class BackListener implements OnClickListener {
		public void onClick(View v) {
			// 返回第二个布局文件
			setContentView(R.layout.activity_second);
			
			// 可循环跳转
			StudyBeginbtn = (Button) findViewById(R.id.StudyBegin);
			// 给StudyBeginbtn按钮对象绑定监听器
			StudyBeginbtn.setOnClickListener(new WordsReciteListener());			
		}
	}

}