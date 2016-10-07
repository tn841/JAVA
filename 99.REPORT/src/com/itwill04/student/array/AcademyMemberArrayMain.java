package com.itwill04.student.array;

public class AcademyMemberArrayMain {

	public static void main(String[] args) {
		AcademyMember[] members={
				new AcademyStudent(1, "KIM", "IOT"),
				new AcademyStudent(2, "HIM", "OFFICE"),
				new AcademyStudent(3, "GIM", "JAVA"),
				new AcademyGangsa(4, "YONG", "LINUX"),
				new AcademyGangsa(5, "TONG", "DESIGN"),
				new AcademyStaff(6, "KANG", "����"),
				new AcademyStaff(7, "SANG", "ȫ��")	
		};
		System.out.println("1.AcademyMember��ü���");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			members[i].print();
		}
		AcademyMember.footerPrint();
		
		System.out.println("2.��ȣ 1�� AcademyMember 1 �� ���");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if(members[i].getNo() == 1){
				members[i].print();
				break;
			}
		}
		AcademyMember.footerPrint();
		
		System.out.println("3.�̸� KIM AcademyMember ��   ���");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if(members[i].getName().startsWith("KIM")){
				members[i].print();
			}
		}
		AcademyMember.footerPrint();
		
		System.out.println("4.AcademyStudent �鸸���");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if(members[i] instanceof AcademyStudent){
				members[i].print();
			}
		}
		AcademyMember.footerPrint();
		
		System.out.println("5.�� JAVA�� AcademyStudent �鸸���");
		AcademyMember.headerPrint();
		for (int i = 0; i < members.length; i++) {
			if( members[i] instanceof AcademyStudent  ){		//����1, AcademyStudent ��ü�ΰ�?
				AcademyStudent tempSt = (AcademyStudent)members[i];	//�������� ����ȯ
				if(tempSt.getClazz().equals("JAVA")){			//����2, ���� "JAVA"�ΰ�?
					members[i].print();
				}
			}
		
		}
		AcademyMember.footerPrint();
		
		
		
	}

}
