package chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
 *  - 클라이언트 소켓을 가지고있는 쓰레드 객체
 *  - 클라이언트의 소켓을 사용해서 데이터 전송, 수신을 위한 쓰레드 클래스 
 */
public class ChatClientThread extends Thread{
	private Socket socket;
	private BufferedReader in;	//소켓으로부터 데이터를 읽을 스트림
	private PrintWriter out;	//소켓에 데이터를 쓸 스트림
	private ChatClientFrame ccf;
	
	public ChatClientThread(ChatClientFrame chatClientFrame){
		ccf = chatClientFrame;
	}
	
	@Override
	public void run() {
		try {
			//클라이언트 소캣 생성		
			InetAddress[] address = new InetAddress[30];
			for(int i=0; i<30; i++){
				String ip = "192.168.12."+(i+0);
				address[i] = InetAddress.getByName(ip);
			}
			int i = 0;
			while(true){
					while(true){
						i = i%30;
						try{
							//socket = new Socket(addr.getHostAddress(), 7777);
							if(i!=15){
								
							
								socket = new Socket();
								socket.connect(new InetSocketAddress(address[i].getHostAddress(), 7777), 100);
								System.out.println("생성된 클라이언트 소켓 확인 : "+socket.getRemoteSocketAddress());
								break;
							}
						}catch(Exception e1){
							System.out.println("소켓 생성 실패 : "+address[i].toString());
						}
						i++;
					}
			
				
	
					//데이터 읽고 쓰는 스트림 연결
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					while(true){
						//서버로 부터 데이터 읽기(올때까지 대기, blocking 된다.)
						String readStr = in.readLine();
						System.out.println("받은 데이터 확인 : "+readStr);
						
						//서버에 데이터 쓰기 -> UI에서 처리
						ccf.getChatTA().append("상대방 : "+readStr+"\n");
					}
					
					
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//run()

	public void send(String data) {
		out.println(data);
		out.flush();
	}
	
	
	
}
