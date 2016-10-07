package com.itwill.cafe.main;

import java.lang.reflect.Member;
import java.util.ArrayList;

import com.itwill.cafe.board.Board;
import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.member.MemberDao;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.message.MessageDao;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostDao;

public class FirstPageService {
	/*
	 * ù ȭ�� ������ �ʿ���  Dao ��ü ����
	 */
	private BoardDao boardDao;
	private MemberDao memberDao;
	private MessageDao messageDao;
	private PostDao postDao;
	
	public static MemberVO activeMember;
	
	
	/*
	 * ������
	 */
	public FirstPageService(){
		activeMember = null;
		
	}
	
	
	
	public static MemberVO getActiveMember() {
		return FirstPageService.activeMember;
	}


	public static void setActiveMember(MemberVO activeMember) {
		FirstPageService.activeMember = activeMember;
	}


	/*
	 * 1. �α����� ȸ�� ���� ����??
	 */
	public boolean checkLogin(){
		return false;
	}
	
	
	/*
	 * 2. ���� �α����� ȸ���� ���� ������ ����
	 * 	- �α����� �ڽ��� ������ ����ش�.
	 */
	public Member getMemberInfo(){
		return null;
	}
	
	
	/*
	 * 3. ���� �α����� ȸ������ �� ���� ���� 
	 */
	public int getMessageCount(){
		return 0;
	}
	
	
	/*
	 * 4. ���� �α����� ȸ���� �� �� �ִ� �Խ��� ��� ������ ����
	 */
	public ArrayList<Board> getBoardList(){
		return null;
	}
	
	
	/*
	 * 5. ���� �α����� ȸ���� �� �� �ִ� �Խ��� �� �ֱ� �Խñ� 5���� ������ ����
	 *  - ???
	 */
	public ArrayList<ArrayList<Post>> getPostAsBoard(){
		return null;
	}
	
	/*
	 *  6. ���� �α����� ȸ���� ���� Ȯ��
	 */
	public int checkAuth(){
		return 0;
	}
}
