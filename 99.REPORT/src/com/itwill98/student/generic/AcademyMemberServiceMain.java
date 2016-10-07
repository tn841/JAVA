package com.itwill98.student.generic;

import java.util.ArrayList;

public class AcademyMemberServiceMain {

	public static void main(String[] args) {
		AcademyMemberService memberService=	new AcademyMemberService();
		
		System.out.println("0.memberService��:AcademyMember(AcademyStudent,AcademyStaff,AcademyGangsa)�߰�����");
		memberService.addMember(new AcademyStudent(11, "KIM", "JAVA"));
		memberService.addMember(new AcademyStudent(12, "Han", "IOT"));
		memberService.addMember(new AcademyStaff(13, "HONG", "����"));
		memberService.addMember(new AcademyGangsa(14, "Choi", "JAVA"));
		
		System.out.println("1.memberService��:AcademyMember��ü���");
		memberService.print();
		
		
		System.out.println("2.memberService��:��ȣ 1�� AcademyMember 1�� ��ȯ����");
		AcademyMember aMember = memberService.findByNo(1);
		aMember.print();
		
		System.out.println("3.memberService��:�̸� KIM AcademyMember  �� ��ȯ����");
		ArrayList<AcademyMember> aMembersList = memberService.findByName("KIM");
		AcademyMemberService.print(aMembersList);
//		
//		System.out.println("4.memberService��:AcademyStudent�� ��ȯ����");
//		aMembers = memberService.findStudents();
//		AcademyMemberService.print(aMembers);
//				
//		System.out.println("5.memberService��:AcademyStaff  �� ��ȯ����");
//		aMembers = memberService.findStaffs();
//		AcademyMemberService.print(aMembers);
//		
//		
//		System.out.println("6.memberService��:AcademyGangsa �� ��ȯ����");
//		aMembers = memberService.findGangsas();
//		AcademyMemberService.print(aMembers);
//		
//		
//		System.out.println("7.memberService��:��  �̸����� �˻��� AcademyStudent�� ��ȯ����");
//		aMembers = memberService.findStudentsByName("JAVA");
//		AcademyMemberService.print(aMembers);
//		
//		
//		System.out.println("8.memberService��:�μ��̸����� �˻��� AcademyStff   �� ��ȯ����");
//		aMembers = memberService.findStaffsByDepart("ȫ��");
//		AcademyMemberService.print(aMembers);
//		
//		System.out.println("9.memberService��:�����̸����� �˻��� AcademyGangsa  �� ��ȯ����");
//		aMembers = memberService.findGangsasBySubject("JAVA");
//		AcademyMemberService.print(aMembers);
//		
		
		
		
		
		
	}

}
