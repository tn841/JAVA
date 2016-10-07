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
			//1. ���� ����
			Socket socket = new Socket("192.168.12.31", 9999);
			System.out.println("������ ���� ����:"+socket);
		
		
			//2. ������ ���� �� ������ ���� ��Ʈ���� ����
			OutputStream os = socket.getOutputStream();				//OutputStream����
			OutputStreamWriter osw = new OutputStreamWriter(os);	//OutputStreamWriter(�긴�� ��Ʈ��), ���� �ٷ��
			//PrintWriter pw = new PrintWriter(osw);				//PrintWriter�� �� line�� ���ڿ� ���� ( println() )
			//BufferedWriter bw = new BufferedWriter(osw);			//write() -> newLine() �������
			
			
			InputStream is = socket.getInputStream();				//�������� ���� �����͸� �д´�.
			InputStreamReader isr = new InputStreamReader(is);		//���� ó���� ���� InputStreamReader �긴�� ��Ʈ������ ����
			BufferedReader br = new BufferedReader(isr);			//������ Line�д� ���� ��Ʈ������ ���� ����
			
			
			//3. ��Ʈ���� �̿��ؼ� ������ ������ ���� (������ �� Line�� �б�� ��Ģ�� ����������)
			String sendData = "���ع��� ��λ��� ������ �⵵��";
			osw.write(sendData);
			osw.write("\n");	//line ������
			osw.flush();
			
			/*
			 * PrintWriter �̿�
			 */
			//pw.println(sendData);
			//pw.flush();
			
			
			/*
			 * BufferedWriter �̿�
			 */
//			bw.write(sendData);
//			bw.newLine();
//			bw.flush();
			
			
			//4. ��Ʈ���� �̿��ؼ� �����κ��� ������ �б�
			System.out.println("�������� �� ������ : " +br.readLine());
		
		}catch(Exception e){
			System.out.println("��Ĺ ���� ����");
		}
		
	}

}
