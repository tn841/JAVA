package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * 서버가 보내주는 서버시간을 클라이언트에서 출력
 */
public class DayTimeClientMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 * 1. 소켓 생성
		 */
		Socket socket = new Socket("192.168.12.31", 8000);
		System.out.println("socket생성 : "+socket);
		
		/*
		 * 2.소켓이 데이서의 소스이고 소스에 빨때를 꽂아서 데이터를 읽어드리자.
		 */
		InputStream in = socket.getInputStream();	//읽어드리는 빨대 생성 (1바이트씩 읽음 - 매우 불편)
		//BufferedInputStream bis = new BufferedInputStream(in);	//버퍼드 스트림을 이용 (4바이트씩 한번에 읽음 - 편해짐)
		InputStreamReader isr = new InputStreamReader(in,"EUC-KR");	//Reader를 이용하여 문자읽기..
		BufferedReader socketReader = new BufferedReader(isr);
	
		//System.out.println(socketReader.readLine());
	
		
		
		while(true){
			int readByte = in.read();
			System.out.print((char)readByte+"");
			if(readByte == -1){
				System.out.println("끝");
				break;
			}
		}
		
		
		
	}

}
