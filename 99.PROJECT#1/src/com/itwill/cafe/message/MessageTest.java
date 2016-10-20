package com.itwill.cafe.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MessageTest {

	public static void main(String[] args) {
		try {
			MessageSocketDao readDao = new MessageSocketDao("서버로부터 데이터 읽기");
			System.out.println();
			MessageSocketDao saveDao = new MessageSocketDao("서버에 데이터 저장");
			
			ArrayList<MessageVO> list = readDao.readData();//읽기 작업
			readDao.disconn();
			
			saveDao.saveData(list);//쓰기 작업
			saveDao.disconn();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static class MessageSocketDao {
		private Socket socket;
		private ObjectOutputStream out;
		private ObjectInputStream in;
		
		public MessageSocketDao(String str) throws Exception {
			System.out.println(str+"용 소켓입니다.");
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
		private ArrayList<MessageVO> readData() throws Exception {
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
		
		/*
		 * 파일쓰기(연결해제)
		 */
		private void saveData(ArrayList<MessageVO> messageList) throws Exception {
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(messageList);
			out.flush();
			
			in = new ObjectInputStream(socket.getInputStream());
			Object data = in.readObject();
			System.out.println((String)data);

		}
		/****************************************/
		
		//insert 
		public void insert(MessageVO message)throws Exception{
			ArrayList<MessageVO> messageList=
					(ArrayList<MessageVO>)this.readData();
			
			messageList.add(message);
			
			this.saveData(messageList);
		}
		
			
		
		//selectAll 
		public ArrayList<MessageVO> selectAll() throws Exception{
			ArrayList<MessageVO> messageList = this.readData();
			return messageList;
		}
		
		
	}
	
	
}
