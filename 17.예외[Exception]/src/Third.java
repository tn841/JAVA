import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Third {
	public void third() throws IOException{	//third�޼ҵ�� IO���ܰ� �߻��� �� �ִ�. (Socket������)
		System.out.println("\t\t\tThird.third() ����");
		
		/*
		 * ���ܹ߻�
		 * 	- �����带 �����ϰ� ����ó���� �����Ѵ�.
		 */
		/*********************************************
		 * 
		 **********************************************/
		
		/*********************************************
		 * JVM�� Error ��Ȳ�̹߻��ϸ�
		 * NullPointerException��ü�� ����� thorw 
		 **********************************************/
		/*
		String str = null;
		int len = str.length();
		*/
		
		/***********************************************
		 * �����ڰ� ���� Ư����Ȳ����
		 * NullPointerException��ü�� ����� Throw
		 ***********************************************/
		/*
		boolean isError = true;
		if(isError){
			throw new NullPointerException("�� ������ �ַλ��� �߻�");	//���⼭ throw��ü�� ����� third�޼ҵ带 ȣ���� �������� throw��ü�� ������.
		}
		*/
		
		/*######## ��RuntimeException ############*/
		Socket socket = new Socket("www.google.com", 80);
		System.out.println(socket.toString());
		
		FileInputStream fin = new FileInputStream("a.txt");
		int readChar = fin.read();
		
		
		
		System.out.println("\t\t\tThird.third() ��ȯ");
		return;
	}
}
