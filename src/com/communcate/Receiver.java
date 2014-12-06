package com.communcate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收服务器发来的消息的方法
 * @author 唐梓毅
 *
 */
public class Receiver extends Thread{
	//流
	private Socket s;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	//构造方法
	public Receiver(Socket s) throws IOException{
		this.s = s;
		this.dis = new DataInputStream(s.getInputStream());
		this.dos = new DataOutputStream(s.getOutputStream());
		
		
	}
	
	//解析服务器发过来的消息的方法
	public void process(){
		
	}
	//启动线程的方法
	public void run(){
		while(true){
			
			try {
				int type = dis.readInt();
				int msg = dis.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
