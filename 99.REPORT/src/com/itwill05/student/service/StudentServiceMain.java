package com.itwill05.student.service;
public class StudentServiceMain {
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
		
		
//		 1.�л��ٲ� �߰�����
		studentService.addStudent(new Student(1, "KIM", 34, 23, 90));
		studentService.addStudent(new Student(3, "GIM", 66, 88, 66));
		studentService.addStudent(new Student(4, "CIM", 88, 91, 99));
		studentService.addStudent(new Student(6, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(5, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(15, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(14, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(13, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(7, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(8, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(9, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(10, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(11, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(12, "JIM", 45, 44, 34));
		
		studentService.print();
//		 2.����л���ü�� ����,���,����,���� ���
//		 3.����л���ü���� ��ü���
//		 4.�л���ȣ 1���л� 1���ȯ����
//		 5.�л��̸� KIM �� �л��� ��ȯ
//		 6.�л����� A �� �л��� ��ȯ
//		 7.�л��������� 60�������� �л��� ��ȯ
//		 8.�л����������� ����(A B C D F) ����
//		 9.�л���ȣ������ ����(��������) ����
//		 10.�л��̸������� ������(��������) ����
		 
		/*
		studentService.addStudent(new Student(1, "KIM", 34, 23, 90));
		studentService.addStudent(new Student(3, "GIM", 66, 88, 66));
		studentService.addStudent(new Student(4, "CIM", 88, 91, 99));
		studentService.addStudent(new Student(6, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(5, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(15, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(14, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(13, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(7, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(8, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(9, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(10, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(11, "JIM", 45, 44, 34));
		studentService.addStudent(new Student(12, "JIM", 45, 44, 34));
		*/
		
		studentService.sort(StudentService.SORT_GRADE);
		studentService.sort(StudentService.SORT_NO);
		studentService.sort(StudentService.SORT_NAME);
	}

}
