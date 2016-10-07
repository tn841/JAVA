package com.itwill.cafe.comment;

import java.util.ArrayList;

import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.Post;

public class CommentTestMain {

	public static void main(String[] args) throws Exception {
		CommentService cserv = new CommentService();
		
		//�׽�Ʈ �� ������ ���� ����(ȸ���� member.dat���� ����� 'ȸ�� ���� �� �α���' �κ� �ּ�����)
//		cserv.cmtreset();
		
		/*
		 	ȸ�� ���� �� �α���
		 */
/*		mserv.joinMember(new MemberVO(1, "id1", "�̸�1", "pass1", false, "e-mail1", 10, 0, 0));
		mserv.joinMember(new MemberVO(2, "id2", "�̸�2", "pass2", false, "e-mail2", 20, 0, 0));
		mserv.joinMember(new MemberVO(3, "id3", "�̸�3", "pass3", false, "e-mail3", 30, 0, 0));
		mserv.joinMember(new MemberVO(4, "id4", "�̸�4", "pass4", false, "e-mail4", 40, 0, 0));
		mserv.login("id3", "pass3");*/
		
		System.out.println("--- ��� , true�� �α��ε� ��� ---");
		System.out.println(cserv.findeLoginMemberName());
		System.out.println();
		
		/*
		 	�Խñ� ����
		 */
		
//		System.out.println("--- �Խñ� ����Ʈ, true�� UI�� �������� �ִ� �Խñ� ---");
//		ArrayList<Post> pList = cserv.allPost();
//		for (Post post : pList) {
//			System.out.println(post);
//		}
//		System.out.println();
		
		/*
		 	��� ����
		 */
//		System.out.println("--- ��� ����Ʈ, ��� ��ü�� �Խñ� ���� �ѹ� ���� ---");
//		cserv.writeComment(cserv.findeLoginMemberName(), "���1",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "���2",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "���3",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "���4",2);
//		cserv.writeComment(cserv.findeLoginMemberName(), "���5",2);
//		cserv.writeComment(cserv.findeLoginMemberName(), "���6",1);
//		cserv.writeComment(cserv.findeLoginMemberName(), "���7",1);
//		
		ArrayList<Comment> cList = cserv.allComments();
		for (Comment comment : cList) {
			System.out.println(comment);
		}
		System.out.println();
		
		/*
		 	��� ����
		 	 - ���� ����� ���������� UI���� ��Ʈ�� �ؾ��� ��....
		 */
		
		//isSelected true�� ��� ���븸 ����
//		System.out.println("--- ��� ���� ����(���7 --> ��� ����) ---");
//		cserv.updateComment("��� ����",7);	
//		cList = cserv.allComments();
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
//		System.out.println("--- ��� ����(7�� ��� ����) ---");
//		cserv.deleteComment(7);
//		cList = cserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	�Խñ� �ѹ��� ��� ���� ã��
//		 */
//		System.out.println("--- �Խñ� �ѹ��� ��� ���� ã�� ---");
//		cList = cserv.findCommentsByPostNo(1);
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	��� ���� �ѹ��� ���� �ϱ�
//		 */
//		System.out.println("--- ��� �ѹ��� ���� �ϱ� ---");
//		cserv.updateComment("���4 ����", 4);
//		cList = cserv.allComments();
//		for (Comment comment : cList) {
//			System.out.println(comment);
//		}
//		System.out.println();
//		
//		/*
//		 	�׼� Ŀ�ǵ�� ��� Array index ã��
//		 */
//		System.out.println("--- �׼� Ŀ�ǵ�� ��� ���� �ѹ� ã�� ---");
//		System.out.println(cserv.getCmtNoByAction(3,1));
//		
	}

}
