package com.itwill03.student.constructor;

public class StudentContructorMain {

	public static void main(String[] args) {
		/*
		 * 1. 학생class타입 변수선언(3개)
		 * 2. 학생객체 생성할 때 no, 이름, 국어점수, 영어점수, 수학점수를 입력받는다. 
		 * 	  또한 생성자가 생성되면서 총점, 평균, 평점 계산까지 이루어진다. 
		 * 
		 * 3. 학생객체 정보 출력
		 */
		
		//일부 데이터만 초기화시 입력가능하다...(총점, 평균, 평점은 계산해야함)
		Student s1 = new Student(1, "김자바", 96, 94, 90);
		Student s2 = new Student(2, "이자바", 86, 82, 79);
		Student s3 = new Student(3, "박자바", 86, 78, 67);
		
		Student.headerPrint();
		s1.print();
		s2.print();
		s3.print();
		Student.footerPrint();
	}

}
