package server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketMain {

	public static void main(String[] args) throws Exception {
		System.out.println("[Client] 0. ip�ּҰ� 192.168.12.12�� ������ 3333�� ��Ʈ�� ���Ͽ����û");
		Socket socket = new Socket("192.168.12.12", 3333);
		
		System.out.println("[Client] 1. ������ ���� �����ϸ� ���� ������ ������ ����");
		System.out.println("[Client] 2. ������ ����� ���� Ȯ�� : "+socket);
	}

}
