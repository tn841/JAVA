
public class InterfaceABImpl extends Object implements InterfaceA, InterfaceB {
	
	@Override
	public String toString() {
		return "�� AB ������ü"+this.hashCode();
	}
	
	@Override
	public void method1() {
		System.out.println("InterfaceA.method1() ������(����)");
	}

	@Override
	public void method2() {
		System.out.println("InterfaceA.method2() ������(����)");
	}

	@Override
	public void method3() {
		System.out.println("InterfaceB.method3() ������(����)");
	}

	@Override
	public void method4() {
		System.out.println("InterfaceB.method4() ������(����)");
	}

	public void method5() {
		System.out.println("public void method5()");
	}

	public void method6() {
		System.out.println("public void method6()");
	}

}
