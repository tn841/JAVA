import java.io.InputStream;
import java.net.Socket;
import java.sql.Connection;	//표준 API

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.product.Product;	//사용자정의 API

/*
 * package 선언
 */

/*
 * import 선언
 */
//import com.itwill.shop.member.*;
//import com.*;	//com에는 클래스가 없다. 패키지 폴더만 있음,, 하위 패키지(폴더)에 있는 클래스는 찾지 않는다.
//import com.itwill.shop.product.Product;
//import com.itwill.shop.admin.Product;	//이름이 같은 클래스는 import할 수 없다. 걍 풀네임 써라

/*
 * 	import 단축키 (Ctrl + Shift + o)
 */

public class PackageImprotMain {
	public static void main(String[] args){
		Member m = new Member();
		System.out.println(m);
		
		MemberService ms = new MemberService();
		System.out.println(ms);
		
		
		Product pp = new Product();
		System.out.println(pp);
		
		com.itwill.shop.admin.Product ap = new com.itwill.shop.admin.Product();
		System.out.println(ap);
		
		
		/*
		 * java.lang package는 import구문 없이 사용가능
		 */
		java.lang.String str = new java.lang.String();
		String str2 = new String();
		
		
		Socket soket;
		InputStream inputStream;
		Connection con;
		
	}
}
