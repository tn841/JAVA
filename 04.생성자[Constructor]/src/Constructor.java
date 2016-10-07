/*
생성자 메소드(constructor): 객체 생성직후 최초로 실행되며 단 한번만 실행되는 메소드(?) 이다.
1. 클래스 이름과동일하며 리턴타입을 명시하지않는 메쏘드(???)
2. 하나의 클래스에는 반드시 하나이상의 생성자가 존재하여야한다
--> 생성자를 정의하지않을경우 컴파일러는 인자가하나도없는
    생성자(디폴드 생성자)를 자동으로 넣어서 컴파일한다.    
3. 객체생성시 단한번 호출된다.
4. 주로 객체초기화의 용도로 사용한다.
5. 객체를 생성할려면 반드시 생성자를 호출하여야한다.
	
	-형태: 
	 	public class Test{
	 		//생성자의 정의(선언)
	 	    public Test(){
	 	    }
	 	}
	 	
    -사용: 
           Test t = new Test(); 
	 	   클래스명 참조변수이름 = new 클래스명();
	 	   new 라는 연산자는 반드시 생성자 앞에있어야하며
	 	   이연산자에의해 객체를 생성한다.
*/


public class Constructor {
	private int member1;
	private int member2;
	/*
	 * 기본(디폴트) 생성자
	 */
	public Constructor(){	//생성자가 호출되는 시점에, 객체는 이미 생성되어 있기 때문에 셀프참조(this)가 가능하다.
		System.out.println("Constructor()");
		this.member1 = 100;
		this.member2 = 200;
	}
	
	public Constructor(int m1){	
		System.out.println("Constructor(int m1)");
		this.member1 = m1;
		this.member2 = 0;
	}
	
	public Constructor(int m1, int m2){	
		System.out.println("Constructor(int m1, int m2)");
		this.member1 = m1;
		this.member2 = m2;
	}
	
	public void print(){
		System.out.println(member1+", "+member2);
	}
	
	
	
	/*
	 * getter, setter 생성 단축키 Alt + Shift + S -> r
	 */
	public int getMember1() {
		return member1;
	}

	public void setMember1(int member1) {
		this.member1 = member1;
	}

	public int getMember2() {
		return member2;
	}

	public void setMember2(int member2) {
		this.member2 = member2;
	}



}
