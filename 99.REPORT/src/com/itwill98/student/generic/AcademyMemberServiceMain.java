package com.itwill98.student.generic;

import java.util.ArrayList;

public class AcademyMemberServiceMain {

	public static void main(String[] args) {
		AcademyMemberService memberService=	new AcademyMemberService();
		
		System.out.println("0.memberService야:AcademyMember(AcademyStudent,AcademyStaff,AcademyGangsa)추가해줘");
		memberService.addMember(new AcademyStudent(11, "KIM", "JAVA"));
		memberService.addMember(new AcademyStudent(12, "Han", "IOT"));
		memberService.addMember(new AcademyStaff(13, "HONG", "행정"));
		memberService.addMember(new AcademyGangsa(14, "Choi", "JAVA"));
		
		System.out.println("1.memberService야:AcademyMember전체출력");
		memberService.print();
		
		
		System.out.println("2.memberService야:번호 1번 AcademyMember 1명 반환해줘");
		AcademyMember aMember = memberService.findByNo(1);
		aMember.print();
		
		System.out.println("3.memberService야:이름 KIM AcademyMember  들 반환해줘");
		ArrayList<AcademyMember> aMembersList = memberService.findByName("KIM");
		AcademyMemberService.print(aMembersList);
//		
//		System.out.println("4.memberService야:AcademyStudent들 반환해줘");
//		aMembers = memberService.findStudents();
//		AcademyMemberService.print(aMembers);
//				
//		System.out.println("5.memberService야:AcademyStaff  들 반환해줘");
//		aMembers = memberService.findStaffs();
//		AcademyMemberService.print(aMembers);
//		
//		
//		System.out.println("6.memberService야:AcademyGangsa 들 반환해줘");
//		aMembers = memberService.findGangsas();
//		AcademyMemberService.print(aMembers);
//		
//		
//		System.out.println("7.memberService야:반  이름으로 검색후 AcademyStudent들 반환해줘");
//		aMembers = memberService.findStudentsByName("JAVA");
//		AcademyMemberService.print(aMembers);
//		
//		
//		System.out.println("8.memberService야:부서이름으로 검색후 AcademyStff   들 반환해줘");
//		aMembers = memberService.findStaffsByDepart("홍보");
//		AcademyMemberService.print(aMembers);
//		
//		System.out.println("9.memberService야:과목이름으로 검색후 AcademyGangsa  들 반환해줘");
//		aMembers = memberService.findGangsasBySubject("JAVA");
//		AcademyMemberService.print(aMembers);
//		
		
		
		
		
		
	}

}
