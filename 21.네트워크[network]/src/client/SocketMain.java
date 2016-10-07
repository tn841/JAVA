package client;

import java.net.InetAddress;
import java.net.Socket;

public class SocketMain {

	public static void main(String[] args) throws Exception{
		Socket socket=new Socket("125.209.222.142", 80);	//네이버와 소켓 연결, 소켓은 아래의 4개 정보를 가진다.
															//네이버 서버는 80포트로 오는 소켓을 받을 준비를 하고 있기 때문에 연결이 되는 것.
		System.out.println("connect:"+socket);
		
		InetAddress remoteAddr = socket.getInetAddress();	//네이버 측 IP
		int remotePort = socket.getPort();					//네이버 측 Port
		InetAddress localAddr = socket.getLocalAddress();	//내 로컬 IP
		int localPort = socket.getLocalPort();;				//내 로컬 Port
		
		System.out.println("네이버 : "+remoteAddr + " - "+ remotePort);
		System.out.println("로컬 : "+localAddr + " - "+ localPort);
		
		socket.close();//소켓 닫기
		
	}

}
