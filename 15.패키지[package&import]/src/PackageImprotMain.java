import java.io.InputStream;
import java.net.Socket;
import java.sql.Connection;	//ǥ�� API

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.product.Product;	//��������� API

/*
 * package ����
 */

/*
 * import ����
 */
//import com.itwill.shop.member.*;
//import com.*;	//com���� Ŭ������ ����. ��Ű�� ������ ����,, ���� ��Ű��(����)�� �ִ� Ŭ������ ã�� �ʴ´�.
//import com.itwill.shop.product.Product;
//import com.itwill.shop.admin.Product;	//�̸��� ���� Ŭ������ import�� �� ����. �� Ǯ���� ���

/*
 * 	import ����Ű (Ctrl + Shift + o)
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
		 * java.lang package�� import���� ���� ��밡��
		 */
		java.lang.String str = new java.lang.String();
		String str2 = new String();
		
		
		Socket soket;
		InputStream inputStream;
		Connection con;
		
	}
}
