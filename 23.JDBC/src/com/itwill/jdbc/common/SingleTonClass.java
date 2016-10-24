package com.itwill.jdbc.common;
/*	<< Singleton pattern >>
 * 단 하나의 객체만 생성되고 사용할 수 있도록 설계
 */
public class SingleTonClass {
	private static SingleTonClass _instance = null;
	
	
	public static SingleTonClass getInstance(){
		if(_instance == null){
			_instance = new SingleTonClass();
		}
		return _instance;
	}
	
	private SingleTonClass(){
		System.out.println("SingleTonClass() 생성자");
	}
}
