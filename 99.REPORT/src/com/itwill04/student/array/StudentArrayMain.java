package com.itwill04.student.array;
public class StudentArrayMain {
	public static void main(String[] args) {
		/*
		 1.학생배열타입 변수선언 초기화 10명
		 2.학생객체의 총점,평균,평점,석차 계산
		 3.학생객체정보 전체출력
		 4.학생번호 1번학생 1명출력
		 5.학생이름 KIM 인 학생들 출력
		 6.학생학점 A 인 학생들 출력
		 7.학생국어점수 60점이하인 학생들 출력
		 8.학생학점순으로 정렬후(A B C D F) 출력
		 9.학생이름순으로 정렬후(오름차순) 후출력
		 */
		
		//1. 초기화 10명
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
		
		//2. 학생객체의 총점, 평균, 평점, 석차 계산
		for (int i = 0; i < students.length; i++) {
			students[i].calculateAll();
		}//총점, 평균, 평점 계산
		

		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getTot() <+ students[j].getTot()){
					int temp =students[i].getRank();
					students[i].setRank(++temp);
				}
			}
		}//석차 계산
		
		
		
		//3. 전체 정보 출력
		System.out.println("3. 전체 정보 출력");
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		Student.footerPrint();
		System.out.println();
		
		//4.학생번호 1번학생 1명출력
		System.out.println("4.학생번호 1번학생 1명출력");
		for (int i = 0;  i < students.length; i++) {
			if(students[i].getNo() == 1){
				students[i].print();
				break;
			}
		}
		System.out.println();
	
		
		
		//5.학생이름 KIM 인 학생들 출력
		System.out.println("5.학생이름 KIM 인 학생들 출력");
		for (int i = 0; i < students.length; i++) {
			if(students[i].getName().equals("KIM")){
				students[i].print();
			}
		}
		System.out.println();
		
		//6.학생학점 A 인 학생들 출력
		System.out.println("6.학생학점 A 인 학생들 출력");
		for (int i = 0; i < students.length; i++) {
			if(students[i].getGrade() == 'A'){
				students[i].print();
			}
		}
		System.out.println();
		
		
		//7.학생국어점수 60점이하인 학생들 출력
		System.out.println("7. 학생국어점수 60점이하인 학생들 출력");
		for (int i = 0; i < students.length; i++) {
			if(students[i].getKor() <= 60){
				students[i].print();
			}
		}
		System.out.println();
		
		
		//8.학생학점순으로 정렬후(A B C D F) 출력		
		System.out.println("8.학생학점순으로 정렬후(A B C D F) 출력");
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getGrade() < students[j].getGrade()){
					Student temp;
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
				
				//평점순으로 정렬한 뒤 동점차 처리 로직 (학생번호를 2차 기준으로)
				if(students[i].getGrade() == students[j].getGrade()   && students[i].getNo() < students[j].getNo()){
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
		
		

		
		
		//출력 확인
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		Student.footerPrint();
		System.out.println();
		
		//9.학생이름순으로 정렬후(오름차순) 후출력
		System.out.println("9.학생이름순으로 정렬후(오름차순) 후출력");
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[i].getName().compareTo(students[j].getName())<0){
					Student temp;
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
				//이름순으로 정렬한 뒤 동점차 처리 로직 (학생번호를 2차 기준으로)
				if(students[i].getName().compareTo(students[j].getName()) == 0   && students[i].getNo() < students[j].getNo()){
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
		//출력 확인
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		Student.footerPrint();
		System.out.println();
		
		
	}//메인

}
