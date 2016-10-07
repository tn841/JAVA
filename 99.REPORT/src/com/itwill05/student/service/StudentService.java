package com.itwill05.student.service;

public class StudentService {
	public static final int SORT_GRADE=1;
	public static final int SORT_NO=2;
	public static final int SORT_NAME=3;
	
	private Student[] studentArray;
	private int sizeOfArr;	//�迭�� ũ�⸦ ���� �ִ� ����
	public StudentService() {
		studentArray =new Student[15];
		sizeOfArr=15;
	}
	public StudentService(int number) {
		studentArray =new Student[number];
		sizeOfArr = number;
	}
	
//	 1.�л���ü�޾Ƽ� �л��迭���߰�
//	 2.����л���ü�� ����,���,����,���� ���
//	 3.����л���ü���� ��ü���
//	 4.�л���ȣ 1���л� 1���ȯ����
//	 5.�л��̸� KIM �� �л��� ��ȯ
//	 6.�л����� A �� �л��� ��ȯ
//	 7.�л��������� 60�������� �л��� ��ȯ
//	 8.�л����������� ����(A B C D F) ����
//	 9.�л���ȣ������ ����(��������) ����
//	 10.�л��̸������� ������(��������) ����
	 
	/*
	 1.�л���ü�޾Ƽ� �л��迭���߰� 
	 */
	public void addStudent(Student addStudent){
		if(!this.isFull()){	//
			Student[] sArr = new Student[studentArray.length+1];	//����� �ϳ� �� ū �迭 ����
			for (int i = 0; i < studentArray.length; i++) {
				sArr[i] = studentArray[i];	//����
			}
			sArr[studentArray.length] = addStudent;
			studentArray = sArr;
		}
	}
	
	private boolean isFull(){	//Student�迭�� ���� á���� �Ǵ��ϴ� �޼ҵ� (���� á���� true, ������� ������ false)
		boolean flag= true;
		
		for (int i = 0; i < studentArray.length; i++) {
			if(studentArray[i] != null){
				flag = false;
				break;
			}
		}
		
		return flag;
	}
//	 2.����л���ü�� ����,���,����,���� ���
//	 3.����л���ü���� ��ü���
//	 4.�л���ȣ 1���л� 1���ȯ����
//	 5.�л��̸� KIM �� �л��� ��ȯ
//	 6.�л����� A �� �л��� ��ȯ
//	 7.�л��������� 60�������� �л��� ��ȯ
	/*
	 8.�л����������� ����(A B C D F) ����
	 9.�л���ȣ������ ����(��������) ����
	 10.�л��̸������� ������(��������) ���� 
	 */
	public void sort(int type){
		switch (type) {
		case StudentService.SORT_GRADE:
			//��������������
			break;

		case StudentService.SORT_NO:
			//��ȣ����������
			break;
		case StudentService.SORT_NAME:
			//�̸�����������
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
