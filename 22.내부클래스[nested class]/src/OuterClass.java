
public class OuterClass {
	/*
	 * member field
	 */
	public int outer_member_var = 88;
	public OuterClass() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * member method
	 */
	public void outer_method(){
		System.out.println("OuterClass.outer_method()");
	}
	
	/*
	 * 외부클래스에서 내부클래스 사용(객체 생성)
	 */
	public void outer_inner_use(){
		//OuterClass.InnerClass ic = this.new InnerClass();
		InnerClass ic = new InnerClass();
		int iii = ic.inner_member_var;
		ic.inner_method();
	}
	
	
	
	/*
	 * member class
	 */
	public class InnerClass{
		public int inner_member_var = 99;
		public void inner_method(){
			System.out.println("InnerClass.inner_method()");
		}
		
		/*
		 *  이너클래스를 만드는 이유
		 *  	- 내부클래스에서 외부클래스 멤버 접근 
		 */
		
		public void inner_outer_access(){
			OuterClass.this.outer_member_var = 33;	//정석적인 접근 방법
			InnerClass.this.inner_member_var = 33;
			
			outer_member_var = 48684;	//어떻게 접근 가능한거지? 이너에서 해당이름의 멤버변수를 찾고 없으면 아우터에서 멤버변수를 찾는다.
			this.inner_member_var = 23423;
			System.out.println(outer_member_var);
		}
	}
	
}









