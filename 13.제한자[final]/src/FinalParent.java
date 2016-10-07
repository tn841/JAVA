/*
 * 제한자(final)
 * 1. 클래스 앞에 붙일 경우
 * 	- 상속금지 					ex) public final class String{} -> String 클래스는 상속하지 마세요.
 * 
 * 2. 멤버메소드 앞에 붙일 경우
 * 	- 오버라이딩(재정의) 금지	ex) public final void print(){}; -> print()메소드를 재정의하지 마세요.
 * 
 * 3. 멤버변수 앞에 붙일 경우
 * 	- 상수, 변경 금지, 참조만 가능	ex) public final int PORT_NUM = 21;	-> 상수 PORT_NUM, 선언과 동시에 초기화 or 생성자에서 초기화
 */
public class FinalParent {
	public final int PORT_NUMBER = 80;
	public final double INCENTIVE_RATE;	//객체 마다 가지고 있는 instance 상수
	
	public static final int	SHOUTH = 0;	 
	public static final int	NORTH = 1;	 
	public static final int	EAST = 2;	 
	public static final int	WEST = 3;	 //클래스가 갖고 있는 static 상수
	
	public FinalParent() {
		INCENTIVE_RATE = 0.1;
	}
	
	public void constantCheck(){
//		변경은 불가능하다.
//		this.PORT_NUMBER = 8080;
//		INCENTIVE_RATE = 0.2;
		
		//참조만 가능하다.
		System.out.println(PORT_NUMBER);
		System.out.println(INCENTIVE_RATE);
		System.out.println(FinalParent.EAST);
		System.out.println(FinalParent.NORTH);
		System.out.println(FinalParent.SHOUTH);
		System.out.println(FinalParent.WEST);
		
	}
	
	public final void cannotOverriding(){
		System.out.println("재정의 불가능한 final 메소드입니다. 상속은 됨");
	}
	
	public void method3(){
		System.out.println("재정의 가능한 일반 메소드");
	}
}
