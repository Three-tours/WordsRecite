package com.message;

public class StartMessage extends Message{
	public int numbers;
	public StartMessage(int numbers){
		this.type = Config.TYPE_START;
		this.numbers = numbers;
	}
}
