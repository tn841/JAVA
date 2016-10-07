
public class AbstractMain {

	public static void main(String[] args) {
		/*
		 * 추상클래스는 단독 객체 생성 불가능
		 */
		//AbstarctParent ap = new AbstarctParent();
		
		AbstractChild ac = new AbstractChild();
		ac.method1();
		ac.method2();
		
		AbstractParent ap;	//객체 생성은 불가능 하지만 객체 선언은 가능하다. 자식객체의 주소만 넣을 수 있다.
		ap = new AbstractChild();	//또한 참조변수 형변환도 가능하다.
		ap.method1();
		ap.method2();
		
	}

}
