

public class MemberMethod {
	public int member1;
	public String member2;
	public boolean member3;
	public char member4;
	public double member5;
	
	public void method1(){
		/*
		 * method ��Ͼȿ����� ��밡���� local ����
		 */
		int i=800;
		int j=900;
		int result=i+j;
		System.out.println("----MemberMethod.method1����:---"+result);
		return;
	}
	public void method2(String name){
		System.out.println("----MemberMethod.method2����---");
		/*
		 String name="��ҿ�";
		 */
	
		System.out.println(name+" �Ծȳ�!!!");
		return;
	}
	
	public void method3(String name,int count){
		System.out.println("----MemberMethod.method3����---");
		for (int i = 0; i < count; i++) {
			System.out.println(name+" �� �ȳ�!!!");
		}
		
	}
	
	public int method4(int a, int b){
		int result = a+b;
		return result;	//return�� �ǹ� ���� �������� ��ȯ
	}
	
	public String method5(String name){		
		
		String resultStr = name+" �� Hello";
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
