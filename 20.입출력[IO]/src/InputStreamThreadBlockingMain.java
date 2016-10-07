import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamThreadBlockingMain {

	public static void main(String[] args) throws Exception{
		InputStream consoleInput = System.in;	//byte Stream 콘솔 입력창에 대한 빨대
		
		InputStreamReader isr = new InputStreamReader(consoleInput, "EUC-KR");	//consoleInput에서 한 바이트가 아닌 두 바이트를 읽어서 인코딩하기 위한 브릿지 스트림
		
		BufferedReader consoleReader = new BufferedReader(isr);	//character Stream 콘솔 입력창으로 부터 두 바이트 씩 ..
		
		
		
		while(true){
			System.out.println(">> main Thread Blocking..");
			String readLine = consoleReader.readLine();
			System.out.println("readLine : "+readLine);
		}
	}

}
