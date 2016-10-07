package com.itwill.wrapper;

public class Wrapper연산 {
	public static void main (String[] arg){
		/*
		 * 비교연산
		 */
		Integer wi1 = new Integer(89);	//wi1 참조변수에는 Integer Wrapper클래스 형 주소값이 저장되므로 '=='비교연산시 주소값 비교가 일어날 것이다??? -> 그렇다.
		Integer wi2 = new Integer(89);
		Integer wi3 = wi1;
		
		if(wi1 == wi2){
			System.out.println("주소 같다.");
		}
		else{
			System.out.println("주소 다르다.");			
		}
		
		if(wi1 == wi3){
			System.out.println("주소 같다.");
		}
		else{
			System.out.println("주소 다르다.");			
		}
		
		if(wi1 >= wi3){	// >= 연산자에 의해 wi1와 wi3가 Auto Unboxing된다.
			System.out.println("wi1 값이 wi3보다 크거나 같다.");
		}
		else{
			System.out.println("wi1 값이 wi3보다 작다.");			
		}
		
		if(wi1.equals(wi2)){
			System.out.println("값이 같다.");			
		}
		else{
			System.out.println("값이 다르다.");			
		}
		
		if(wi1.equals(wi3)){
			System.out.println("값이 같다.");			
		}
		else{
			System.out.println("값이 다르다.");			
		}
		
		
		int i1 = 89;
		int i2 = 100;
		int i3 = 900;
		
		if(i1 == wi1){	//Wrapper객체인 wi1이 정수 기본형과 비교연산을 하기위해 Auto Unboxing이 이루어진다.
			System.out.println("값이 같다.");
		}
		else{
			System.out.println("값이 다르다.");
		}
		
		int y = 2147483647;
		String bStr=Integer.toBinaryString(y);
		System.out.println("이진:"+bStr);
		int pi=Integer.parseInt("1234542");
		String hStr = Integer.toHexString(2147483647);	
		System.out.println("16진:"+hStr);
		System.out.println(pi);
		Integer wi=new Integer("45353");
		int i12 = wi.intValue();
		Integer wi22=Integer.getInteger("654645654");
		double pd=Double.parseDouble("3.15240");
		
		boolean b1=Boolean.parseBoolean("true");
		boolean b2=Boolean.parseBoolean("FALSE");
		
		System.out.println("--------Wrapper Character------");
		
		Character cw=new Character('김');
		char c=cw.charValue();
		char fc="김경호".charAt(0);
		System.out.println(">> String-->char[]");
		String str = "Hello Java!!!#$643724김경호제임스";
		char[] getCharArray=new char[str.length()];
		str.getChars(0, str.length(), getCharArray, 0);
		for (int i = 0; i < getCharArray.length; i++) {
			System.out.print(getCharArray[i]+",");
		}
		System.out.println();
		String str2=new String(getCharArray, 0, getCharArray.length);
		System.out.println(">> char[]-->String:"+str2);
		
		for (int i = 0; i < getCharArray.length; i++) {
			char tempChar=getCharArray[i];
			
			int type=Character.getType(tempChar);
			//System.out.println(tempChar+" type:"+type);
			if(type==Character.LOWERCASE_LETTER){
				System.out.println(tempChar+" 소문자");
			}
			if(type==Character.UPPERCASE_LETTER){
				System.out.println(tempChar+" 대문자");
			}
			if(type==Character.CURRENCY_SYMBOL){
				System.out.println(tempChar+" 화페");
			}
			if(type==Character.DECIMAL_DIGIT_NUMBER){
				System.out.println(tempChar+" 숫자");
			}
			if(Character.isAlphabetic(tempChar)){
				System.out.println(tempChar+" 알파벳");
			}
			if(Character.isSpaceChar(tempChar)){
				System.out.println(tempChar+" 공백문자");
			}
			
		}
		
		
		
	}
}
