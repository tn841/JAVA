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
			
			Write메소드는 한 문자를 write한다.
			쓰여지는 한 문자는 인자로 전달되는 정수의 하위 16비트에 담겨있다. 상위 16비트는 무시된다.
		 */
		
		fw.write("김수민");
		fw.write('A');
		char[] chArr = {'동', '해', '물', '과'};
		fw.write(chArr);
		
		
	
		for(int i=0; i<65536; i++){
			fw.write(i);
			if(i%100 == 0){
				fw.write('\n');
			}
		}
		
		fw.flush();	//버퍼를 비워주어야 쓰기가 진행된다.
		fw.close();
				
		System.out.println(">> write fileWriter.txt");
		
		
		FileReader fr = new FileReader("fileWriter.txt");
		
		/**
		public int read() throws IOException
		 
		Reads a single character. 
		This method will block until a character is available, an I/O error occurs, 
		or the end of the stream is reached.
		한 문자를 읽는다.
		이 메소드는 한 문자가 읽기 가능할때까지 block된다.
		
		Returns:
		The character read, as an integer in the range 0 to 65535 (0x00-0xffff), 
		or -1 if the end of the stream has been reached
		반환값:
		읽어진 문자, 0~65535범위의 정수형태로 반환, 스트림의 끝에 도달하면 -1을 반환
		 */
		
		int readChar = fr.read();	//두바이트 읽어서 변수에 저장
		System.out.println(readChar);
		
		while((readChar = fr.read()) != -1   ){
			System.out.print((char)readChar);
		}
		
	}

}
