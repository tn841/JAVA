
public class Parent extends Object{
	public int member1;
	public int member2;
	
	public Parent() {
		/*
		 Constructor call must be the first statement in a constructor
		 System.out.println("before constructor");
		 */
		
		super();
		System.out.println("Parent()");
	}
	
	
	public Parent(int member1, int member2) {
		this.member1 = member1;
		this.member2 = member2;
		System.out.println("Parent(int member1, int member2)");
	}


	public void method1(){
		System.out.println("method1()");
	}
	

	public void method2(){
		System.out.println("method2()");
	}

}
