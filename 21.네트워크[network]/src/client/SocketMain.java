package client;

import java.net.Socket;

public class SocketMain {

	public static void main(String[] args) throws Exception{
		Socket socket=new Socket("125.209.222.142", 80);
		System.out.println("connect:"+socket);

	}

}
