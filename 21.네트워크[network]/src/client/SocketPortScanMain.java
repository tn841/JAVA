package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketPortScanMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		for(int port = 0; port< 65536; port++){
			try{
				Socket socket = new Socket("www.naver.com",port);	//�������� ������ DNS���� IP�ּҸ� ������
				System.out.println(port+"��Ʈ ���� ����");
			}catch(Exception e){
				
			}
		}
		
	}

}
