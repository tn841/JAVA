/* OOP 클래스 설계 기법 
 *   1. 캡슐화
 *   2. 상속성
 *   3. 다형성(오버로딩,오바라이딩,객체형변환)
 */

/*
 * 1. 캡슐화
 *    - 외부클래스(객체)에서 멤버변수에 접근을 막고
 *      멤버 메쏘드에만 접근할수있도록 클래스를 설계하는방법
 *    - 구현 : 멤버변수의 접근제한자를 private => 외부 클래스(객체)에서 멤버변수 직접 접근 못함 
 *    		   멤버메소드의 접근제한자는 public  => 멤버메소드를 통해서만 접근 가능하다. 
 *             public ==> 어떤 외부클래스에서든지 접근가능
 *             private==> 어떤 외부클래스에서든지 접근불가능
 */

public class Encapsulation {
	
	//접근제한자를 private으로 하여 외부에서의 멤버변수에 대한 직접 접근을 제한하였다.
	private String m1;
	private int m2;
	
	
	
	//멤버변수에 접근 가능한 getter, setter 메소드를 생성하여 이를 통해서만 멤버변수에 접근 할 수 있다.
	public void setM1(String m1) {
		this.m1 = m1;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	public String getM1() {
		return m1;
	}
	public int getM2() {
		return m2;
	}
}
