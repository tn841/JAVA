package com.itwill98.student.generic;

public class AcademyMember<T> {
	private int no;
	private String name;
	private T value;
	
	public AcademyMember() {
		// TODO Auto-generated constructor stub
	}

	public AcademyMember(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	public AcademyMember(int no, String name, T value){
		this.no = no;
		this.name = name;
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void print(){	//�л�, ����, ������ ������ ���� ���ϴ� �ణ ������ �޼ҵ�, ���� �ڽ� Ŭ�������� �ش� �޼ҵ带 �������Ͽ� ������ ������ ä���ش�.
		System.out.print(no+"\t"+name+"\t");
		
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
