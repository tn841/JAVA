package chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
 *  - Ŭ���̾�Ʈ ������ �������ִ� ������ ��ü
 *  - Ŭ���̾�Ʈ�� ������ ����ؼ� ������ ����, ������ ���� ������ Ŭ���� 
 */
public class ChatClientThread extends Thread{
	private Socket socket;
	private BufferedReader in;	//�������κ��� �����͸� ���� ��Ʈ��
	private PrintWriter out;	//���Ͽ� �����͸� �� ��Ʈ��
	private ChatClientFrame ccf;
	
	public ChatClientThread(ChatClientFrame chatClientFrame){
		ccf = chatClientFrame;
	}
	
	@Override
	public void run() {
		try {
			//Ŭ���̾�Ʈ ��Ĺ ����		
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
								System.out.println("������ Ŭ���̾�Ʈ ���� Ȯ�� : "+socket.getRemoteSocketAddress());
								break;
							}
						}catch(Exception e1){
							System.out.println("���� ���� ���� : "+address[i].toString());
						}
						i++;
					}
			
				
	
					//������ �а� ���� ��Ʈ�� ����
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					while(true){
						//������ ���� ������ �б�(�ö����� ���, blocking �ȴ�.)
						String readStr = in.readLine();
						System.out.println("���� ������ Ȯ�� : "+readStr);
						
						//������ ������ ���� -> UI���� ó��
						ccf.getChatTA().append("���� : "+readStr+"\n");
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
