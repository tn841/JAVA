package com.itwill99.student.service;

public class AcademyMemberServiceMain {

	public static void main(String[] args) {
		AcademyMemberService memberService=	new AcademyMemberService();
		System.out.println("0.memberService��:AcademyMember(AcademyStudent,AcademyStaff,AcademyGangsa)�߰�����");
		System.out.println("1.memberService��:AcademyMember��ü���");
		memberService.print();
		System.out.println("2.memberService��:��ȣ 1�� AcademyMember 1�� ��ȯ����");
		System.out.println("3.memberService��:�̸� KIM AcademyMember  �� ��ȯ����");
		
		System.out.println("4.memberService��:AcademyStudent�� ��ȯ����");
		AcademyMember[] findMembers=memberService.findAcademyMembers(AcademyMember.MEMBER_STUDENT);
		for (int i = 0; i < findMembers.length; i++) {
			findMembers[i].print();
			
		}
		System.out.println("5.memberService��:AcademyStaff  �� ��ȯ����");
		findMembers=memberService.findAcademyMembers(AcademyMember.MEMBER_STAFF);
		for (int i = 0; i < findMembers.length; i++) {
			findMembers[i].print();
			
		}
		System.out.println("6.memberService��:AcademyGangsa �� ��ȯ����");
		findMembers=memberService.findAcademyMembers(AcademyMember.MEMBER_GANGSA);
		for (int i = 0; i < findMembers.length; i++) {
			findMembers[i].print();
			
		}
		System.out.println("7.memberService��:��  �̸����� �˻��� AcademyStudent�� ��ȯ����");
		/*   
		 * DTO(Data Transfer Object)
		 */  
		AcademyStudent studentDTO=new AcademyStudent(-999, null, "JAVA");
		memberService
			.findByChildMember1(studentDTO);
		memberService
			.findByChildMember2(
					AcademyMember.MEMBER_STUDENT, "JAVA");
		
		System.out.println("8.memberService��:�μ��̸����� �˻��� AcademyStaff  �� ��ȯ����");
		memberService
		.findByChildMember1(new AcademyStaff(-999, null, "ȫ��"));
		memberService
		.findByChildMember2(
				AcademyMember.MEMBER_STAFF, "ȫ��");
		
		System.out.println("9.memberService��:�����̸����� �˻��� AcademyGansa  �� ��ȯ����");
		memberService
		.findByChildMember1(
				new AcademyGangsa(-999, null, "DESIGN"));
		memberService
		.findByChildMember2(
				AcademyMember.MEMBER_GANGSA, "DESIGN");
		
		
		
		
		
		
	}

}
