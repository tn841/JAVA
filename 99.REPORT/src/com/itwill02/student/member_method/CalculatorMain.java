package com.itwill02.student.member_method;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		/*
		 * ���� 2���� ���� ��Ģ����
		 */
		
		int addResult = calc.add(123,456);
		int subResult = calc.sub(1234,456);
		int multiResult = calc.multi(123,456);
		int divResult = calc.div(329300,56);
		
		System.out.println("calc.add(123,456) = "+addResult);
		System.out.println("calc.sub(1234,456) = "+subResult);
		System.out.println("calc.multi(123,456) = "+multiResult);
		System.out.println("calc.div(329300,56) = "+divResult);
	}

}
