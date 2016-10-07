package com.itwill.cafe.message;

import java.util.ArrayList;

import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.comment.CommentDao;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.PostDao;

/*
 *  ������ ����Ͻ� Ŭ����
 */
public class MessageService {
	/*
	 * ���� ���� ������ �ʿ��� DAO ��ü ����
	 */
	private MessageDao messageDao;
	

	/*
	 * MessageService ������ - Dao��ü ����
	 */
	public MessageService() throws Exception {
		messageDao = new MessageDao();

	}

	/*
	 * 1. ���� ���� - �ʿ��� ���� : ������ü - ��ȯ�� : true / false
	 */
	public boolean createMessage(MessageVO msg) throws Exception {
		msg.setMsgNo(returnLastNo()+1);
		messageDao.insert(msg);
		return true;
	}

	/*
	 * 2. ���� ����
	 */
	public void deleteMessage(int msgNo) throws Exception {
		messageDao.delete(msgNo);
	}

	/*
	 * 3. ���� ��� �����ֱ�
	 */
	public ArrayList<MessageVO> showMessageList(String id) throws Exception {
		return messageDao.selectByid(id);
	}

	/*
	 * 4. ���� �����ֱ�
	 */
	public MessageVO showMessage(int no) throws Exception {
		
		return messageDao.selectByNo(no);
	}
	
	
	

	/*
	 *  5. �޴»�� ID �� ���� ����Ʈ ã��
	 */
	public ArrayList<MessageVO> selectByReceiverId(String id) throws Exception {
		ArrayList<MessageVO> selectedList = new ArrayList<MessageVO>();
		ArrayList<MessageVO> allMsgList = messageDao.selectAll();
		
		for (MessageVO messageVO : allMsgList) {
			if(messageVO.getMsgReciver().equals(id)  ){
				selectedList.add(messageVO);
			}
		}
		return selectedList;
	}
	
	/*
	 * 6. ������ ������ȣ ��ȯ
	 */
	public int returnLastNo() throws Exception{
		ArrayList<MessageVO> messageList = messageDao.selectAll();
			
		if( messageList.size() == 0){
			return 0;
		}
			
		return messageList.get(messageList.size()-1).getMsgNo();
	}
	
	/*
	 * 7. Ư�� �޽����� ������ ������ ����
	 */
	public void updateChecked(MessageVO m) throws Exception{
		messageDao.updateChecked(m);
	}
	
}
