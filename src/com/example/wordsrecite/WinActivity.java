package com.example.wordsrecite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WinActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		
		
		new Handler().postDelayed(new Runnable() {
			
			public void run() {
				Intent intent = new Intent(WinActivity.this,SecondActivity.class);
				startActivity(intent);
				WinActivity.this.finish();
			}
		}, 2000);
	}


}
