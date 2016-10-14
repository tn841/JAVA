package com.itwill.member;

import java.io.Serializable;

/*
  VO(Value Object),DTO(Data Transfer Object)
  - 멤버 1명의 데이를 가지고있는객체
  - 파일1개레코드, DB 테이블의 한개 row의 정보를 가지는객체
 */
public class Member implements Serializable{
	/*
	 * - 중복되지않아야하는필드
	 * - 자동으로 생성
	 */
	private int no;
	/*
	 * - 중복되지않아야하는필드
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
