package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WebClientMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 1. socket생성
		 */
		Socket socket = new Socket("www.naver.com", 80);
		System.out.println(socket);
		
		/*
		 *  2. Input/OutputStream 생성
		 */
		InputStream in = socket.getInputStream();
		
		OutputStream out = socket.getOutputStream();
		
		
		/*
		 *  3. http 데이터 읽고 쓰기
		 */
		String httpRequest = "GET /index.html HTTP/1.0\r\n\r\n";	//http 규칙 맞춰주기위한 작업
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
