package com.itwill99.student.service;

public class AcademyStudent extends AcademyMember{
	
	public String ban;//��
	public AcademyStudent() {
	}
	public AcademyStudent(int no, String name, String ban) {
		/*
		super();
		this.setNo(no);
		this.setName(name);
		*/
		super(no, name);
		this.ban = ban;
	}
	/*
	public void print(){
		System.out.println(no+"\t"+name);
	}
	*/
	public void print(){
		/*
		 * super : self ��������(�����ǵǾ ����ȸ޽�����ٽ� ���)
		 */
		super.print();
		
		System.out.println(ban);
		//System.out.println("super:"+super.toString());
		//System.out.println("this:"+this.toString());
	}
	

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	
}
