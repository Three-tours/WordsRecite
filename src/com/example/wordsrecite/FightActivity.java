package com.example.wordsrecite;

import java.util.Timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class FightActivity extends Activity {

	TextView countDownStart;
	static Handler handler;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fight);
		
		handler = new Handler(callback);
		
		Thread t = new Thread(){
			public void run(){
				Message msg = new Message();
				msg.arg1 = 1;
				handler.sendMessage(msg);
			}
		};
		t.start();
	}

	Handler.Callback callback = new Handler.Callback(){

		@Override
		public boolean handleMessage(Message msg) {
			if(msg.arg1 == 1){
				//
			}
			return true;
		}
		
	};
	
	
	

}
