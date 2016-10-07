import korea.prince.YSChild;

/*
 * 클래스 또는 멤버의 접근을 제한하는 제한자
 * 	1. 클래스의 접근 제한
 * 	2. 클래스의 멤버(변수, 메소드)의 접근 제한
 * 	3. 접근제한자(public, protected, (package), private)
 * 		- public : 외부 모든 클래스(객체)에서 접근가능\
 * 
 * 		- protected : 같은 패키지에 있는 모든 클래스(객체)에서 접근 가능
 * 					  다른 패키지에 있는 상속관계에 있는 자식클래스(객체)에서 접근 가능
 * 
 * 		- (package) : 같은 패키지에 있는 모든클래스(객체)에서 접근 가능
 * 					  다른 패키지에 있는 모든 클래스에서 접근 불가능
 *  
 * 		- private : 외부 모든 클래스(객체)에서 접근 불가능
 */
public class AccessModifierMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YSChild yC = new YSChild();
		yC.access();
		
		//yC.b(); //접근이 되지 않는다. why? -> 패키지가 다르기 때문
	}

}
