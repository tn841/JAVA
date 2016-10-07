package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * ������ �����ִ� �����ð��� Ŭ���̾�Ʈ���� ���
 */
public class DayTimeClientMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 * 1. ���� ����
		 */
		Socket socket = new Socket("192.168.12.31", 8000);
		System.out.println("socket���� : "+socket);
		
		/*
		 * 2.������ ���̼��� �ҽ��̰� �ҽ��� ������ �ȾƼ� �����͸� �о�帮��.
		 */
		InputStream in = socket.getInputStream();	//�о�帮�� ���� ���� (1����Ʈ�� ���� - �ſ� ����)
		//BufferedInputStream bis = new BufferedInputStream(in);	//���۵� ��Ʈ���� �̿� (4����Ʈ�� �ѹ��� ���� - ������)
		InputStreamReader isr = new InputStreamReader(in,"EUC-KR");	//Reader�� �̿��Ͽ� �����б�..
		BufferedReader socketReader = new BufferedReader(isr);
	
		//System.out.println(socketReader.readLine());
	
		
		
		while(true){
			int readByte = in.read();
			System.out.print((char)readByte+"");
			if(readByte == -1){
				System.out.println("��");
				break;
			}
		}
		
		
		
	}

}
