package server;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class DayTimeServerMain {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8001);
		
		while(true){
			System.out.println("[Server] 0. 8000번 포트에서 클라이언트의 소켓연결요청 대기");
			
			
			Socket socket = serverSocket.accept();
			System.out.println("[Server] 1. 8000번 포트로 들어온 클라이언트 소켓연결 처리, 처리된 소켓 확인 : "+socket);
			
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			String datTime = new Date().toLocaleString();
			
			pw.print(datTime);
			pw.flush();
			System.out.println("[Server] 2. outputStream을 생성하여 소켓에 날짜 쓰기, 쓰여진 값 : "+datTime);
			
			pw.close();
			socket.close();
			System.out.println();
		}
	}

}
