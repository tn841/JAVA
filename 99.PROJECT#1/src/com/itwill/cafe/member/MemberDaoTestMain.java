package com.itwill.cafe.member;

import java.util.ArrayList;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao = new MemberDao();
		
		System.out.println("-----insert--------");
		/*
		memberDao.insert(new MemberVO(1, "towtorow", "�ڼ���", "1111", false, "towtorow@naver.com", 25, 0, 0));
		memberDao.insert(new MemberVO(2, "towtorow2", "�ڼ���2", "1111", false, "towtorow2@naver.com", 25, 0, 0));
		memberDao.insert(new MemberVO(3, "towtorow3", "�ڼ���3", "1111", false, "towtorow3@naver.com", 25, 0, 0));
		*/
		
		System.out.println("-----selectByNo--------");
		/*
		MemberVO findMember=memberDao.selectByNo(3);
		System.out.println(findMember);
		System.out.println("-----selectAll--------");
		ArrayList<MemberVO> memberList=memberDao.selectAll();
		for (MemberVO memberVO : memberList) {
			System.out.println(memberVO);
		}
		*/
		
		System.out.println("-----delete--------");
		/*
		memberDao.deleteById("towtorow3");
		ArrayList<MemberVO> memberList=memberDao.selectAll();
		for (MemberVO memberVO : memberList) {
			System.out.println(memberVO);
		}
		*/
		
		System.out.println("-----update--------");
		/*
		MemberVO updateMember=new MemberVO(2, "bkllnmas", "�輺��", "2222", false, "towtorow@gamil.com", 25, 0, 0);
		memberDao.update(updateMember);
		System.out.println(memberDao.selectByNo(2));
		*/
		
	}

}
