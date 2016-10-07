package byte_stream.filter_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferdInputOutputStreamMain {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("filterBuffer.exe");	//�⺻ node ��Ʈ��
		BufferedOutputStream bos = new BufferedOutputStream(fos);	//BufferedOutputStream�� �⺻ �����ڰ� ����. �⺻ node ��Ʈ���� ���ڷ� ����
//		bos.write('A');
//		bos.write(65);
//		bos.write(66);
//		bos.write(67);
//		
//		for (int i = 0; i < 256; i++) {
//			bos.write(i);
//		}
		
	
		
		FileInputStream fis = new FileInputStream("KakaoTalk_Setup.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int read;
		int count = 0, line = 0;
		while( (read = bis.read()) != -1  ){
			bos.write(read);
			count++;
			if(count % 1000000 == 0){
				System.out.print("��");
				line++;
				if(line % 10 ==0){
					System.out.println();
				}
			}
			
		}
		
		bos.close();	//���� �ݰ�
		fos.close();	//�⺻(���) �ݱ�
		
		bis.close();
		fis.close();
		
		System.out.println();
		System.out.println();
		System.out.println("copy complete >> "+count+"bytes");
		
	}

}
