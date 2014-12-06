package com.message;

public class LinkMessage extends Message{

	int listNum;
	
	public LinkMessage(int listNum){
		this.type = Config.TYPE_LINK;
		this.listNum = listNum;
	}
	
}
