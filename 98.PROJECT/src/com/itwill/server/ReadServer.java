package com.itwill.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.itwill.member.Member;

public class ReadServer extends Thread{
	
	private File memberFile;
	
	
	public ReadServer() throws Exception{
		memberFile = new File("member.dat");
		if(!memberFile.exists()){
			memberFile.createNewFile();
			ObjectOutputStream oos=
					new ObjectOutputStream(
							new FileOutputStream(memberFile));
			oos.writeObject(new ArrayList<Member>());
			oos.flush();
			oos.close();
		}
		
	}
	
	
	/*
	 * Server�� �ִ� member.dat -> ArrayList<Member>
	 */
	private ArrayList<Member> readList() throws Exception{
		ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream(memberFile));
		ArrayList<Member> memberList = (ArrayList<Member>)in.readObject();
		return memberList;
	}
	
	@Override
	public void run() {
		try{
			ServerSocket serverSocket = new ServerSocket(9000);
			while(true){
				System.out.println("SendServer open...");
				Socket socket = serverSocket.accept();
				/*
				 * 1. ������ �ִ� member.dat�� �о
				 */
				ArrayList<Member> readData = readList();
				
				/*
				 * 2. Ŭ���̾�Ʈ�� ����
				 */
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject(readData);
				out.flush();
				out.close();
				System.out.println("Ŭ���̾�Ʈ�� ������ ���� �Ϸ�.");
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ReadServer().start();
	}

}
