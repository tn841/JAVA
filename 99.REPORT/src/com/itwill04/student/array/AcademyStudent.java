package com.itwill04.student.array;

public class AcademyStudent extends AcademyMember {	//Student is a Member.
	public String clazz; // 반

	public AcademyStudent() {
	
	}

	public AcademyStudent(int no, String name, String clazz) {
		super(no, name);
		this.clazz = clazz;
	}

	/* 부모가 가지고 있는 print()메소드
	 public void print(){
	 	System.out.print(no+"\t"+name+"\t");
	 }	
	 */
	@Override
	public void print(){
		//this.print();	//자기 자신을 참조하게된다.. 여기서는 오버라이딩에 의해 감춰진 부모 클래스의 메소드를 불러야한다. -> super 키워드 이용
		super.print();	//super : self 참조변수 (재정의 되어서 은폐된 부모클래스의 메소드 접근시 사용)
		System.out.println(clazz);
//		System.out.println("this.toString = "+this.toString());
//		System.out.println("super.toString = "+super.toString());	//? 주소 값이 같은 이유?
		
	}
	
	
	//getter, setter
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
