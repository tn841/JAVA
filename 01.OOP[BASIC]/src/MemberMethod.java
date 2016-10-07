

public class MemberMethod {
	public int member1;
	public String member2;
	public boolean member3;
	public char member4;
	public double member5;
	
	public void method1(){
		/*
		 * method 블록안에서만 사용가능한 local 변수
		 */
		int i=800;
		int j=900;
		int result=i+j;
		System.out.println("----MemberMethod.method1실행:---"+result);
		return;
	}
	public void method2(String name){
		System.out.println("----MemberMethod.method2실행---");
		/*
		 String name="고소영";
		 */
	
		System.out.println(name+" 님안녕!!!");
		return;
	}
	
	public void method3(String name,int count){
		System.out.println("----MemberMethod.method3실행---");
		for (int i = 0; i < count; i++) {
			System.out.println(name+" 님 안녕!!!");
		}
		
	}
	
	public int method4(int a, int b){
		int result = a+b;
		return result;	//return의 의미 값과 쓰레드의 반환
	}
	
	public String method5(String name){		
		
		String resultStr = name+" 님 Hello";
		return resultStr;
	}
	
	public void print(){
		System.out.println(this.member1);
		System.out.println(this.member2);
		System.out.println(this.member3);
		System.out.println(this.member4);
		System.out.println(this.member5);
	}
	
}
