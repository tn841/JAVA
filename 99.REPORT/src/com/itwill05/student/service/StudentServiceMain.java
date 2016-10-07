package com.itwill05.student.service;
public class StudentServiceMain {
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
		
		
//		 1.학생줄께 추가해줘
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
//		 2.모든학생객체의 총점,평균,평점,석차 계산
//		 3.모든학생객체정보 전체출력
//		 4.학생번호 1번학생 1명반환해줘
//		 5.학생이름 KIM 인 학생들 반환
//		 6.학생학점 A 인 학생들 반환
//		 7.학생국어점수 60점이하인 학생들 반환
//		 8.학생학점순으로 정렬(A B C D F) 해줘
//		 9.학생번호순으로 정렬(오름차순) 해줘
//		 10.학생이름순으로 정렬후(오름차순) 해줘
		 
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
