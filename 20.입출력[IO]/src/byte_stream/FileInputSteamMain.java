package byte_stream;

import java.io.FileInputStream;

/*
 * 	1. DataSoure���� -> ����
 * 	2. InputStream��ü ����(����)
 * 	3. InputStream��ü�� ����Ͽ� ���Ϸκ��� �� ����Ʈ �� read�Ѵ�. (������ read�� ���� �ִ�.)
 * 	4. InputStream��ü �ݱ�
 */
public class FileInputSteamMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fileOut.txt");	//FileInputStream��ü ���� �� ����
		
		
		/**
		 * public abstract int read() throws IOException
		 * 
			Reads the next byte of data from the input stream. 
			The value byte is returned as an int in the range 0 to 255. 
			If no byte is available because the end of the stream has been reached, the value -1 is returned. 
			This method blocks until input data is available, the end of the stream is detected, or an exception is thrown. �ڡڡ� (�бⰡ�� �Ҷ� ���� block�ȴ�!)
			A subclass must provide an implementation of this method.
			
			inputStream��ü�� ���� �������� byte�� read�Ѵ�.
			0~255 ������ int ���� ��ȯ�ȴ�.
			��Ʈ���� ���� �����Ͽ� read�� byte�� ���� ��� -1�� ��ȯ�ȴ�.
			read�޼ҵ�� �����Ͱ� ��밡���Ҷ� ���� block�Ѵ�, ��Ʈ���� ���� �����ȴ�, �Ǵ� ���ܴ� throw�ȴ�. (���� read �� ���)
			
		 */
		int readByte = fis.read();
		System.out.println("read bytes : "+Integer.toBinaryString(readByte));
		readByte = fis.read();
		System.out.println("read bytes : "+Integer.toBinaryString(readByte));
		

		while((readByte = fis.read())!=-1){	//���� ���� -1�̸� ������ ���̶�� ��
			System.out.println("read bytes : "+Integer.toBinaryString(readByte));
		}
		System.out.println();

		
//		while(true){
//			readByte = fis.read();
//			if(readByte == -1){
//				break;
//			}
//			System.out.println(Integer.toBinaryString(readByte));
//		}
		
		fis.close();

	}

}
