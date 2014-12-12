package com.example.wordsrecite;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.message.Config;
import com.model.WordList;


public class ThirdActivity extends Activity {

	private WordList wl;
	private TextView words;
	private TextView explaination;
	private int index = 0;
	private Button fight;
	private ProgressDialog  progressDialog;
	

	static DataOutputStream output;
	static DataInputStream input;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		// 得到各种组件
		words = (TextView) this.findViewById(R.id.words);
		explaination = (TextView) this.findViewById(R.id.explaination);
		fight = (Button) this.findViewById(R.id.thirdactivity_fightstart);
		fight.setOnClickListener(new FightBeginListener());
		wl = new FightActivity().getWordlist(1);

		// 设置初始内容
		this.changeWord(index);

		
	}

	// 通过单词改变界面的方法
	private void changeWord(int index) {
		words.setText(wl.words[index].english);
		explaination.setText(wl.words[index].chinese);
		
		if(index==9){
			fight.setVisibility(View.VISIBLE);
		}else{
			fight.setVisibility(View.GONE);
		}
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

	private class FightBeginListener implements OnClickListener{

		public void onClick(View arg0) {
			progressDialog = ProgressDialog.show(ThirdActivity.this, "正在匹配", "请您稍等 ..." ,true, false);
			new Thread(new Runnable() {

				public void run() {

					try {

						Socket s;
						s = new Socket("115.29.107.232", 7777);

						output = new DataOutputStream(s.getOutputStream());
						input = new DataInputStream(s.getInputStream());
						
						
						if (input.readInt() == Config.TYPE_START) {
							int level = input.readInt();
							progressDialog.dismiss();
							Intent intent = new Intent(ThirdActivity.this,
									FightActivity.class);
							startActivity(intent);
							ThirdActivity.this.finish();
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
	
}
