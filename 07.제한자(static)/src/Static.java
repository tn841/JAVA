/*
 * static 제한자(제어자, modifier)
 * 1. 멤버변수나, 메소드(클래스) 앞에 붙힐수 있다.
 * 2. static 제한자가 붙어있는 변수나 메소드는 객체생성없이도 사용이가능하다.
 * 3. 클래스가 가지고있는 변수나메소드이다.
 * 		-> 클래스 변수, 클래스 메소드라고한다.
 * 4. 클래스로부터 생성되는 객체들이 공유한는 변수(메소드)이다.
 * 		-> 공용변수(메소드)라고도 한다.
 * 
 * 	-형식:
 * 		멤버변수 :  public static int i;
 * 		멤버메소드 : public static void print();
 *
 */
public class Static {
	public int instance_var = 100;
	public static int static_var = 100;
	
	public void instance_method(){
		System.out.println("객체 메소드");
	}
	public static void static_method(){
		System.out.println("정적 메소드");
		//정적 메소드에서는 셀프참조변수(this)를 사용할 수 없다. 생각해보면 당연한것,, 
		//객체가 만들어지지 않기 때문에 this라는 것이 존재 할 수가 없다.
	}
}
