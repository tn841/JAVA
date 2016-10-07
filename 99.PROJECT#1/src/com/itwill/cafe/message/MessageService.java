package com.itwill.cafe.message;

import java.util.ArrayList;

import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.comment.CommentDao;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.PostDao;

/*
 *  쪽지의 비즈니스 클래스
 */
public class MessageService {
	/*
	 * 쪽지 서비스 구현에 필요한 DAO 객체 선언
	 */
	private MessageDao messageDao;
	

	/*
	 * MessageService 생성자 - Dao객체 생성
	 */
	public MessageService() throws Exception {
		messageDao = new MessageDao();

	}

	/*
	 * 1. 쪽지 생성 - 필요한 인자 : 쪽지객체 - 반환값 : true / false
	 */
	public boolean createMessage(MessageVO msg) throws Exception {
		msg.setMsgNo(returnLastNo()+1);
		messageDao.insert(msg);
		return true;
	}

	/*
	 * 2. 쪽지 삭제
	 */
	public void deleteMessage(int msgNo) throws Exception {
		messageDao.delete(msgNo);
	}

	/*
	 * 3. 쪽지 목록 보여주기
	 */
	public ArrayList<MessageVO> showMessageList(String id) throws Exception {
		return messageDao.selectByid(id);
	}

	/*
	 * 4. 쪽지 보여주기
	 */
	public MessageVO showMessage(int no) throws Exception {
		
		return messageDao.selectByNo(no);
	}
	
	
	

	/*
	 *  5. 받는사람 ID 로 쪽지 리스트 찾기
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
	 * 6. 마지막 고유번호 반환
	 */
	public int returnLastNo() throws Exception{
		ArrayList<MessageVO> messageList = messageDao.selectAll();
			
		if( messageList.size() == 0){
			return 0;
		}
			
		return messageList.get(messageList.size()-1).getMsgNo();
	}
	
	/*
	 * 7. 특정 메시지를 열람한 것으로 설정
	 */
	public void updateChecked(MessageVO m) throws Exception{
		messageDao.updateChecked(m);
	}
	
}
