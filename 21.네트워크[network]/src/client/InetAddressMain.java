package client;

import java.net.InetAddress;

public class InetAddressMain {

	public static void main(String[] args) throws Exception{
		System.out.println("------remote address-------");
		InetAddress naverIP=InetAddress.getByName("www.naver.com");
		String address=naverIP.getHostAddress();
		String name=naverIP.getHostName();
		System.out.println("host address:"+address);
		System.out.println("host name:"+name);
		
		InetAddress[] googleIPs=
				InetAddress.getAllByName("www.google.com");
		for (InetAddress inetAddress : googleIPs) {
			System.out.println(inetAddress);
		}
		System.out.println("------local address-------");
		InetAddress localAddress=InetAddress.getLocalHost();
		System.out.println("local host name:"+localAddress.getHostName());
		System.out.println("local host address:"+localAddress.getHostAddress());
		
	}

}
