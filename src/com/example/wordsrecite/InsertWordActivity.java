package com.example.wordsrecite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class InsertWordActivity extends Activity 
{
	MyDatabaseHelper dbHelper;
	
	Button insert = null;
	Button search = null;
	TextView test;
	ImageButton back;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		back = (ImageButton) findViewById(R.id.main_back);
		back.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(InsertWordActivity.this,SecondActivity.class);
				startActivity(intent);
				InsertWordActivity.this.finish();
			}
		});
		
		// 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可，
		// 数据库文件自动会保存在程序的数据文件夹的databases目录下。
		dbHelper = SecondActivity.dbHelper;
		insert = (Button)findViewById(R.id.insert);
		search = (Button)findViewById(R.id.search);	
		insert.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				
				System.out.println("插入");				
				//获取用户输入
				String word = ((EditText)findViewById(R.id.word))
					.getText().toString();
				String detail = ((EditText)findViewById(R.id.detail))
					.getText().toString();
				//插入生词记录
				insertData(dbHelper.getReadableDatabase() , word , detail);
				//显示提示信息
//				Toast.makeText(Dict.this, "添加生词成功！" , 8000)
//					.show();
				Toast toast = Toast.makeText(InsertWordActivity.this, "添加生词成功！" , 8000);
				ImageView imageView = new ImageView(InsertWordActivity.this);
				imageView.setImageResource(R.drawable.v);
				LinearLayout toastView = (LinearLayout)toast.getView();
				toastView.setOrientation(LinearLayout.HORIZONTAL);
				toast.show();
			}			
		});	

		search.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 获取用户输入
				String key = ((EditText) findViewById(R.id.key)).getText()
					.toString();
				
//				String key ="";
				// 执行查询
				Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
					"select * from dict where word like ? or detail like ?", 
					new String[]{"%" + key + "%" , "%" + key + "%"});
				
				//创建一个Bundle对象
				Bundle data = new Bundle();
				data.putSerializable("data", converCursorToList(cursor));
				//创建一个Intent
				Intent intent = new Intent(InsertWordActivity.this
					, ResultActivity.class);
				intent.putExtras(data);
				
//				System.out.println(converCursorToList(cursor).toString());
				
				//启动Activity
				startActivity(intent);
			}
		});
	}
	

	protected ArrayList<Map<String , String>>
		converCursorToList(Cursor cursor)
	{
		ArrayList<Map<String , String>> result = 
			new ArrayList<Map<String , String>>();
		//遍历Cursor结果集
		while(cursor.moveToNext())
		{
			//将结果集中的数据存入ArrayList中
			Map<String , String> map = new 
				HashMap<String , String>();
			//取出查询记录中第2列、第3列的值
			map.put("word" , cursor.getString(1));
			map.put("detail" , cursor.getString(2));
			result.add(map);
		}
		return result;		                 
	}
	
	
	public static void insertData(SQLiteDatabase db
		, String word , String detail)
	{
		//执行插入语句
		db.execSQL("insert into dict values(null , ? , ?)"
			, new String[]{word , detail});
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		//退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
		if (dbHelper != null)
		{
			dbHelper.close();
		}
	}	
}