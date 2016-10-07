package com.itwill98.student.generic;

public class AcademyStaff extends AcademyMember {
	public String depart; // ºÎ¼­

	public AcademyStaff() {
	}

	public AcademyStaff(int no, String name, String depart) {
		super(no, name);
		this.depart = depart;
	}
	
	@Override
	public void print(){
		super.print();
		System.out.println(depart);
	}
	
	//getter, setter
	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

}
