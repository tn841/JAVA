
public class OverridingChild extends Overriding {	
	@Override
	public void method2(){
		//재정의한 메소드에 의해 부모에 있던 method2는 은폐되어 표출되지 않는다.
		System.out.println("public void method2() 재정의");
	}
	
	public void method3(){
		System.out.println("public void method3()");
	}
	
}
