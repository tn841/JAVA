package com.itwill.cafe.server;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.itwill.cafe.message.MessageVO;

public class MessageDao {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public MessageDao() throws Exception {
		init();
	}
	
	/*************copy & paste*************/	
	private File file;
	/*
	 * 초기화메쏘드
	 */
	private void init() throws Exception{
		file = new File("message.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArrayList<MessageVO>());
			oos.close();
		}
		System.out.println("성공");
		
	}
	
	/*
	 * 파일읽기(연결)
	 */
	public ArrayList<MessageVO> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<MessageVO> messageList = (ArrayList<MessageVO>) ois.readObject();
		return messageList;
	}
	
	/*
	 * 파일쓰기(연결해제)
	 */
	public void saveData(ArrayList<MessageVO> messageList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(messageList);
		oos.flush();
		oos.close();
	}
	/****************************************/
	
	//insert 
	public void insert(MessageVO message)throws Exception{
		ArrayList<MessageVO> messageList=
				(ArrayList<MessageVO>)this.readData();
		
		messageList.add(message);
		
		this.saveData(messageList);
	}
	
	//update
	/*
	 * 쪽지 열람했다는 정보 갱신
	 */
	public void updateChecked(MessageVO message) throws Exception{
		ArrayList<MessageVO> messageList=(ArrayList<MessageVO>)this.readData();
		
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgNo() == message.getMsgNo()){
				messageVO.setChecked(true);
				break;
			}
		}

		saveData(messageList);
	}
	
	//selectByNo 
	public MessageVO selectByNo(int no) throws Exception{
		MessageVO findMessage=null;
		ArrayList<MessageVO> messageList=this.readData();
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgNo()==no){
				findMessage=messageVO;
				break;
			}
		}
		
		return findMessage;
	}
	
	public ArrayList<MessageVO> selectByid(String id) throws Exception{
		ArrayList<MessageVO> messageListTmp=new ArrayList<MessageVO>();
		ArrayList<MessageVO> messageList=this.readData();
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgReciver().equals(id)){
				messageListTmp.add(messageVO);
			}
		}
		
		return messageListTmp;
	}
	
	//delete 
	public void delete(int no) throws Exception{
		ArrayList<MessageVO> messageList=this.readData();
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgNo()==no){
				messageList.remove(messageVO);
				break;
			}
		}
		this.saveData(messageList);
	}
	
	
	
	//selectAll 
	public ArrayList<MessageVO> selectAll() throws Exception{
		ArrayList<MessageVO> messageList = this.readData();
		
		return messageList;
	}
	
	
}

