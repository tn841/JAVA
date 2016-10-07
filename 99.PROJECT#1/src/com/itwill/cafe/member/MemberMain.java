package com.itwill.cafe.member;

import java.util.ArrayList;

public class MemberMain {

	public static void main(String[] args) throws Exception {
		
		MemberService memberServ = new MemberService();
		//ȸ������
		memberServ.joinMember(new MemberVO(0, "towtorow", "�ڼ���", "1111", false, "towtorow@naver.com", 25, 0, 0, 0));
		memberServ.joinMember(new MemberVO(0, "towtorow2", "�輺��", "1111", false, "towtorow2@naver.com", 25, 0, 0, 0));
		memberServ.joinMember(new MemberVO(0, "towtorow3", "�Ǽ���", "1111", false, "towtorow3@naver.com", 25, 0, 0, 0));
		//Ȯ��
		ArrayList<MemberVO> memberList = memberServ.getMemberList();
		for (MemberVO memberVO : memberList) {
			System.out.println(memberVO);
		}
		//�α���
		if(memberServ.login("towtorow", "1111")==true){
			System.out.println("�α��� ����!!");
		}
		//ȸ��Ż��
		if(memberServ.deleteMember()==true){
			System.out.println("ȸ��Ż�� ����!!");
		}
		//�α���
		if(memberServ.login("towtorow2", "1111")==true){
			System.out.println("�α��� ����!!");
		}
		//���� �α����� ���� ���� ����
		memberServ.modifyMember(new MemberVO(0, "towtorow4", "�ۼ���", "2222", true, "bkllnmas@naver.com", 30, 0, 0, 0));
		//�α׾ƿ�
		if(memberServ.logout()==true){
			System.out.println("�α׾ƿ� ����!!");
		}
		//���̵� ��й�ȣ ã��
		MemberVO memberVO = memberServ.findidpass(new MemberVO(0, "", "�ۼ���", "", false, "bkllnmas@naver.com", 0, 0, 0, 0));
		System.out.println(memberVO);
		//�α���
		if(memberServ.login("towtorow4", "2222")==true){
			System.out.println("�α��� ����!!");
		}
		//�α����� ȸ�� �˻�
		MemberVO memberVO2 = memberServ.findLoginMember();
		System.out.println(memberVO);
		//���� ����
		memberServ.setAuth("towtorow3", 5);
		//Ȯ��
		ArrayList<MemberVO> memberList2 = memberServ.getMemberList();
		for (MemberVO memberVO3 : memberList2) {
			System.out.println(memberVO3);
		}
	}

}
