package com.itwill.Collection;

public class Generics<T> {	//generics <T>를 선언해준다.. (T타입) 
	private T member;

	public void setMember(T member){
		this.member = member;
	}
	
	public T getMember(){
		return this.member;
	}
	
	
}
