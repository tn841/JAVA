package char_stream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriterMain {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("fileWriter.txt");
		
		/**
		 * public void write(int c) throws IOException
			
			Writes a single character. 
			The character to be written is contained in the 16 low-order bits of the given integer value; 
			the 16 high-order bits are ignored.
			
			Subclasses that intend to support efficient single-character output should override this method.
			
			Write�޼ҵ�� �� ���ڸ� write�Ѵ�.
			�������� �� ���ڴ� ���ڷ� ���޵Ǵ� ������ ���� 16��Ʈ�� ����ִ�. ���� 16��Ʈ�� ���õȴ�.
		 */
		
		fw.write("�����");
		fw.write('A');
		char[] chArr = {'��', '��', '��', '��'};
		fw.write(chArr);
		
		
	
		for(int i=0; i<65536; i++){
			fw.write(i);
			if(i%100 == 0){
				fw.write('\n');
			}
		}
		
		fw.flush();	//���۸� ����־�� ���Ⱑ ����ȴ�.
		fw.close();
				
		System.out.println(">> write fileWriter.txt");
		
		
		FileReader fr = new FileReader("fileWriter.txt");
		
		/**
		public int read() throws IOException
		 
		Reads a single character. 
		This method will block until a character is available, an I/O error occurs, 
		or the end of the stream is reached.
		�� ���ڸ� �д´�.
		�� �޼ҵ�� �� ���ڰ� �б� �����Ҷ����� block�ȴ�.
		
		Returns:
		The character read, as an integer in the range 0 to 65535 (0x00-0xffff), 
		or -1 if the end of the stream has been reached
		��ȯ��:
		�о��� ����, 0~65535������ �������·� ��ȯ, ��Ʈ���� ���� �����ϸ� -1�� ��ȯ
		 */
		
		int readChar = fr.read();	//�ι���Ʈ �о ������ ����
		System.out.println(readChar);
		
		while((readChar = fr.read()) != -1   ){
			System.out.print((char)readChar);
		}
		
	}

}
