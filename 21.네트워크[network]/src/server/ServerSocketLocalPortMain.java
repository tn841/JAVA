package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketLocalPortMain {

	public static void main(String[] args) {
		for (int port = 1; port <1000; port++) {
			
			try {
				System.out.println("0.��Ʈ "+port+" ���� ServerSocket���� �õ�");
				ServerSocket serverSocket=new ServerSocket(port);
				System.out.println("1.��Ʈ "+port+" ���� ServerSocket���� ����");
			
			} catch (IOException e) {
				//�̹� ������ ��Ʈ�� Ȯ���� �� �ִ�.
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 2.��Ʈ "+port+" ���� ServerSocket���� ����");
			}
			
		}

	}

}
