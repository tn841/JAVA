package com.itwill01.student.member_variable;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * 1. 학생class타입 변수선언(2개)
		 * 2. 학생객체 생성 후 변수 대입
		 * 3. 학생객체에 데이터입력 (번호, 이름, 국어, 영어, 수학)
		 * 4. 학생객체에 데이터입력 (총점, 평균, 평점)
		 * 5. 정보출력
		 */
		
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.no = 1;
		s1.name = "가나다";
		s1.kor = 97;
		s1.eng = 90;
		s1.math = 88;
		s1.total = s1.kor + s1.eng + s1.math;
		double temp = s1.total/3.0;
		s1.avg = (int) (temp*100+0.5)/100.0;
		s1.grad = 'A';
		
		
		s2.no = 2;
		s2.name = "라마바";
		s2.kor = 95;
		s2.eng = 80;
		s2.math = 83;
		s2.total = s2.kor + s2.eng + s2.math;
		temp = s2.total/3.0;
		s2.avg = (int) (temp*100+0.5)/100.0;
		s2.grad = 'B';
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t평점");
		System.out.println(s1.no+"\t"+s1.name+"\t"+s1.kor+"\t"+s1.eng+"\t"+s1.math+"\t"+s1.total+"\t"+s1.avg+"\t"+s1.grad);
		System.out.println(s2.no+"\t"+s2.name+"\t"+s2.kor+"\t"+s2.eng+"\t"+s2.math+"\t"+s2.total+"\t"+s2.avg+"\t"+s2.grad);
		System.out.println("-------------------------------------------------------------");
	}

}
