package com.model;
/**
 * 单词类
 * @author 唐梓毅
 *
 */
public class Word {
	
	private String english="";//英文
	private String chinese="";//中文
	private String sentence="";//例句
	private String soundmark="";//音标
	
	
	//构造函数
	public Word(String english, String chinese, String sentence,
			String soundmark) {
		super();
		this.english = english;
		this.chinese = chinese;
		this.sentence = sentence;
		this.soundmark = soundmark;
	}
	
	
		
	
}
