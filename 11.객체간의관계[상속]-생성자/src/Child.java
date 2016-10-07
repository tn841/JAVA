
public class Child extends Parent{
	public int member3;
	public Child() {
		/*
		 * 부모클래스의 기본생성자가 호출된다.(생략가능)
		 */

		System.out.println("Child()");
	}
	
	public Child(int member1,int member2,int member3) {
		super(member1,member2);	//부모클래스의 생성자를 활용함..
		//this.member1=member1;
		//this.member2=member2;
		this.member3 = member3;
		System.out.println("Child(int member1,int member2,int member3)");
	}

	public void method3(){
		System.out.println("method3()");
	}
	
}



