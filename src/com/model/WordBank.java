package com.model;



public class WordBank {
	
	Word w1 = new Word("abandon", "丢弃；放弃，抛弃 ", "", "");
	Word w2 = new Word("ability", "能力；能耐，本领 ", "", "");
	Word w3 = new Word("abnormal", "不正常的；变态的 ", "", "");
	Word w4 = new Word("aboard", "在船(车)上；上船", "", "");
	Word w5 = new Word("abroad", "(在)国外；到处", "", "");
	
	Word[] words ={w1,w2,w3,w4,w5,w1,w2,w3,w4,w5};
	WordList wl1 = new WordList(words);
	private int totalcount = 30;//单词总数
	private int listcount = 3;//单词列表总数
	public WordList[] lists = {wl1,wl1,wl1};//
	
}
