package chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
			socket = new Socket("192.168.12.12", 7777);
			System.out.println("������ Ŭ���̾�Ʈ ���� Ȯ�� : "+socket);
			
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
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//run()

	public void send(String data) {
		out.println(data);
		out.flush();
	}
	
	
	
}
