package com.itwill.jdbc.common;
/*	<< Singleton pattern >>
 * �� �ϳ��� ��ü�� �����ǰ� ����� �� �ֵ��� ����
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
		System.out.println("SingleTonClass() ������");
	}
}
