		/*
		변수의선언
          - 의미:JVM 에게메모리를할당해달라고
                                요청하는작업
		  - 형태:
		        데이타타입 이름;
		         ex> int number;

		  - 변수식별자규직(클래스이름,변수이름,메쏘드이름)
			   - 영문이나,한글로시작(숫자는 안됨)
			   - 특수문자사용불가(_,$가능)
			   - 키워드 사용금지
		*/




public class VariavbleDeclear{
	public static void main(String[] args){
	

		int number;
		number = 200;
		int number2 = 300;
		int number3= number+number2;
		
		
		
		System.out.println("number=" +number);
		System.out.println("number2=" +number2);
		System.out.println("number+number2=" +number3);

		}
}
