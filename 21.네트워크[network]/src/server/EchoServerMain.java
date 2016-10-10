package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {

	public static void main(String[] args) throws Exception {
		while(true){
			ServerSocket sSocket = new ServerSocket(9999);
			System.out.println("[Server] 0. 서버 소켓 생성 후 대기");
			
			Socket socket = sSocket.accept();
			System.out.println("[Server] 1. 열어 놓은 포트로 클라이언트의 소켓 요청이 들어옴, 소켓 확인:"+socket);
			
			String readStr = null;
			
//			InputStream in = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader br = new BufferedReader(isr);
//			String readStr = br.readLine();
			
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
			
			readStr = br.readLine();	
			
			System.out.println("받은 문자열 : "+readStr);
			
			System.out.println("3.클라이언트 소켓에데이타쓰기(server)");
			PrintWriter pw=
					new PrintWriter(
							new OutputStreamWriter(
									socket.getOutputStream()));
			
			
			pw.println("Server-->Client:"+readStr);
			pw.flush();
			System.out.println("4.클라이언트 소켓닫기(server)");
			pw.close();
			socket.close();
			
			
			
			OutputStream os = socket.getOutputStream();
		}
	}

}
