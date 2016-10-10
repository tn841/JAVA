package server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketMain {

	public static void main(String[] args) throws Exception {
		System.out.println("[Client] 0. ip주소가 192.168.12.12인 서버의 3333번 포트로 소켓연결요청");
		Socket socket = new Socket("192.168.12.12", 3333);
		
		System.out.println("[Client] 1. 서버와 연결 성공하면 연결 성공된 소켓을 가짐");
		System.out.println("[Client] 2. 서버와 연결된 소켓 확인 : "+socket);
	}

}
