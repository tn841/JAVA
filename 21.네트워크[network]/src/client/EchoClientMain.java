package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientMain {

	public static void main(String[] args) throws Exception{
		try{
			//1. 소켓 생성
			Socket socket = new Socket("192.168.12.31", 9999);
			System.out.println("생성된 소켓 정보:"+socket);
		
		
			//2. 데이터 전송 및 수신을 위한 스트림들 생성
			OutputStream os = socket.getOutputStream();				//OutputStream생성
			OutputStreamWriter osw = new OutputStreamWriter(os);	//OutputStreamWriter(브릿지 스트림), 문자 다루기
			//PrintWriter pw = new PrintWriter(osw);				//PrintWriter로 한 line의 문자열 전송 ( println() )
			//BufferedWriter bw = new BufferedWriter(osw);			//write() -> newLine() 해줘야함
			
			
			InputStream is = socket.getInputStream();				//소켓으로 부터 데이터를 읽는다.
			InputStreamReader isr = new InputStreamReader(is);		//문자 처리를 위해 InputStreamReader 브릿지 스트림으로 감쌈
			BufferedReader br = new BufferedReader(isr);			//문자한 Line읽는 필터 스트림으로 최종 감쌈
			
			
			//3. 스트림을 이용해서 서버에 데이터 쓰기 (서버는 한 Line만 읽기로 규칙이 정해져있음)
			String sendData = "동해물과 백두산이 마르고 닳도록";
			osw.write(sendData);
			osw.write("\n");	//line 종결자
			osw.flush();
			
			/*
			 * PrintWriter 이용
			 */
			//pw.println(sendData);
			//pw.flush();
			
			
			/*
			 * BufferedWriter 이용
			 */
//			bw.write(sendData);
//			bw.newLine();
//			bw.flush();
			
			
			//4. 스트림을 이용해서 서버로부터 데이터 읽기
			System.out.println("서버에서 온 데이터 : " +br.readLine());
		
		}catch(Exception e){
			System.out.println("소캣 생성 실패");
		}
		
	}

}
