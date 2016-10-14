package com.itwill.member;

import java.io.Serializable;

/*
  VO(Value Object),DTO(Data Transfer Object)
  - ��� 1���� ���̸� �������ִ°�ü
  - ����1�����ڵ�, DB ���̺��� �Ѱ� row�� ������ �����°�ü
 */
public class Member implements Serializable{
	/*
	 * - �ߺ������ʾƾ��ϴ��ʵ�
	 * - �ڵ����� ����
	 */
	private int no;
	/*
	 * - �ߺ������ʾƾ��ϴ��ʵ�
	 */
	private String id;
	private String password;
	private String name;
	private String address;
	private int age;
	private boolean married;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(int no, String id, String password, String name, String address, int age, boolean married) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.age = age;
		this.married = married;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	@Override
	public String toString() {
		
		return no+"\t"+id+"\t"+password+"\t"+name+"\t"+address+"\t"+age+"\t"+married;
	}
	
	public boolean matchPassword(String password){
		if(this.password.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
}
