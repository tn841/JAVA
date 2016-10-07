package com.itwill.cafe.member;

import java.io.Serializable;

/* 성빈
 * VO(Value Object), DTO(Data Transfer object)
 * 	- 멤버 1명의 데이터를 가지고 있는 객체
 * 	- 파일 1개 레코드, DB 테이블의 한개 row의 정보를 가지는 객체
 */
public class MemberVO implements Serializable{
	/*
	 * 회원 번호는 중복되지 않아야하는 필드
	 * 자동으로 생성됨
	 */
	private int no;			     //고유번호	
	private String id;		     //아이디
	private String name;	     //이름
	private String password;     //비번
	private boolean	isLogin;     //로그인 상태
	private String email;	     //이메일
	private int age;		     //연령대
	private int auth;		     //권한
	private int postCount;	     //쓴 글의 갯수
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
