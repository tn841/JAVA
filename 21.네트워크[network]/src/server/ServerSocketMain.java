package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {

	public static void main(String[] args) throws IOException {
		/*
		 * ServerSocket class
		 *  - 클라이언트의 소켓연결 요청을 받으면 Socket을 생성하는 클래스
		 *  - 클라이언트는 그냥 Socket, 서버는 ServerSocket
		 *  - 서버의 포트 (0~65536)중 하나의 포트를 점유하고 ServerSocket을 생성
		 */
		ServerSocket serverSocket = new ServerSocket(3333);
		
		/* 
		 *  <ServerSocket의 accept메소드>
		 *  public Socket accept() throws IOException{}
		 *   - Listens for a connection to be made to this socket and accepts it. 
		 *   - The method blocks until a connection is made. (무한대기)
		 *     
		 *   - 클라이언트의 소켓연결요청신호를 받아서 소켓을 생성한후 소켓 반환
		 */
		System.out.println("[Server] 0. 3333번 포트를 열고, 해당 포트로 들어오는 클라이언트의 소켓연결요청을 대기(주 쓰레드가..)");
		Socket socket = serverSocket.accept();
		
		System.out.println("[Server] 1. 3333번 포트로 들어온 클라이언트의 소켓연결요청을 처리한 후 소켓 반환");
		System.out.println("[Server] 2. 클라이언트와 연결된 서버의 소켓 확인: "+socket);
		

	}

}
