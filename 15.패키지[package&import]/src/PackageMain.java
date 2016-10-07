
/*
      package 
      1. 관련있는(업무,기능) 클래스의 모음(패키지)
      2. 패키지의 이름은 계층적으로 큰범위부터작은범위로구성  
      3. 클래스의 완전한이름은 패키지를 포함한이름이다..
      4. 클래스의 이름중복을 피하기위해서 사용
     ex> package samson.sds.chongmu;
	     public class Chongmu1{
		 
		 }
       
	  4.compile 방법 
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
