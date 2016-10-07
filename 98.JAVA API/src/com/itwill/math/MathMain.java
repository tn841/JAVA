package com.itwill.math;

public class MathMain {

	public static void main(String[] args) {
		//Math math=new Math();
		System.out.println(Math.E);
		System.out.println(Math.PI);
		System.out.println("반올림:"+Math.round(235.578));
		System.out.println(Math.abs(-900));
		System.out.println(Math.max(34, 78));
		System.out.println(Math.min(34, 78));
		System.out.println(Math.sqrt(2));
		System.out.println(Math.floor(23.568));
		/*
		 Returns the largest (closest to positive infinity) double value 
		 that is less than or equal to the argument and is equal to a mathematical integer. Special cases:  
		 */
		System.out.println(Math.floor(-23.568));
		System.out.println(Math.ceil(23.345));
		System.out.println(Math.ceil(-23.345));
		
		System.out.println("------Math.random()------");
		/*
		 public static double random()
			Returns a double value with a positive sign,
			greater than or equal to 0.0
			and less than 1.0 
		 */
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println("1~10 사이의 정수 랜덤생성");
		System.out.println(((int)(Math.random()*10))+1);
		System.out.println(((int)(Math.random()*10))+1);
		System.out.println(((int)(Math.random()*10))+1);
		System.out.println(((int)(Math.random()*10))+1);
		System.out.println("1 ~ 45 사이의 정수 랜덤생성");
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		System.out.println(((int)(Math.random()*45))+1);
		
		
		
	}

}
