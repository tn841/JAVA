package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {

	public static void main(String[] args) throws IOException {
		/*
		 * ServerSocket class
		 *  - Ŭ���̾�Ʈ�� ���Ͽ��� ��û�� ������ Socket�� �����ϴ� Ŭ����
		 *  - Ŭ���̾�Ʈ�� �׳� Socket, ������ ServerSocket
		 *  - ������ ��Ʈ (0~65536)�� �ϳ��� ��Ʈ�� �����ϰ� ServerSocket�� ����
		 */
		ServerSocket serverSocket = new ServerSocket(3333);
		
		/* 
		 *  <ServerSocket�� accept�޼ҵ�>
		 *  public Socket accept() throws IOException{}
		 *   - Listens for a connection to be made to this socket and accepts it. 
		 *   - The method blocks until a connection is made. (���Ѵ��)
		 *     
		 *   - Ŭ���̾�Ʈ�� ���Ͽ����û��ȣ�� �޾Ƽ� ������ �������� ���� ��ȯ
		 */
		System.out.println("[Server] 0. 3333�� ��Ʈ�� ����, �ش� ��Ʈ�� ������ Ŭ���̾�Ʈ�� ���Ͽ����û�� ���(�� �����尡..)");
		Socket socket = serverSocket.accept();
		
		System.out.println("[Server] 1. 3333�� ��Ʈ�� ���� Ŭ���̾�Ʈ�� ���Ͽ����û�� ó���� �� ���� ��ȯ");
		System.out.println("[Server] 2. Ŭ���̾�Ʈ�� ����� ������ ���� Ȯ��: "+socket);
		

	}

}
