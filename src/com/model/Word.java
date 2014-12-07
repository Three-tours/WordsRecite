package com.model;
/**
 * 单词类
 * @author 唐梓毅
 *
 */
public class Word {
	
	public String english="";//英文
	public String chinese="";//中文
	public String sentence="";//例句
	public String soundmark="";//音标
	
	
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
