package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * - 서버쪽의 소켓을사용해서 데이타전송,수신을 위한쓰레드클래스
 * - 한명의 클라이언트와의 통신을 담당하는쓰레드객체
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
			//서버 소켓 생성
			this.serverSocket=new ServerSocket(7777);
			while(true){
				System.out.println("0.7777번포트에서 클라이언트 소켓접속요청대기");
				this.socket=serverSocket.accept();
				System.out.println("1.클라이언트 소켓생성:"+socket);
				System.out.println("2.클라이언트 InputStream, OutputStream생성");		
				this.in=new BufferedReader(
						new InputStreamReader(
							socket.getInputStream()));
				
				this.out=new PrintWriter(
								new OutputStreamWriter(
										socket.getOutputStream()));
				
				
				while(true){
					System.out.println("4.클라이언트 로부터 데이타를 읽기위해무한대기, blocking");
					String readLine = in.readLine();
					System.out.println("5.클라이언트 로부터 데이타를 읽기:"+readLine);
					
					//받은데이터 UI에 출력
					csf.getChatTA().append("상대방 : "+readLine+"\n");
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
