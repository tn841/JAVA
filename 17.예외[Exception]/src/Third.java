import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Third {
	public void third() throws IOException{	//third메소드는 IO예외가 발생할 수 있다. (Socket때문에)
		System.out.println("\t\t\tThird.third() 실행");
		
		/*
		 * 예외발생
		 * 	- 쓰레드를 중지하고 예외처리를 시작한다.
		 */
		/*********************************************
		 * 
		 **********************************************/
		
		/*********************************************
		 * JVM이 Error 상황이발생하면
		 * NullPointerException객체를 만들고 thorw 
		 **********************************************/
		/*
		String str = null;
		int len = str.length();
		*/
		
		/***********************************************
		 * 개발자가 직접 특정상황에서
		 * NullPointerException객체를 만들고 Throw
		 ***********************************************/
		/*
		boolean isError = true;
		if(isError){
			throw new NullPointerException("널 포인터 애로사항 발생");	//여기서 throw객체를 만들어 third메소드를 호출한 방향으로 throw객체를 던진다.
		}
		*/
		
		/*######## 비RuntimeException ############*/
		Socket socket = new Socket("www.google.com", 80);
		System.out.println(socket.toString());
		
		FileInputStream fin = new FileInputStream("a.txt");
		int readChar = fin.read();
		
		
		
		System.out.println("\t\t\tThird.third() 반환");
		return;
	}
}
