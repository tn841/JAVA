package server;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class WebServerMain {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(80);
		
		while(true){
			System.out.println("Web Server : Ŭ���̾�Ʈ�� ��û ���,");
			Socket socket = serverSocket.accept();
			System.out.println("Web Server : Ŭ���̾�Ʈ�� ��û �м�, socket : "+socket);
			
			OutputStream out = socket.getOutputStream();
			GreetingServlet gServlet = new GreetingServlet();
			//ByeServlet bServlet = new ByeServlet();
			System.out.println("Web Server : Ŭ���̾�Ʈ�� ��û�� ���� ������ ��ü ����");
			
			gServlet.execute(out);
			//bServlet.execute(out);
			System.out.println("Web Server : Ŭ���̾�Ʈ�� ��û�� ���� ����");
			
			
			socket.close();
		}
	}

}
