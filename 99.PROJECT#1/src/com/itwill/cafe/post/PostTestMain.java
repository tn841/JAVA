//package com.itwill.cafe.post;
//
//import java.util.ArrayList;
//
//import com.itwill.cafe.member.MemberService;
//import com.itwill.cafe.member.MemberVO;
//
//public class PostTestMain {
//
//	public static void main(String[] args) throws Exception {
//		PostService pserv = new PostService();
//		MemberService mserv = new MemberService();
//		
//		//테스트 용 데어터 파일 리셋(회원은 member.dat파일 지우고 '회원 가입 및 로그인' 부분 주석제거)
////		pserv.cmtreset();
////		pserv.postReset();
//		
//		/*
//		 	회원 가입 및 로그인
//		 */
///*		mserv.joinMember(new MemberVO(1, "id1", "이름1", "pass1", false, "e-mail1", 10, 0, 0));
//		mserv.joinMember(new MemberVO(2, "id2", "이름2", "pass2", false, "e-mail2", 20, 0, 0));
//		mserv.joinMember(new MemberVO(3, "id3", "이름3", "pass3", false, "e-mail3", 30, 0, 0));
//		mserv.joinMember(new MemberVO(4, "id4", "이름4", "pass4", false, "e-mail4", 40, 0, 0));
//		mserv.login("id3", "pass3");*/
//		
//		System.out.println("--- 멤버 리스트, true가 로그인된 멤버 ---");
//		ArrayList<MemberVO> mList = mserv.getMemberList();
//		for (MemberVO memberVO : mList) {
//			System.out.println(memberVO);
//		}
//		System.out.println();
//		
//		/*
//		 	게시글 쓰기
//		 */
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "게시글1");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "게시글2");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "게시글3");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "게시글4");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "게시글5");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "게시글6");
//		
//		
//		System.out.println("--- 게시글 리스트, true가 UI상 보여지고 있는 게시글 ---");
//		ArrayList<Post> pList = pserv.TestallPosts();
//		for (Post post : pList) {
//			System.out.println(post);
//		}
//		System.out.println();
//		
//		/*
//		 	댓글 쓰기
//		 */
//		System.out.println("--- 댓글 리스트, 댓글 객체에 게시글 고유 넘버 저장 ---");
//		pserv.writeComment(mserv.findLoginMember().getName(), "댓글1");
//		pserv.writeComment(mserv.findLoginMember().getName(), "댓글2");
//		
//		ArrayList<Comment> cList = pserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	댓글 수정
//		 	 - 무슨 댓글을 수정할지는 UI에서 컨트롤 해야할 듯....
//		 */
//		
//		//isSelected true인 댓글 내용만 수정
//		System.out.println("--- 댓글 내용 수정(댓글2 --> 댓글 수정");
//		pserv.updateCommentBySelected("댓글 수정");	//마지막 생성 댓글은 isSelected true
//		cList = pserv.allComments();
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
//		System.out.println("--- 댓글 삭제(2번 댓글 삭제) ");
//		pserv.deleteCmtByTrue();
//		cList = pserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		
//	}
//
//}
