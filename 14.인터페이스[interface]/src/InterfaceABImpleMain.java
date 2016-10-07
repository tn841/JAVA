
public class InterfaceABImpleMain {

	public static void main(String[] args) {
		InterfaceABImpl abImpl = new InterfaceABImpl();
		abImpl.method1();
		abImpl.method2();
		abImpl.method3();
		abImpl.method4();
		abImpl.method5();
		abImpl.method6();
		
		Object obj = (Object)abImpl;	//상위클래스로 캐스팅
		System.out.println(obj.toString());
		
		InterfaceA ia; //인터페이스도 타입선언이 가능하다.
		ia = abImpl;	//암시적 캐스팅
		ia.method1();
		ia.method2();
		
		InterfaceB ib = abImpl;
		ib.method3();
		ib.method4();
		
		System.out.println("---- InterfaceA <-> InterfaceB ----");
		InterfaceA ia1 = new InterfaceABImpl();	//method1,2만 관심 있다.
		
		InterfaceB ib1 = (InterfaceB)ia1;	//강제 형변환.. 이제는 method3,4만 관심 있다.
		
		System.out.println("-----------Array-----------");
		InterfaceA[] iaa = new InterfaceA[2];
		InterfaceB[] iba = new InterfaceB[2];
		
		iaa[0] = new InterfaceABImpl();
		iaa[1] = new InterfaceABImpl();
		
		iba[0] = new InterfaceABImpl();
		iba[1] = new InterfaceABImpl();
		
		for (int i = 0; i < iaa.length; i++) {
			System.out.println(iaa[i]);
		}
		
		
	}

}
