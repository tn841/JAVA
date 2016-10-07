package com.itwill.cafe.member;

import java.io.Serializable;

/* ����
 * VO(Value Object), DTO(Data Transfer object)
 * 	- ��� 1���� �����͸� ������ �ִ� ��ü
 * 	- ���� 1�� ���ڵ�, DB ���̺��� �Ѱ� row�� ������ ������ ��ü
 */
public class MemberVO implements Serializable{
	/*
	 * ȸ�� ��ȣ�� �ߺ����� �ʾƾ��ϴ� �ʵ�
	 * �ڵ����� ������
	 */
	private int no;			     //������ȣ	
	private String id;		     //���̵�
	private String name;	     //�̸�
	private String password;     //���
	private boolean	isLogin;     //�α��� ����
	private String email;	     //�̸���
	private int age;		     //���ɴ�
	private int auth;		     //����
	private int postCount;	     //�� ���� ����
	private int birth;                             
	public MemberVO() {
		
	}

	public MemberVO(int no, String id, String name, String password, boolean isLogin, String email, int age, int auth,
			int postCount, int birth) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.password = password;
		this.isLogin = isLogin;
		this.email = email;
		this.age = age;
		this.auth = auth;
		this.postCount = postCount;
		this.birth=birth;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	
	@Override
	public String toString() {
		return no+"\t"+id+"\t"+name+"\t"+password+"\t"+isLogin+"\t"+email+"\t"+age+"\t"+auth+"\t"+postCount+"\t"+birth;
	}
	
	public boolean matchPassword(String password){
		if(this.password.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean matchEMail(String eMail){
		if(this.email.equals(eMail)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean matchbirth(int birth){
		if(this.birth==birth){
			return true;
		}else{
			return false;
		}
	}
	
}
