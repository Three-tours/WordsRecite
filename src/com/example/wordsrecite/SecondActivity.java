package com.example.wordsrecite;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.message.Config;

public class SecondActivity extends Activity {

	Button StudyBeginbtn;
	ImageButton Addbtn;
	ImageButton Searchbtn;
	Button back2;

	static DataOutputStream output;
	static DataInputStream input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		StudyBeginbtn = (Button) findViewById(R.id.StudyBegin);
		Addbtn = (ImageButton) findViewById(R.id.camera);
		Searchbtn = (ImageButton) findViewById(R.id.microphone);
		// 给StudyBeginbtn按钮对象绑定监听器
		StudyBeginbtn.setOnClickListener(new WordsReciteListener());
//		Addbtn.setOnClickListener(new AddListener());
		Searchbtn.setOnClickListener(new SearchListener());
	}
	
	// 第二个布局search按钮的监听器 ，跳转至search界面
	private class SearchListener implements OnClickListener {
		@Override
		public void onClick(View source) {
			// 跳转至查询界面
			
			Intent intent=new Intent(SecondActivity.this,Main.class);
//			setContentView(R.layout.main);
			startActivity(intent);
		}
	}
	
	// 第二个布局StudyBeginbtn按钮的监听器
	private class WordsReciteListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			setContentView(R.layout.activity_third);
			new Thread(new Runnable() {

				public void run() {
					try {
						
						Socket s;
						s = new Socket("192.168.137.138", 7777);

						output = new DataOutputStream(s.getOutputStream());
						input = new DataInputStream(s.getInputStream());


						if (input.readInt() == Config.TYPE_START) {
							int level = input.readInt();
							Intent intent = new Intent(SecondActivity.this,
									FightActivity.class);
							startActivity(intent);
							SecondActivity.this.finish();
						}
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();

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