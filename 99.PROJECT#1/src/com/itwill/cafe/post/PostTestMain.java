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
//		//�׽�Ʈ �� ������ ���� ����(ȸ���� member.dat���� ����� 'ȸ�� ���� �� �α���' �κ� �ּ�����)
////		pserv.cmtreset();
////		pserv.postReset();
//		
//		/*
//		 	ȸ�� ���� �� �α���
//		 */
///*		mserv.joinMember(new MemberVO(1, "id1", "�̸�1", "pass1", false, "e-mail1", 10, 0, 0));
//		mserv.joinMember(new MemberVO(2, "id2", "�̸�2", "pass2", false, "e-mail2", 20, 0, 0));
//		mserv.joinMember(new MemberVO(3, "id3", "�̸�3", "pass3", false, "e-mail3", 30, 0, 0));
//		mserv.joinMember(new MemberVO(4, "id4", "�̸�4", "pass4", false, "e-mail4", 40, 0, 0));
//		mserv.login("id3", "pass3");*/
//		
//		System.out.println("--- ��� ����Ʈ, true�� �α��ε� ��� ---");
//		ArrayList<MemberVO> mList = mserv.getMemberList();
//		for (MemberVO memberVO : mList) {
//			System.out.println(memberVO);
//		}
//		System.out.println();
//		
//		/*
//		 	�Խñ� ����
//		 */
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "�Խñ�1");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "�Խñ�2");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "�Խñ�3");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "�Խñ�4");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "�Խñ�5");
//		pserv.TestwritePost(mserv.findLoginMember().getId(), "�Խñ�6");
//		
//		
//		System.out.println("--- �Խñ� ����Ʈ, true�� UI�� �������� �ִ� �Խñ� ---");
//		ArrayList<Post> pList = pserv.TestallPosts();
//		for (Post post : pList) {
//			System.out.println(post);
//		}
//		System.out.println();
//		
//		/*
//		 	��� ����
//		 */
//		System.out.println("--- ��� ����Ʈ, ��� ��ü�� �Խñ� ���� �ѹ� ���� ---");
//		pserv.writeComment(mserv.findLoginMember().getName(), "���1");
//		pserv.writeComment(mserv.findLoginMember().getName(), "���2");
//		
//		ArrayList<Comment> cList = pserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	��� ����
//		 	 - ���� ����� ���������� UI���� ��Ʈ�� �ؾ��� ��....
//		 */
//		
//		//isSelected true�� ��� ���븸 ����
//		System.out.println("--- ��� ���� ����(���2 --> ��� ����");
//		pserv.updateCommentBySelected("��� ����");	//������ ���� ����� isSelected true
//		cList = pserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	��� ����
//		 	 - ���� ����� ���������� UI���� ��Ʈ�� �ؾ��� ��...
//		 */
//		
//		System.out.println("--- ��� ����(2�� ��� ����) ");
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
