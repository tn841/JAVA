package com.itwill.string;

public class StringMain {

	public static void main(String[] args) {
		/*
		 * String 객체 생성
		 */
		
		//명시적생성
		String str1 = new String("java");
		String str2 = new String("java");
		System.out.println(str1==str2);
		
		//암시적생성
		String str3 = "java";	//string리터럴 pool을 갖는다. pool에 "java"라는 문자열이 있는지 확인, 없으므로 생성 
		String str4 = "java";	//string리터럴 pool에 "java"라는 문자열이 있으므로 그 객체의 주소를 사용
			//str3과 str4의 주소값은 같다.
		
		System.out.println(str3==str4);
		
		
		/*
		 * String 비교
		 * public int compareTo(String anotherString)
		 * 
		 * 
		 */
		
		
		System.out.println("---------String.substring()---------");
		
		String str5 = "Have a nice day!!";
		System.out.println("Have a nice day~!".substring(7));
		System.out.println("Have a nice day~!".substring(7,11));
		
		String id = "test001";
		char firstCh = id.charAt(0);
		if(firstCh >= 'a' && firstCh <= 'z'){
			System.out.println("영문 소문자");
		}
		
		for (int i = 0; i < id.length(); i++) {
			char temp = id.charAt(i);
			if(  (temp >= 'a' && temp <= 'z')  || (temp >= 'A' && temp <= 'Z')  || (temp >= '0' && temp <= '9')   ){
				System.out.println("영 소문자, 대문자, 숫자 입니다."+temp);
			}
			else{
				System.out.println("유효하지 않음"+temp);
			}
		}
		
		
		System.out.println("---------String.split()---------");
		String cardNo = "4567-1832-4483-7486";
		String[] carNoArr = cardNo.split("-");
		
		for (int i = 0; i < carNoArr.length; i++) {
			System.out.println(carNoArr[i]);
		}
		
		
		System.out.println("---------String.toUpperCase()---------");
		String strddd = "aasdfasdf";
		System.out.println(strddd.endsWith("f"));
		
		
		char[] charArr = {'H','e','l','l','o','!'};
		String cStr = new String(charArr);
		System.out.println(cStr);
		
		
	}

}
