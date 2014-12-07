package com.model;



/**
 * 单词列表类:每组count个
 * @author pc
 *
 */
public class WordList {
	private int count = 10;//单词个数
	public Word[] words = new Word[10];//单词的数组
	
	public WordList(Word[] words){
		this.words = words;
	}
}
