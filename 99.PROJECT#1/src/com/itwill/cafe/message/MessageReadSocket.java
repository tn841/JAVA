package com.itwill.cafe.message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MessageReadSocket {
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public MessageReadSocket() throws Exception {
		System.out.println("Read 소켓입니다.");
		connect();
	}
	/*
	 * 소켓 연결 하기
	 */
	public void connect() throws Exception{
		socket = new Socket("192.168.12.12", 8880);
		System.out.println("소캣 연결 성공 : "+socket);
	}
	
	/*
	 * 소켓 연결 끊기
	 */
	public void disconn() throws Exception{
		in.close();
		out.close();
		socket.close();
		System.out.println("스트림 및 소켓 연결 해제.");
	}
	
	
	
	/*
	 * 파일읽기(연결)
	 */
	public ArrayList<MessageVO> readData() throws Exception {
		out = new ObjectOutputStream(socket.getOutputStream());
		String signal = "readMsg";
		out.writeObject(signal);
		out.flush();
	
		
		in = new ObjectInputStream(socket.getInputStream());
		Object data = in.readObject();
		ArrayList<MessageVO> messageList = (ArrayList<MessageVO>) data;
		
		for (MessageVO messageVO : messageList) {
			System.out.print(messageVO.toString()+" ");
		}
		
		out.flush();
		
		
		return messageList;
	}
	
	
}