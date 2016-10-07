package com.itwill.cafe.comment;

import java.util.ArrayList;

import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.Post;

public class CommentTestMain {

	public static void main(String[] args) throws Exception {
		CommentService cserv = new CommentService();
		
		//테스트 용 데어터 파일 리셋(회원은 member.dat파일 지우고 '회원 가입 및 로그인' 부분 주석제거)
//		cserv.cmtreset();
		
		/*
		 	회원 가입 및 로그인
		 */
/*		mserv.joinMember(new MemberVO(1, "id1", "이름1", "pass1", false, "e-mail1", 10, 0, 0));
		mserv.joinMember(new MemberVO(2, "id2", "이름2", "pass2", false, "e-mail2", 20, 0, 0));
		mserv.joinMember(new MemberVO(3, "id3", "이름3", "pass3", false, "e-mail3", 30, 0, 0));
		mserv.joinMember(new MemberVO(4, "id4", "이름4", "pass4", false, "e-mail4", 40, 0, 0));
		mserv.login("id3", "pass3");*/
		
		System.out.println("--- 멤버 , true가 로그인된 멤버 ---");
		System.out.println(cserv.findeLoginMemberName());
		System.out.println();
		
		/*
		 	게시글 쓰기
		 */
		
//		System.out.println("--- 게시글 리스트, true가 UI상 보여지고 있는 게시글 ---");
//		ArrayList<Post> pList = cserv.allPost();
//		for (Post post : pList) {
//			System.out.println(post);
//		}
//		System.out.println();
		
		/*
		 	댓글 쓰기
		 */
//		System.out.println("--- 댓글 리스트, 댓글 객체에 게시글 고유 넘버 저장 ---");
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글1",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글2",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글3",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글4",2);
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글5",2);
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글6",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "댓글7",1);
//		
		ArrayList<Comment> cList = cserv.allComments();
		for (Comment comment : cList) {
			System.out.println(comment);
		}
		System.out.println();
		
		/*
		 	댓글 수정
		 	 - 무슨 댓글을 수정할지는 UI에서 컨트롤 해야할 듯....
		 */
		
		//isSelected true인 댓글 내용만 수정
//		System.out.println("--- 댓글 내용 수정(댓글7 --> 댓글 수정) ---");
//		cserv.updateComment("댓글 수정",7);	
//		cList = cserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	댓글 삭제
//		 	 - 무슨 댓글을 삭제할지는 UI에서 컨트롤 해야할 듯...
//		 */
//		
//		System.out.println("--- 댓글 삭제(7번 댓글 삭제) ---");
//		cserv.deleteComment(7);
//		cList = cserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	게시글 넘버로 댓글 여럿 찾기
//		 */
//		System.out.println("--- 게시글 넘버로 댓글 여럿 찾기 ---");
//		cList = cserv.findCommentsByPostNo(1);
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	댓글 고유 넘버로 수정 하기
//		 */
//		System.out.println("--- 댓글 넘버로 수정 하기 ---");
//		cserv.updateComment("댓글4 수정", 4);
//		cList = cserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	액션 커맨드로 댓글 Array index 찾기
//		 */
//		System.out.println("--- 액션 커맨드로 댓글 고유 넘버 찾기 ---");
//		System.out.println(cserv.getCmtNoByAction(3,1));
//		
	}

}
