package com.itwill.Collection;

public class Generics<T> {	//generics <T>�� �������ش�.. (TŸ��) 
	private T member;

	public void setMember(T member){
		this.member = member;
	}
	
	public T getMember(){
		return this.member;
	}
	
	
}
