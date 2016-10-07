package com.itwill.cafe.member;

import java.util.ArrayList;

public class MemberMain {

	public static void main(String[] args) throws Exception {
		
		MemberService memberServ = new MemberService();
		//회원가입
		memberServ.joinMember(new MemberVO(0, "towtorow", "박성빈", "1111", false, "towtorow@naver.com", 25, 0, 0, 0));
		memberServ.joinMember(new MemberVO(0, "towtorow2", "삭성빈", "1111", false, "towtorow2@naver.com", 25, 0, 0, 0));
		memberServ.joinMember(new MemberVO(0, "towtorow3", "악성빈", "1111", false, "towtorow3@naver.com", 25, 0, 0, 0));
		//확인
		ArrayList<MemberVO> memberList = memberServ.getMemberList();
		for (MemberVO memberVO : memberList) {
			System.out.println(memberVO);
		}
		//로그인
		if(memberServ.login("towtorow", "1111")==true){
			System.out.println("로그인 성공!!");
		}
		//회원탈퇴
		if(memberServ.deleteMember()==true){
			System.out.println("회원탈퇴 성공!!");
		}
		//로그인
		if(memberServ.login("towtorow2", "1111")==true){
			System.out.println("로그인 성공!!");
		}
		//현재 로그인한 계정 정보 수정
		memberServ.modifyMember(new MemberVO(0, "towtorow4", "작성빈", "2222", true, "bkllnmas@naver.com", 30, 0, 0, 0));
		//로그아웃
		if(memberServ.logout()==true){
			System.out.println("로그아웃 성공!!");
		}
		//아이디 비밀번호 찾기
		MemberVO memberVO = memberServ.findidpass(new MemberVO(0, "", "작성빈", "", false, "bkllnmas@naver.com", 0, 0, 0, 0));
		System.out.println(memberVO);
		//로그인
		if(memberServ.login("towtorow4", "2222")==true){
			System.out.println("로그인 성공!!");
		}
		//로그인한 회원 검색
		MemberVO memberVO2 = memberServ.findLoginMember();
		System.out.println(memberVO);
		//권한 설정
		memberServ.setAuth("towtorow3", 5);
		//확인
		ArrayList<MemberVO> memberList2 = memberServ.getMemberList();
		for (MemberVO memberVO3 : memberList2) {
			System.out.println(memberVO3);
		}
	}

}
