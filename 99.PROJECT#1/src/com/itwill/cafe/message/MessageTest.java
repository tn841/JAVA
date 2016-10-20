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
			MessageSocketDao readDao = new MessageSocketDao("�����κ��� ������ �б�");
			System.out.println();
			MessageSocketDao saveDao = new MessageSocketDao("������ ������ ����");
			
			ArrayList<MessageVO> list = readDao.readData();//�б� �۾�
			readDao.disconn();
			
			saveDao.saveData(list);//���� �۾�
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
			System.out.println(str+"�� �����Դϴ�.");
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
			in.close();
			out.close();
			socket.close();
			System.out.println("��Ʈ�� �� ���� ���� ����.");
		}
		
		
		
		/*
		 * �����б�(����)
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
		 * ���Ͼ���(��������)
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
