package client;

import java.net.InetAddress;
import java.net.Socket;

public class SocketMain {

	public static void main(String[] args) throws Exception{
		Socket socket=new Socket("125.209.222.142", 80);	//���̹��� ���� ����, ������ �Ʒ��� 4�� ������ ������.
															//���̹� ������ 80��Ʈ�� ���� ������ ���� �غ� �ϰ� �ֱ� ������ ������ �Ǵ� ��.
		System.out.println("connect:"+socket);
		
		InetAddress remoteAddr = socket.getInetAddress();	//���̹� �� IP
		int remotePort = socket.getPort();					//���̹� �� Port
		InetAddress localAddr = socket.getLocalAddress();	//�� ���� IP
		int localPort = socket.getLocalPort();;				//�� ���� Port
		
		System.out.println("���̹� : "+remoteAddr + " - "+ remotePort);
		System.out.println("���� : "+localAddr + " - "+ localPort);
		
		socket.close();//���� �ݱ�
		
	}

}
