import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamThreadBlockingMain {

	public static void main(String[] args) throws Exception{
		InputStream consoleInput = System.in;	//byte Stream �ܼ� �Է�â�� ���� ����
		
		InputStreamReader isr = new InputStreamReader(consoleInput, "EUC-KR");	//consoleInput���� �� ����Ʈ�� �ƴ� �� ����Ʈ�� �о ���ڵ��ϱ� ���� �긴�� ��Ʈ��
		
		BufferedReader consoleReader = new BufferedReader(isr);	//character Stream �ܼ� �Է�â���� ���� �� ����Ʈ �� ..
		
		
		
		while(true){
			System.out.println(">> main Thread Blocking..");
			String readLine = consoleReader.readLine();
			System.out.println("readLine : "+readLine);
		}
	}

}
