/*
 * 객체참조변수의 형변환
 * 1. 부모자식관계에 있는 클래스들에서만 가능하다.
 * 
 * 2. 자식타입객체를 부모클래스타입으로 형변환
 * 		- 자동으로 이루어진다.(묵시적)
 * 		Child c = new Child();
 * 		Parent p = c;	//자식 객체를 부모 클래스 타입으로 형변환 하였다. 
 * 
 * 3. 부모 객체를 자식클래스타입으로 형변환
 * 		- 원칙적으로는 불가능하다.
 * 		- 부모의 탈을쓴 자식객체는 가능하다. (Parent p = c;)
 * 
 * 		Parent p = new Parent();
 * 		Child ccc = p; (X) -> 런타임 오류가 난다.
 * 
 * 		Child c = new Child();
 * 		Parent p = c;	//실제로는 Child객체이나 보기에는 Parent객체처럼 보인다.
 * 		Child cccc = (Child)p;	//이렇게 부모의 탈을 쓴 자식객체는 강제 형변환이 가능하다.
 */
public class PCMain {

	public static void main(String[] args) {
		Child c1 = new Child();
		Parent p1 = c1;	//부모 객체가 자식 객체로 형변환되는 것은 가능
		//c1과 p1은 같은 주소를 가르킨다.
		//그러나 형(type)이 다르다.
		
		c1.method1();
		c1.method2();
		c1.method3();
		c1.method4();
		
		p1.method1();
		p1.method2();
		//p1.method3();
		//p1.method4();
		
		
		
		Parent p2 = new Child();
		
		
		
	}

}
