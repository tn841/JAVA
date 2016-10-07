package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketPortScanMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		for(int port = 20; port< 22; port++){
			try{
				Socket socket = new Socket("www.microsoft.com",port);	//도메인을 적으면 DNS에서 IP주소를 가져옴
				System.out.println(port+"포트 소켓 생성");
			}catch(Exception e){
				System.out.println(port+"포트 소켓 생성 실패");
			}
		}
		
	}

}
