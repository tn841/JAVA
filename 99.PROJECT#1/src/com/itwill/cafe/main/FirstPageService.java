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
	 * 첫 화면 구현에 필요한  Dao 객체 선언
	 */
	private BoardDao boardDao;
	private MemberDao memberDao;
	private MessageDao messageDao;
	private PostDao postDao;
	
	public static MemberVO activeMember;
	
	
	/*
	 * 생성자
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
	 * 1. 로그인한 회원 정보 저장??
	 */
	public boolean checkLogin(){
		return false;
	}
	
	
	/*
	 * 2. 현재 로그인한 회원의 정보 가지고 오기
	 * 	- 로그인한 자신의 정보를 띄워준다.
	 */
	public Member getMemberInfo(){
		return null;
	}
	
	
	/*
	 * 3. 현재 로그인한 회원에게 온 쪽지 갯수 
	 */
	public int getMessageCount(){
		return 0;
	}
	
	
	/*
	 * 4. 현재 로그인한 회원이 볼 수 있는 게시판 목록 가지고 오기
	 */
	public ArrayList<Board> getBoardList(){
		return null;
	}
	
	
	/*
	 * 5. 현재 로그인한 회원이 볼 수 있는 게시판 별 최근 게시글 5개씩 가지고 오기
	 *  - ???
	 */
	public ArrayList<ArrayList<Post>> getPostAsBoard(){
		return null;
	}
	
	/*
	 *  6. 현재 로그인한 회원의 권한 확인
	 */
	public int checkAuth(){
		return 0;
	}
}
