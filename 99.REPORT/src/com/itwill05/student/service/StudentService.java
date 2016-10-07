package com.itwill05.student.service;

public class StudentService {
	public static final int SORT_GRADE=1;
	public static final int SORT_NO=2;
	public static final int SORT_NAME=3;
	
	private Student[] studentArray;
	private int sizeOfArr;	//배열의 크기를 갖고 있는 변수
	public StudentService() {
		studentArray =new Student[15];
		sizeOfArr=15;
	}
	public StudentService(int number) {
		studentArray =new Student[number];
		sizeOfArr = number;
	}
	
//	 1.학생객체받아서 학생배열에추가
//	 2.모든학생객체의 총점,평균,평점,석차 계산
//	 3.모든학생객체정보 전체출력
//	 4.학생번호 1번학생 1명반환해줘
//	 5.학생이름 KIM 인 학생들 반환
//	 6.학생학점 A 인 학생들 반환
//	 7.학생국어점수 60점이하인 학생들 반환
//	 8.학생학점순으로 정렬(A B C D F) 해줘
//	 9.학생번호순으로 정렬(오름차순) 해줘
//	 10.학생이름순으로 정렬후(오름차순) 해줘
	 
	/*
	 1.학생객체받아서 학생배열에추가 
	 */
	public void addStudent(Student addStudent){
		if(!this.isFull()){	//
			Student[] sArr = new Student[studentArray.length+1];	//사이즈가 하나 더 큰 배열 생성
			for (int i = 0; i < studentArray.length; i++) {
				sArr[i] = studentArray[i];	//복사
			}
			sArr[studentArray.length] = addStudent;
			studentArray = sArr;
		}
	}
	
	private boolean isFull(){	//Student배열이 가득 찼는지 판단하는 메소드 (가득 찼으면 true, 빈공간이 있으면 false)
		boolean flag= true;
		
		for (int i = 0; i < studentArray.length; i++) {
			if(studentArray[i] != null){
				flag = false;
				break;
			}
		}
		
		return flag;
	}
//	 2.모든학생객체의 총점,평균,평점,석차 계산
//	 3.모든학생객체정보 전체출력
//	 4.학생번호 1번학생 1명반환해줘
//	 5.학생이름 KIM 인 학생들 반환
//	 6.학생학점 A 인 학생들 반환
//	 7.학생국어점수 60점이하인 학생들 반환
	/*
	 8.학생학점순으로 정렬(A B C D F) 해줘
	 9.학생번호순으로 정렬(오름차순) 해줘
	 10.학생이름순으로 정렬후(오름차순) 해줘 
	 */
	public void sort(int type){
		switch (type) {
		case StudentService.SORT_GRADE:
			//학점순으로정렬
			break;

		case StudentService.SORT_NO:
			//번호순으로정렬
			break;
		case StudentService.SORT_NAME:
			//이름순으로정렬
			break;
		}
	}//sort(int type)
	
	public void print(){
		for (int i = 0; i < studentArray.length; i++) {
			if(studentArray[i] != null){
				studentArray[i].print();
			}
		}
	}
	
	
}
