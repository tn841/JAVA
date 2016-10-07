
public class StaticMain {

	public static void main(String[] args) {
		/*
		 * static 멤버접근
		 */
		
		//클래스가 생성되는(로딩되는) 메소드 영역에 만들어져서 전역적으로 접근가능하다.
		Static.static_var=300;	//정적 멤버변수는  이탤릭체로 표시됨.
		System.out.println("정적 변수"+Static.static_var);	
		Static.static_method();
		
		/*
		 * instance 멤버접근
		 */
		Static st1 = new Static();
		Static st2 = new Static();
		st1.instance_var = 800;
		st2.instance_var = 900;
		System.out.println("st1 인스턴스 변수"+st1.instance_var);
		st1.instance_method();
		System.out.println("st2 인스턴스 변수"+st2.instance_var);
		st2.instance_method();
		
		System.out.println("------------참조변수를 통한 static멤버접근------------");
		System.out.println(st1.static_var);
		//The static field Static.static_var should be accessed in a static way
		System.out.println(st2.static_var);
		st1.static_method();
	}

}
