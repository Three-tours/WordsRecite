package com.message;

public class ScoreMessage extends Message{
	public int score;
	public ScoreMessage(int score){
		this.type = Config.TYPE_SCORE;
		this.score = score;
	}
}
