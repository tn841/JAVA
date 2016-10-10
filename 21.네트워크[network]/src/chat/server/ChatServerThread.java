package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * - �������� ����������ؼ� ����Ÿ����,������ ���Ѿ�����Ŭ����
 * - �Ѹ��� Ŭ���̾�Ʈ���� ����� ����ϴ¾����尴ü
 * 
 */
public class ChatServerThread extends Thread{
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ChatServerFrame csf;
	
	public ChatServerThread(ChatServerFrame asdfasdf){
		csf = asdfasdf;
		
	}
	
	@Override
	public void run() {
		try {
			//���� ���� ����
			this.serverSocket=new ServerSocket(7777);
			while(true){
				System.out.println("0.7777����Ʈ���� Ŭ���̾�Ʈ �������ӿ�û���");
				this.socket=serverSocket.accept();
				System.out.println("1.Ŭ���̾�Ʈ ���ϻ���:"+socket);
				System.out.println("2.Ŭ���̾�Ʈ InputStream, OutputStream����");		
				this.in=new BufferedReader(
						new InputStreamReader(
							socket.getInputStream()));
				
				this.out=new PrintWriter(
								new OutputStreamWriter(
										socket.getOutputStream()));
				
				
				while(true){
					System.out.println("4.Ŭ���̾�Ʈ �κ��� ����Ÿ�� �б����ع��Ѵ��, blocking");
					String readLine = in.readLine();
					System.out.println("5.Ŭ���̾�Ʈ �κ��� ����Ÿ�� �б�:"+readLine);
					
					//���������� UI�� ���
					csf.getChatTA().append("���� : "+readLine+"\n");
				}
			
			}
		} catch (IOException e) {
			System.out.println("Sever down!!!:"+e.getMessage());
		}
	}

	public void send(String string) {
		out.println(string);
		out.flush();
	}
}
