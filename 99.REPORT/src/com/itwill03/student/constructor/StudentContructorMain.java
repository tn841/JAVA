package com.itwill03.student.constructor;

public class StudentContructorMain {

	public static void main(String[] args) {
		/*
		 * 1. �л�classŸ�� ��������(3��)
		 * 2. �л���ü ������ �� no, �̸�, ��������, ��������, ���������� �Է¹޴´�. 
		 * 	  ���� �����ڰ� �����Ǹ鼭 ����, ���, ���� ������ �̷������. 
		 * 
		 * 3. �л���ü ���� ���
		 */
		
		//�Ϻ� �����͸� �ʱ�ȭ�� �Է°����ϴ�...(����, ���, ������ ����ؾ���)
		Student s1 = new Student(1, "���ڹ�", 96, 94, 90);
		Student s2 = new Student(2, "���ڹ�", 86, 82, 79);
		Student s3 = new Student(3, "���ڹ�", 86, 78, 67);
		
		Student.headerPrint();
		s1.print();
		s2.print();
		s3.print();
		Student.footerPrint();
	}

}
