package com.itwill.wrapper;


/*
- Wrapper 클래스

	자바데이타형은 기본데이타형과 레퍼런스 데이타 형으로 구분됩니다.
	기본데이타형으로는 int,boolean,double 등이 제공됩니다.
	이런기본 데이타형을 객체로 사용할수있는 방법으로 
	Wrapper 클래스가 제공됩니다.
	Wrapper 클래스는 각종유용한 기능들을 메서드로 제공받을수있다는
	장점이있습니다.
	
	Integer,Boolean,Double,Character,Float,Long,Byte,Short
	
 */
public class WrapperMain {

	public static void main(String[] args) {
		/*
		 * Boxing(Wrapping)
		 *  - 기본형 --> Wrapper
		 */
		Integer wi1 = new Integer(11);
		Integer wi2 = new Integer("11");	//숫자 문자열을 정수로 파싱
		
		Boolean wb1 = new Boolean(true);
		Boolean wb2 = new Boolean("false");
		
		Double wd1 = new Double(12.2123);
		
		Character wc1 = new Character('a');
		
		/*
		 * Unboxing
		 *  - Wrapper --> 기본형
		 */
		System.out.println(wi1.intValue());
		
		/*
		 * auto boxing
		 */
		Integer wi3 = 11;		//식별자에는 주소값이 들어간다. (우측 리터럴이 자동으로 Wrapping된다.)
		Boolean wb3 = true;
		Double wd3 = 123.123;
		Character wc3 = 'd';
		
		/*
		 * Auto Unboxing
		 */
		int i3 = wi3;
		boolean b3 = wb3;
		double d3 = wd3;
		char c3 = wc3;
		
		
		/***************Auto Boxing & Upper Casting*************************/
		Object[] oArr = {i3, b3, d3, c3};	//i3, b3, d3, c3는 각각 적절한 Wrapper객체로 Auto Boxing되고 Object로 상위로의 캐스팅(upper casting)이 진행된 상황
		
		Object[] scoreArr = new Object[10];
		scoreArr[0] = 0;
		scoreArr[1] = 1;
		scoreArr[2] = 2;
		scoreArr[3] = 3;
		scoreArr[4] = 4;
		scoreArr[5] = 5;
		scoreArr[6] = 6;
		scoreArr[7] = 7;
		scoreArr[8] = 8;
		scoreArr[9] = 9;	//우측 정수형 리터럴이 Auto Boxing되고 Object로 upper 캐스팅되어 배열에 주소값이 저장된다.
		
		
		/******************** Down Casting & Auto Unboxing ************************/
		int ia = (Integer)oArr[0];	//Object객체인 oArr[0]가 Integer Wrapper클래스로 하위로 캐스팅된 후 정수형 변수 ia로 Auto Unboxing된다.
		int ia2 = (int)oArr[0];		//Object객체인 oArr[0]는 기본형 int로 바로 캐스팅 될 수 없다. 
									//먼저 Integer Wrapper클래스로 하위 캐스팅된 후 정수형 기본형으로 Auto Unboxing까지 이루어진 다음에 정수형 변수 ia2에 대입된다.
		
		Integer ia3 = (Integer)oArr[0];
		Integer ia4 = (int)oArr[0];	//Auto boxing됨
	
		System.out.println(ia+" "+ia2+" "+ia3+" "+ia4);
		System.out.println(ia+ia2+ia3+ia4);
		
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.println(scoreArr[i].getClass());
			
		}
		
	}

}
