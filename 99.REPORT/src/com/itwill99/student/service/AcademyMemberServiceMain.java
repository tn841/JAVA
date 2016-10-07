package com.itwill99.student.service;

public class AcademyMemberServiceMain {

	public static void main(String[] args) {
		AcademyMemberService memberService=	new AcademyMemberService();
		System.out.println("0.memberService야:AcademyMember(AcademyStudent,AcademyStaff,AcademyGangsa)추가해줘");
		System.out.println("1.memberService야:AcademyMember전체출력");
		memberService.print();
		System.out.println("2.memberService야:번호 1번 AcademyMember 1명 반환해줘");
		System.out.println("3.memberService야:이름 KIM AcademyMember  들 반환해줘");
		
		System.out.println("4.memberService야:AcademyStudent들 반환해줘");
		AcademyMember[] findMembers=memberService.findAcademyMembers(AcademyMember.MEMBER_STUDENT);
		for (int i = 0; i < findMembers.length; i++) {
			findMembers[i].print();
			
		}
		System.out.println("5.memberService야:AcademyStaff  들 반환해줘");
		findMembers=memberService.findAcademyMembers(AcademyMember.MEMBER_STAFF);
		for (int i = 0; i < findMembers.length; i++) {
			findMembers[i].print();
			
		}
		System.out.println("6.memberService야:AcademyGangsa 들 반환해줘");
		findMembers=memberService.findAcademyMembers(AcademyMember.MEMBER_GANGSA);
		for (int i = 0; i < findMembers.length; i++) {
			findMembers[i].print();
			
		}
		System.out.println("7.memberService야:반  이름으로 검색후 AcademyStudent들 반환해줘");
		/*   
		 * DTO(Data Transfer Object)
		 */  
		AcademyStudent studentDTO=new AcademyStudent(-999, null, "JAVA");
		memberService
			.findByChildMember1(studentDTO);
		memberService
			.findByChildMember2(
					AcademyMember.MEMBER_STUDENT, "JAVA");
		
		System.out.println("8.memberService야:부서이름으로 검색후 AcademyStaff  들 반환해줘");
		memberService
		.findByChildMember1(new AcademyStaff(-999, null, "홍보"));
		memberService
		.findByChildMember2(
				AcademyMember.MEMBER_STAFF, "홍보");
		
		System.out.println("9.memberService야:과목이름으로 검색후 AcademyGansa  들 반환해줘");
		memberService
		.findByChildMember1(
				new AcademyGangsa(-999, null, "DESIGN"));
		memberService
		.findByChildMember2(
				AcademyMember.MEMBER_GANGSA, "DESIGN");
		
		
		
		
		
		
	}

}
