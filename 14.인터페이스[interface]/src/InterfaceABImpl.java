
public class InterfaceABImpl extends Object implements InterfaceA, InterfaceB {
	
	@Override
	public String toString() {
		return "난 AB 구현객체"+this.hashCode();
	}
	
	@Override
	public void method1() {
		System.out.println("InterfaceA.method1() 재정의(구현)");
	}

	@Override
	public void method2() {
		System.out.println("InterfaceA.method2() 재정의(구현)");
	}

	@Override
	public void method3() {
		System.out.println("InterfaceB.method3() 재정의(구현)");
	}

	@Override
	public void method4() {
		System.out.println("InterfaceB.method4() 재정의(구현)");
	}

	public void method5() {
		System.out.println("public void method5()");
	}

	public void method6() {
		System.out.println("public void method6()");
	}

}
