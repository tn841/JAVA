/*
오버로딩(메쏘드 다중정의)
  1. 자바 다형성구현기법 중의하나이다.
  2. 정의:같은메쏘드 이름으로 여러개를 정의하는방법
           - 규칙: 
               * 메쏘드의 이름이 같아야한다.
               * 메쏘드의 인자의 숫자가 다르거나
               * 메쏘드의 인자의 타입이 달라야한다.
               * 메쏘드의 리턴타입,접근지정자는 상관없다.

*/
public class OverLoading {
		public void method(){
			System.out.println(">> method()");
		}
		public void method(String msg1){
			System.out.println(">> method(String msg1):"+msg1);
		}
		public void method(int a){
			System.out.println(">> method(int a):"+a);
		}
		/*
		//메쏘드의 리턴타입,접근지정자는 상관없다.
		public int method(int a){
			System.out.println(">> method(int a):"+a);
			return a;
		}
		*/
		
		public void method(String msg1,String msg2){
			System.out.println(">> method(String msg1,String msg2):"+msg1+","+msg2);
		}
		public void method(int a,int b){
			System.out.println(">> method(int a,int b):"+a+","+b);
		}
		public void method(String msg1,int b){
			System.out.println(">> method(String msg1,int b):"+msg1+","+b);
		}
		
}
