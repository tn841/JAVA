package server;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class WebServerMain {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(80);
		
		while(true){
			System.out.println("Web Server : 클라이언트의 요청 대기,");
			Socket socket = serverSocket.accept();
			System.out.println("Web Server : 클라이언트의 요청 분석, socket : "+socket);
			
			OutputStream out = socket.getOutputStream();
			GreetingServlet gServlet = new GreetingServlet();
			//ByeServlet bServlet = new ByeServlet();
			System.out.println("Web Server : 클라이언트가 요청한 일을 수행할 객체 생성");
			
			gServlet.execute(out);
			//bServlet.execute(out);
			System.out.println("Web Server : 클라이언트가 요청한 일을 수행");
			
			
			socket.close();
		}
	}

}
