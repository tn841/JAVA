


public class MemberMethodMain {

	public static void main(String[] args) {
		
		MemberMethod mm=new MemberMethod();
		
		mm.member1=12;
		mm.member2="���ڿ�";
		mm.member3=true;
		mm.member4='A';
		mm.member5=123.00;
		
		System.out.println("main method1ȣ��");
		/*
		 public void method1() 
		 */
		mm.method1();
		System.out.println("main method2ȣ��");
		/*
		public void method2(String name) 
		 */
		mm.method2("��ҿ�");
		mm.method2("�嵿��");
		
		/*
		public void method3(String name,int count)
		 */
		mm.method3("�����", 2);
		
		mm.method3("��ȿ��", 3);
		
		
		/*
		 * public int method4(int a, int b)
		 */
		int r = mm.method4(5, 6);
		System.out.println("main add result:"+r);
		
		
		/*
		 * 	public String method5(String name)
		 */
		
		String str1 = mm.method5("KIM");
		System.out.println("1. str1:"+str1);
		
		String str2 = mm.method5("LEE");
		System.out.println("2. str2:"+str2);
		
		mm.print();
		
		
		
		
		
		
		return;
		
		
	}

}
