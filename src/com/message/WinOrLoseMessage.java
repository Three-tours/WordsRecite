package com.message;

public class WinOrLoseMessage extends Message{
	public int winorlose;
	public WinOrLoseMessage(int winorlose){
		this.type = Config.TYPE_WINORLOSE;
		this.winorlose = winorlose;
	}
}
