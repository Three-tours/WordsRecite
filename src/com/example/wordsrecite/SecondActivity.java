package com.example.wordsrecite;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.message.Config;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends Activity {

	Button StudyBeginbtn;
	ImageButton back;

	static DataOutputStream output;
	static DataInputStream input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		StudyBeginbtn = (Button) findViewById(R.id.StudyBegin);
		// 给StudyBeginbtn按钮对象绑定监听器
		StudyBeginbtn.setOnClickListener(new WordsReciteListener());
	}

	private class StudyBeginListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			new Thread(new Runnable() {

				public void run() {

					try {

						Socket s;
						s = new Socket("115.29.107.232", 7777);

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
	// 第二个布局StudyBeginbtn按钮的监听器
	private class WordsReciteListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// 加载第二个布局文件
			 setContentView(R.layout.activity_third);
			
//			 back = (ImageButton) findViewById(R.id.back);
//			 back.setOnClickListener(new BackListener());

			
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
