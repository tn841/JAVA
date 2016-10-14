package com.itwill.server;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.itwill.member.Member;

public class SaveServer extends Thread{

	public static void main(String[] args) {
		new SaveServer().start();
	}
	
	
	@Override
	public void run() {
		try{
			ServerSocket serverSocket = new ServerSocket(9001);
			while(true){
				System.out.println("Receive Server accept...");
				Socket socket = serverSocket.accept();
				
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				ArrayList<Member> receiveData = (ArrayList<Member>)in.readObject();
				
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("member.dat"));
				out.writeObject(receiveData);
				out.flush();
				out.close();
				
				in.close();
				socket.close();
				System.out.println("Receive Server file write compelet...");
			}
		}catch(Exception e){
			
		}
	}

}
