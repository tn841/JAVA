package com.itwill99.student.service;

public class AcademyMember extends Object{
	public final static int MEMBER_STUDENT=0;
	public final static int MEMBER_STAFF=1;
	public final static int MEMBER_GANGSA=2;
	
	private int no;
	private String name;
	
	public AcademyMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcademyMember(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public void print(){
		System.out.print(no+"\t"+name+"\t");
	}
	
	
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
