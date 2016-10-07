package com.itwill99.student.service;

public class AcademyGangsa  extends AcademyMember{
	
	public String subject;//°ú¸ñ
	
	public AcademyGangsa() {
		
	}
	public AcademyGangsa(int no,String name,String subject){
		super(no, name);
		this.subject=subject;
	}
	/*
	public void print(){
		System.out.println(no+"\t"+name);
	} 
	*/
	public void print(){
		super.print();
		System.out.println(subject);
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
