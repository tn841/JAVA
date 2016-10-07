package com.itwill04.student.array;

public class AcademyStudent extends AcademyMember {	//Student is a Member.
	public String clazz; // ��

	public AcademyStudent() {
	
	}

	public AcademyStudent(int no, String name, String clazz) {
		super(no, name);
		this.clazz = clazz;
	}

	/* �θ� ������ �ִ� print()�޼ҵ�
	 public void print(){
	 	System.out.print(no+"\t"+name+"\t");
	 }	
	 */
	@Override
	public void print(){
		//this.print();	//�ڱ� �ڽ��� �����ϰԵȴ�.. ���⼭�� �������̵��� ���� ������ �θ� Ŭ������ �޼ҵ带 �ҷ����Ѵ�. -> super Ű���� �̿�
		super.print();	//super : self �������� (������ �Ǿ ����� �θ�Ŭ������ �޼ҵ� ���ٽ� ���)
		System.out.println(clazz);
//		System.out.println("this.toString = "+this.toString());
//		System.out.println("super.toString = "+super.toString());	//? �ּ� ���� ���� ����?
		
	}
	
	
	//getter, setter
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
