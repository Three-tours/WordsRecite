package com.example.wordsrecite;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.message.Config;
import com.model.Word;
import com.model.WordBank;
import com.model.WordList;

public class FightActivity extends Activity {

	private WordList wl;
	private Button btnA, btnB, btnC, btnD;
	private TextView countDown, scoreText, question;
	private int score = 0, time = 10, index = 0;
	private Timer timer = new Timer();
	private Random r = new Random();
	private int rightPos = 0, choosePos = -1, chooseTime = 0;
	private int[] order = new int[4];
	private boolean deathFlag = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fight);

		// TODO 接收数据
		this.wl = this.getWordlist(1);

		countDown = (TextView) findViewById(R.id.countDown);
		scoreText = (TextView) findViewById(R.id.score);
		question = (TextView) findViewById(R.id.question);

		btnA = (Button) findViewById(R.id.button_a);
		btnB = (Button) findViewById(R.id.button_b);
		btnC = (Button) findViewById(R.id.button_c);
		btnD = (Button) findViewById(R.id.button_d);

		changeQuestion(index, wl);
		changeTime(time);
		changeScore(score);
		timer.schedule(tm, 1000, 500);

		new Thread(new Runnable() {

			public void run() {
				try {
				while (!deathFlag) {
					Thread.sleep(300);
				}
				
					ThirdActivity.output.writeInt(Config.TYPE_SCORE);
					ThirdActivity.output.writeInt(score);

					if ( ThirdActivity.input.readInt()==Config.TYPE_WINORLOSE) {
						int type= ThirdActivity.input.readInt();
						
						if (type == Config.WIN) {
							Intent intent = new Intent(FightActivity.this,WinActivity.class);
							startActivity(intent);
						} else if(type == Config.LOSE){
							Intent intent = new Intent(FightActivity.this,LoseActivity.class);
							startActivity(intent);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}

	// 改变单词的方法
	public void changeQuestion(int num, WordList wl) {
		getfour(num);
		if (r.nextInt(2) == 1) {
			this.question.setText(wl.words[num].english);
			this.btnA.setText(wl.words[order[0]].chinese);
			this.btnB.setText(wl.words[order[1]].chinese);
			this.btnC.setText(wl.words[order[2]].chinese);
			this.btnD.setText(wl.words[order[3]].chinese);
		} else {
			this.question.setText(wl.words[num].chinese);
			this.btnA.setText(wl.words[order[0]].english);
			this.btnB.setText(wl.words[order[1]].english);
			this.btnC.setText(wl.words[order[2]].english);
			this.btnD.setText(wl.words[order[3]].english);

		}

	}

	// 生成4个随机数的方法
	public void getfour(int num) {
		// 先得到三个随机数
		boolean[] bool = new boolean[10];
		bool[num] = true;
		int t = 0;
		for (int i = 0; i < 3; i++) {
			do {
				t = r.nextInt(10);
			} while (bool[t]);
			bool[t] = true;
			order[i] = t;
		}
		rightPos = r.nextInt(4);
		order[3] = order[rightPos];
		order[rightPos] = num;
	}

	// 改变总分的方法
	public void changeScore(int score) {
		this.scoreText.setText("总分:" + score);
	}

	// 改变时间的方法
	public void changeTime(int time) {
		countDown.setText("剩余时间:" + time);
	}

	public WordList getWordlist(int i) {
		
		return WordBank.getWordsList(i);
	}

	TimerTask tm = new TimerTask() {

		@Override
		public void run() {
			runOnUiThread(new Runnable() {

				@Override
				public void run() {

					time--;
					changeTime(time);
					if (time == 0) {
						index++;
						if (index == 10) {
							changeTime(0);
							timer.cancel();
							deathFlag = true;
						} else {
							if (choosePos == rightPos) {
								score += chooseTime;
							}
							changeScore(score);
							changeQuestion(index, wl);
						}
						time = 10;

						clearBtn();
					}
				}
			});

		}
	};

	public void select(View view) {
		clearBtn();
		switch (view.getId()) {
		case R.id.button_a:
			choosePos = 0;
			chooseTime = time;
			btnA.setBackgroundResource(R.drawable.bg_fight_choice_touch);
			break;
		case R.id.button_b:
			choosePos = 1;
			chooseTime = time;
			btnB.setBackgroundResource(R.drawable.bg_fight_choice_touch);
			break;
		case R.id.button_c:
			choosePos = 2;
			chooseTime = time;
			btnC.setBackgroundResource(R.drawable.bg_fight_choice_touch);
			break;
		case R.id.button_d:
			choosePos = 3;
			chooseTime = time;
			btnD.setBackgroundResource(R.drawable.bg_fight_choice_touch);
			break;
		}
	}

	public void clearBtn() {
		btnA.setBackgroundResource(R.drawable.bg_fight_choice_default);
		btnB.setBackgroundResource(R.drawable.bg_fight_choice_default);
		btnC.setBackgroundResource(R.drawable.bg_fight_choice_default);
		btnD.setBackgroundResource(R.drawable.bg_fight_choice_default);
		choosePos = -1;
	}

}
