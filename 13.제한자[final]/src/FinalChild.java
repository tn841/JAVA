
public class FinalChild extends FinalParent{
	
	/*
	public void cannotOverriding(){
		//Cannot override the final method from FinalParent
	}*/
	
	@Override
	public void method3() {
		System.out.println("Child에서 재정의된 메소드");
	}
}
