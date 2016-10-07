package com.itwill99.student.service;

public class AcademyOperator extends AcademyMember{
	private String technic;//±â¼ú
	public AcademyOperator() {
		// TODO Auto-generated constructor stub
	}
	
	public AcademyOperator(int no,String name,String technic) {
		super(no,name);
		this.technic = technic;
	}

	public String getTechnic() {
		return technic;
	}
	public void setTechnic(String technic) {
		this.technic = technic;
	}
	@Override
	public void print() {
		super.print();
		System.out.println(technic);
	}
	

}
