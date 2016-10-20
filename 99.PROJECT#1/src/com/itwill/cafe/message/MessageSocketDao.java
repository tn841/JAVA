package com.itwill.cafe.message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MessageSocketDao {
	
	private MessageReadSocket readSocket;
	private MessageSaveSocket saveSocket;
	
	public MessageSocketDao() throws Exception {
		readSocket = new MessageReadSocket();

		saveSocket = new MessageSaveSocket();
	}
	

	
	//insert 
	public void insert(MessageVO message)throws Exception{
		ArrayList<MessageVO> messageList=
				(ArrayList<MessageVO>)this.readSocket.readData();
		
		messageList.add(message);
		this.saveSocket.saveData(messageList);
		
		readSocket.disconn();
		saveSocket.disconn();
	}
	
	//update
	/*
	 * 쪽지 열람했다는 정보 갱신
	 */
	public void updateChecked(MessageVO message) throws Exception{
		ArrayList<MessageVO> messageList=(ArrayList<MessageVO>)this.readSocket.readData();
		
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgNo() == message.getMsgNo()){
				messageVO.setChecked(true);
				break;
			}
		}

		saveSocket.saveData(messageList);
		
		readSocket.disconn();
		saveSocket.disconn();
	}
	
	//selectByNo 
	public MessageVO selectByNo(int no) throws Exception{
		MessageVO findMessage=null;
		ArrayList<MessageVO> messageList=this.readSocket.readData();
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgNo()==no){
				findMessage=messageVO;
				break;
			}
		}
		readSocket.disconn();
		saveSocket.disconn();
		return findMessage;
	}
	
	public ArrayList<MessageVO> selectByid(String id) throws Exception{
		ArrayList<MessageVO> messageListTmp=new ArrayList<MessageVO>();
		ArrayList<MessageVO> messageList=this.readSocket.readData();
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgReciver().equals(id)){
				messageListTmp.add(messageVO);
			}
		}
		readSocket.disconn();
		saveSocket.disconn();
		return messageListTmp;
	}
	
	//delete 
	public void delete(int no) throws Exception{
		ArrayList<MessageVO> messageList=this.readSocket.readData();
		for (MessageVO messageVO : messageList) {
			if(messageVO.getMsgNo()==no){
				messageList.remove(messageVO);
				break;
			}
		}
		this.saveSocket.saveData(messageList);
		readSocket.disconn();
		saveSocket.disconn();
	}
	
	
	
	//selectAll 
	public ArrayList<MessageVO> selectAll() throws Exception{
		ArrayList<MessageVO> messageList = this.readSocket.readData();
		readSocket.disconn();
		saveSocket.disconn();
		return messageList;
	}
	
	
}

