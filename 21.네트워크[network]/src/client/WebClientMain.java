package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WebClientMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 1. socket����
		 */
		Socket socket = new Socket("www.naver.com", 80);
		System.out.println(socket);
		
		/*
		 *  2. Input/OutputStream ����
		 */
		InputStream in = socket.getInputStream();
		
		OutputStream out = socket.getOutputStream();
		
		
		/*
		 *  3. http ������ �а� ����
		 */
		String httpRequest = "GET /index.html HTTP/1.0\r\n\r\n";	//http ��Ģ �����ֱ����� �۾�
		out.write(httpRequest.getBytes());
		out.flush();
		
		
		while(true){
			int readByte = in.read();
			System.out.print((char)readByte);
			if(readByte == -1){
				break;
			}
		}
		
		socket.close();
		
	}

}
