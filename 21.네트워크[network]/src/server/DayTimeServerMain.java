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
			System.out.println("[Server] 0. 8000�� ��Ʈ���� Ŭ���̾�Ʈ�� ���Ͽ����û ���");
			
			
			Socket socket = serverSocket.accept();
			System.out.println("[Server] 1. 8000�� ��Ʈ�� ���� Ŭ���̾�Ʈ ���Ͽ��� ó��, ó���� ���� Ȯ�� : "+socket);
			
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			String datTime = new Date().toLocaleString();
			
			pw.print(datTime);
			pw.flush();
			System.out.println("[Server] 2. outputStream�� �����Ͽ� ���Ͽ� ��¥ ����, ������ �� : "+datTime);
			
			pw.close();
			socket.close();
			System.out.println();
		}
	}

}
