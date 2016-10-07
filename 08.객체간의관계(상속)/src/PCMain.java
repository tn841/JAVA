/*
 * 상속(클래스의 관계)
 * 부모클래스(객체)의 멤버(변수, 메소드)들을 자식클래스(객체)가 물려받는것
 * 
 * 1. 상속을 사용하는 이유
 * 	- 기존에 만들어놓은 클래스의 재사용, 확장을 위해
 * 2. 자바에서는 단일상속만이 가능(부모클래스가 한개만 가능)
 * 3. 부모클래스(super)와 자식클래스(sub)가 존재한다.
 * 4. 자바에서 제공되어지는 모든 클래스들은 Object라는 부모클래스를 상속 받는다.
 * 5. 사용자정의 클래스들도 Object 클래스라는 최상위클래스를 상속 받아야 한다.
 * 6. 선택적 상속은 안된다 (부모가 1000개의 멤버를 가지면 자식은 그것을 모두 상속 받아야한다.)
 */
public class PCMain {

	public static void main(String[] args) {
		System.out.println("---------------parent--------------");
		Parent p = new Parent();
		p.member1 = "m1";
		p.member2 = "m2";
		p.method1();
		p.method2();
		System.out.println("---------------child--------------");
		Child ch = new Child();
		ch.member1 = "m1";
		ch.member2 = "m2";
		ch.member3 = "m3";
		ch.member4 = "m4";
		ch.method1();
		ch.method2();
		ch.method3();
		ch.method4();
		
	}

}
