package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketPortScanMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		for(int port = 20; port< 22; port++){
			try{
				Socket socket = new Socket("www.microsoft.com",port);	//�������� ������ DNS���� IP�ּҸ� ������
				System.out.println(port+"��Ʈ ���� ����");
			}catch(Exception e){
				System.out.println(port+"��Ʈ ���� ���� ����");
			}
		}
		
	}

}
