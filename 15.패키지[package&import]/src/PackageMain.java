
/*
      package 
      1. �����ִ�(����,���) Ŭ������ ����(��Ű��)
      2. ��Ű���� �̸��� ���������� ū�����������������α���  
      3. Ŭ������ �������̸��� ��Ű���� �������̸��̴�..
      4. Ŭ������ �̸��ߺ��� ���ϱ����ؼ� ���
     ex> package samson.sds.chongmu;
	     public class Chongmu1{
		 
		 }
       
	  4.compile ��� 
			>javac -d . XXX.java  	
*/
public class PackageMain {
	public static void main(String[] args){
		com.itwill.shop.member.Member m = new com.itwill.shop.member.Member();
		System.out.println(m);
		
		com.itwill.shop.member.MemberService ms = new com.itwill.shop.member.MemberService();
		System.out.println(ms);
		
		
		com.itwill.shop.product.Product p = new com.itwill.shop.product.Product();
		System.out.println(p);
		
		com.itwill.shop.admin.Product ap = new com.itwill.shop.admin.Product();
		System.out.println(ap);
		
	}
}
