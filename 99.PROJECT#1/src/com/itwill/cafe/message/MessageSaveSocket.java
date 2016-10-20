package com.itwill.cafe.message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MessageSaveSocket {
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public MessageSaveSocket() throws Exception {
		System.out.println("Save 소켓입니다.");
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
		if(in != null){
			in.close();
		}
		if(out != null){
			out.close();
		}
		socket.close();
		System.out.println("스트림 및 소켓 연결 해제.");
	}
	
	
		
	/*
	 * 파일쓰기(연결해제)
	 */
	public void saveData(ArrayList<MessageVO> messageList) throws Exception {
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(messageList);
		out.flush();
		
		in = new ObjectInputStream(socket.getInputStream());
		Object data = in.readObject();
		System.out.println((String)data);

	}

}