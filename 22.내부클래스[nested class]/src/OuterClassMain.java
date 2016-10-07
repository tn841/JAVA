
public class OuterClassMain {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.outer_member_var = 3215;
		oc.outer_method();
		
		oc.new InnerClass();	//외부클래스 객체에서 내부클래스 생성자 호출
		OuterClass.InnerClass ic = oc.new InnerClass();
		ic.inner_member_var=41561;
		ic.inner_method();
	}

}
