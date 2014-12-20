package com.example.wordsrecite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class LoseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lose);
		

		new Handler().postDelayed(new Runnable() {
			
			public void run() {
				Intent intent = new Intent(LoseActivity.this,SecondActivity.class);
				startActivity(intent);
				LoseActivity.this.finish();
			}
		}, 2000);
	}

}
