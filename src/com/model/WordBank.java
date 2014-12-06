package com.model;

import java.util.ArrayList;

public class WordBank {
	private int totalcount = 30;//单词总数
	private int listcount = 3;//单词列表总数
	private WordList[] lists = new WordList[listcount];//
	
	//简单实现手动赋初值
	public WordBank(WordList wl){
		
		for(int i = 0; i < listcount ;i++){
			lists[i] = wl;
		}
		
	}
	//
	
}
