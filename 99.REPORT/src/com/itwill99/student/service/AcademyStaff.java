package com.itwill99.student.service;

public class AcademyStaff extends AcademyMember{
	
	public String depart;//ºÎ¼­
	public AcademyStaff() {
		
	}
	public AcademyStaff(int no,String name,String depart){
		super(no, name);
		this.depart=depart;
	}
	/*
	public void print(){
		System.out.print(no+"\t"+name);
	} 
	*/
	public void print(){
		super.print();
		System.out.println(depart);
	}
	
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	
	
}
