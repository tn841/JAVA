package com.itwill04.student.array;
public class StudentArrayMain {
	public static void main(String[] args) {
		/*
		 1.�л��迭Ÿ�� �������� �ʱ�ȭ 10��
		 2.�л���ü�� ����,���,����,���� ���
		 3.�л���ü���� ��ü���
		 4.�л���ȣ 1���л� 1�����
		 5.�л��̸� KIM �� �л��� ���
		 6.�л����� A �� �л��� ���
		 7.�л��������� 60�������� �л��� ���
		 8.�л����������� ������(A B C D F) ���
		 9.�л��̸������� ������(��������) �����
		 */
		
		//1. �ʱ�ȭ 10��
		Student[] students = {
				new Student(1, "KIM", 80, 87, 92),
				new Student(2, "AIM", 70, 7, 95),
				new Student(3, "KDM", 86, 10, 42),
				new Student(4, "KIM", 45, 86, 82),
				new Student(5, "LEE", 48, 82, 62),
				new Student(6, "EIM", 98, 97, 98),
				new Student(7, "ZAA", 26, 99, 69),
				new Student(8, "GIM", 47, 12, 25),
				new Student(9, "KIM", 48, 100, 37),
				new Student(10, "IIM", 58, 87, 88)
			};
		
		//2. �л���ü�� ����, ���, ����, ���� ���
		for (int i = 0; i < students.length; i++) {
			students[i].calculateAll();
		}//����, ���, ���� ���
		

		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getTot() <+ students[j].getTot()){
					int temp =students[i].getRank();
					students[i].setRank(++temp);
				}
			}
		}//���� ���
		
		
		
		//3. ��ü ���� ���
		System.out.println("3. ��ü ���� ���");
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		Student.footerPrint();
		System.out.println();
		
		//4.�л���ȣ 1���л� 1�����
		System.out.println("4.�л���ȣ 1���л� 1�����");
		for (int i = 0;  i < students.length; i++) {
			if(students[i].getNo() == 1){
				students[i].print();
				break;
			}
		}
		System.out.println();
	
		
		
		//5.�л��̸� KIM �� �л��� ���
		System.out.println("5.�л��̸� KIM �� �л��� ���");
		for (int i = 0; i < students.length; i++) {
			if(students[i].getName().equals("KIM")){
				students[i].print();
			}
		}
		System.out.println();
		
		//6.�л����� A �� �л��� ���
		System.out.println("6.�л����� A �� �л��� ���");
		for (int i = 0; i < students.length; i++) {
			if(students[i].getGrade() == 'A'){
				students[i].print();
			}
		}
		System.out.println();
		
		
		//7.�л��������� 60�������� �л��� ���
		System.out.println("7. �л��������� 60�������� �л��� ���");
		for (int i = 0; i < students.length; i++) {
			if(students[i].getKor() <= 60){
				students[i].print();
			}
		}
		System.out.println();
		
		
		//8.�л����������� ������(A B C D F) ���		
		System.out.println("8.�л����������� ������(A B C D F) ���");
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getGrade() < students[j].getGrade()){
					Student temp;
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
				
				//���������� ������ �� ������ ó�� ���� (�л���ȣ�� 2�� ��������)
				if(students[i].getGrade() == students[j].getGrade()   && students[i].getNo() < students[j].getNo()){
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
		
		

		
		
		//��� Ȯ��
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		Student.footerPrint();
		System.out.println();
		
		//9.�л��̸������� ������(��������) �����
		System.out.println("9.�л��̸������� ������(��������) �����");
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getName().compareTo(students[j].getName())<0){
					Student temp;
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
				//�̸������� ������ �� ������ ó�� ���� (�л���ȣ�� 2�� ��������)
				if(students[i].getName().compareTo(students[j].getName()) == 0   && students[i].getNo() < students[j].getNo()){
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
		//��� Ȯ��
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		Student.footerPrint();
		System.out.println();
		
		
	}//����

}
