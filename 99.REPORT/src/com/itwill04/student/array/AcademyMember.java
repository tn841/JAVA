package com.itwill04.student.array;

public class AcademyMember {
	private int no;
	private String name;
	
	public AcademyMember() {
		// TODO Auto-generated constructor stub
	}

	public AcademyMember(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public void print(){	//�л�, ����, ������ ������ ���� ���ϴ� �ణ ������ �޼ҵ�, ���� �ڽ� Ŭ�������� �ش� �޼ҵ带 �������Ͽ� ������ ������ ä���ش�.
		System.out.print(no+"\t"+name+"\t");
	}
	
	public static void headerPrint(){
		System.out.println("--------------------------------");
		System.out.println("��ȣ"+"\t"+"�̸�"+"\t"+"����");
		System.out.println("--------------------------------");
	}
	public static void footerPrint(){
		System.out.println("--------------------------------\n\n");
	}
	
	//getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}