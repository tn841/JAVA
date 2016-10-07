package byte_stream;

import java.io.FileOutputStream;

/*
 * 	1. Data target(��ǥ) ���ϱ� : ����
 * 	2. OutputStream��ü(����) ����
 * 	3. OutputStream��ü�� �̿��Ͽ� �ѹ���Ʈ�� write�Ѵ�.
 * 	4. OutputStream��ü�� Close�Ѵ�.
 */
public class FileOutputStreamMain {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("fileOut.gif");	//FileOutputStream ��ü fos ���� �� ����
		/**
		 * public abstract void write(int b)throws IOException
			Writes the specified byte to this output stream. 
			The general contract for write is that one byte is written to the output stream. 
			The byte to be written is the eight low-order bits of the argument b. 
			The 24 high-order bits of b are ignored.
			Subclasses of OutputStream must provide an implementation for this method.
			
			outputstream��ü�� Ư�� ����Ʈ�� Write�Ѵ�.
			write�� ���� �Ϲ����� ����� �� ����Ʈ�� outputstream�� ������ �ٴ� ���̴�.
			�������� �� ����Ʈ�� ���� b�� ���� 8��Ʈ�̴�.
			���� 24��Ʈ�� ���õȴ�.
			OutputStream�� �ڽ�Ŭ�������� write�޼ҵ带 �ݵ�� �����ؾ��Ѵ�.
		 */
		fos.write(65);	//�� ����Ʈ ����
		fos.write('A');	//�� ����Ʈ ����
		
		for(int i=0; i< 255; i++){
			fos.write(i);
		}
		
		fos.write('\n');
		
		fos.write(2147483647);	// 4����Ʈ ������ ǥ���Ҽ� �ִ� �ִ� ���ͷ� �� 11111111 11111111 11111111 11111111
		fos.write(255);	//1����Ʈ ���� �ִ� ���ͷ� 11111111
		
		//���� 1����Ʈ�� write�ϱ� ������ write�� ���� ����.
		//write(int b)���� ���ڷ� intŸ���� ���� ������ �����ϱ�?
		
		
		fos.close();	//fos��ü close
		System.out.println(">> file is written.");
		
	}

}
