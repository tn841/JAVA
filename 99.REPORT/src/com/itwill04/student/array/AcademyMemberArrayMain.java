package com.itwill04.student.array;

public class AcademyMemberArrayMain {

	public static void main(String[] args) {
		AcademyMember[] members={
				new AcademyStudent(1, "KIM", "IOT"),
				new AcademyStudent(2, "HIM", "OFFICE"),
				new AcademyStudent(3, "GIM", "JAVA"),
				new AcademyGangsa(4, "YONG", "LINUX"),
				new AcademyGangsa(5, "TONG", "DESIGN"),
				new AcademyStaff(6, "KANG", "교육"),
				new AcademyStaff(7, "SANG", "홍보")	
		};
		System.out.println("1.AcademyMember전체출력");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			members[i].print();
		}
		AcademyMember.footerPrint();
		
		System.out.println("2.번호 1번 AcademyMember 1 명 출력");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if(members[i].getNo() == 1){
				members[i].print();
				break;
			}
		}
		AcademyMember.footerPrint();
		
		System.out.println("3.이름 KIM AcademyMember 들   출력");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if(members[i].getName().startsWith("KIM")){
				members[i].print();
			}
		}
		AcademyMember.footerPrint();
		
		System.out.println("4.AcademyStudent 들만출력");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if(members[i] instanceof AcademyStudent){
				members[i].print();
			}
		}
		AcademyMember.footerPrint();
		
		System.out.println("5.반 JAVA인 AcademyStudent 들만출력");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if( members[i] instanceof AcademyStudent  ){		//조건1, AcademyStudent 객체인가?
				AcademyStudent tempSt = (AcademyStudent)members[i];	//참조변수 형변환
				if(tempSt.getClazz().equals("JAVA")){			//조건2, 반이 "JAVA"인가?
					members[i].print();
				}
			}
		
		}
		AcademyMember.footerPrint();
		
		
		
	}

}
