/*
 * 인터페이스
 * 	1. 클래스가 가진 모든 메소드가 추상메소드
 * 	2. 다중상속의 효과 (추상클래스로는 불가능 하나 인터페이스는 가능)
 * 
 * 	- 형식
 * 		- class 키워드 대신에 interface라는 키워드 사용
 * 		- 추상 메소드 앞에 abstract를 붙이지 않아도 된다.
 * 		ex) public interface Test{
 * 			public final int MEMBER = 1;	//상수를 가질 수 있다.
 * 			public void method();
 * 			public void method2();
 * 		}
 * 
 * 	- 사용
 * 		1. interface를 상속(implements)받는다.
 * 		2. 추상 메소드를 재정의한 후 사용한다.
 * 
 * 		ex) public class TestImpl implements Test{
 * 			public void method(){};
 * 			public void method2(){};
 * 		}
 * 		
 * 
 */
public interface InterfaceA {
	public void method1();
	public void method2();
}


