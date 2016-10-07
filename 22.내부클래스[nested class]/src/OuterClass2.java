
public class OuterClass2 {
	public int outer_member_field = 999;
	
	public void outer_method(){
		System.out.println("OuterClass2.outer_method()");
	}
	
	public void outer_annonymous_local_inner_class(){	//메소드 내부는 local영역이다.
		/*
		 * local 영역 (변수, 클래스 등..)
		 */
		int local_member = 99;
		
		/*
		 * Annoymous local inner Class
		 */
		
		
		//MemberInnerClass mic = new MemberInnerClass();
		//mic.Inner_method();
		Object oc = new Object(){	//oc는 Object Child 객체이다.
			public void Inner_method() {	//익명 클래스의 메소드는 의미 없는 것이다..
				System.out.println("이름없는.Inner_method()");
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Here is annoymous class's overriding mothed";
			}
		};
		System.out.println(oc.toString());
		 
	}
	

	
}
