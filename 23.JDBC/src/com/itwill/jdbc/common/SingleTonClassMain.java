package com.itwill.jdbc.common;

public class SingleTonClassMain {

	public static void main(String[] args) {
		SingleTonClass stc = SingleTonClass.getInstance();
		System.out.println(stc);
		System.out.println(SingleTonClass.getInstance());
		System.out.println(SingleTonClass.getInstance());
		System.out.println(SingleTonClass.getInstance());
		System.out.println(SingleTonClass.getInstance());
		System.out.println(SingleTonClass.getInstance());

	}

}
