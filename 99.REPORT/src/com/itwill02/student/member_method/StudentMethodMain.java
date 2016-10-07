package com.itwill02.student.member_method;

public class StudentMethodMain {

	public static void main(String[] args) {
		/*
		 * 1. 학생class타입 변수선언(2개)
		 * 2. 학생객체 생성 후 변수 대입
		 * 3. 학생객체에 신상데이터입력
		 * 4. 학생객체에 점수데이터입력
		 * 5. 학생객체에 총점, 평균, 평점 계산
		 * 6. 학생객체 정보 출력
		 */
		
		
		//1. 2.
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.personData(1, "김자바");	//3.
		s1.scoreData(96, 98, 88);	//4.
		s1.calcAll();				//5.
		
		
		s2.personData(2, "이자바");
		s2.scoreData(74, 92, 85);
		s2.calcAll();
		
		
		s3.personData(3, "박자바");
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
