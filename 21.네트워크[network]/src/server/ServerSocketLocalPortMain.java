package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketLocalPortMain {

	public static void main(String[] args) {
		for (int port = 1; port <1000; port++) {
			
			try {
				System.out.println("0.포트 "+port+" 번에 ServerSocket생성 시도");
				ServerSocket serverSocket=new ServerSocket(port);
				System.out.println("1.포트 "+port+" 번에 ServerSocket생성 성공");
			
			} catch (IOException e) {
				//이미 점유된 포트를 확인할 수 있다.
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> 2.포트 "+port+" 번에 ServerSocket생성 실패");
			}
			
		}

	}

}
