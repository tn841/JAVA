package com.itwill02.student.member_method;

public class StudentMethodMain {

	public static void main(String[] args) {
		/*
		 * 1. �л�classŸ�� ��������(2��)
		 * 2. �л���ü ���� �� ���� ����
		 * 3. �л���ü�� �Ż������Է�
		 * 4. �л���ü�� �����������Է�
		 * 5. �л���ü�� ����, ���, ���� ���
		 * 6. �л���ü ���� ���
		 */
		
		
		//1. 2.
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.personData(1, "���ڹ�");	//3.
		s1.scoreData(96, 98, 88);	//4.
		s1.calcAll();				//5.
		
		
		s2.personData(2, "���ڹ�");
		s2.scoreData(74, 92, 85);
		s2.calcAll();
		
		
		s3.personData(3, "���ڹ�");
		s3.scoreData(74, 62, 45);
		s3.calcAll();
		
		//6.
		Student.headerPrint();
		s1.print();
		s2.print();
		s3.print();
		Student.footerPrint();
	}

}
