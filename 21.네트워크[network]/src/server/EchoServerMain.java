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
			System.out.println("[Server] 0. ���� ���� ���� �� ���");
			
			Socket socket = sSocket.accept();
			System.out.println("[Server] 1. ���� ���� ��Ʈ�� Ŭ���̾�Ʈ�� ���� ��û�� ����, ���� Ȯ��:"+socket);
			
			String readStr = null;
			
//			InputStream in = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader br = new BufferedReader(isr);
//			String readStr = br.readLine();
			
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
			
			readStr = br.readLine();	
			
			System.out.println("���� ���ڿ� : "+readStr);
			
			System.out.println("3.Ŭ���̾�Ʈ ���Ͽ�����Ÿ����(server)");
			PrintWriter pw=
					new PrintWriter(
							new OutputStreamWriter(
									socket.getOutputStream()));
			
			
			pw.println("Server-->Client:"+readStr);
			pw.flush();
			System.out.println("4.Ŭ���̾�Ʈ ���ϴݱ�(server)");
			pw.close();
			socket.close();
			
			
			
			OutputStream os = socket.getOutputStream();
		}
	}

}
