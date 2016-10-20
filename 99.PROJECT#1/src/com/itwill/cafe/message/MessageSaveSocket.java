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
		System.out.println("Save �����Դϴ�.");
		connect();
	}
	/*
	 * ���� ���� �ϱ�
	 */
	public void connect() throws Exception{
		socket = new Socket("192.168.12.12", 8880);
		System.out.println("��Ĺ ���� ���� : "+socket);
	}
	
	/*
	 * ���� ���� ����
	 */
	public void disconn() throws Exception{
		if(in != null){
			in.close();
		}
		if(out != null){
			out.close();
		}
		socket.close();
		System.out.println("��Ʈ�� �� ���� ���� ����.");
	}
	
	
		
	/*
	 * ���Ͼ���(��������)
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