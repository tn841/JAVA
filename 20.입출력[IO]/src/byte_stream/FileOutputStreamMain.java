package byte_stream;

import java.io.FileOutputStream;

/*
 * 	1. Data target(목표) 정하기 : 파일
 * 	2. OutputStream객체(빨대) 생성
 * 	3. OutputStream객체를 이용하여 한바이트씩 write한다.
 * 	4. OutputStream객체를 Close한다.
 */
public class FileOutputStreamMain {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("fileOut.gif");	//FileOutputStream 객체 fos 선언 및 생성
		/**
		 * public abstract void write(int b)throws IOException
			Writes the specified byte to this output stream. 
			The general contract for write is that one byte is written to the output stream. 
			The byte to be written is the eight low-order bits of the argument b. 
			The 24 high-order bits of b are ignored.
			Subclasses of OutputStream must provide an implementation for this method.
			
			outputstream객체에 특정 바이트를 Write한다.
			write에 대한 일반적인 약속은 한 바이트가 outputstream에 쓰여진 다는 것이다.
			쓰여지는 한 바이트는 인자 b의 하위 8비트이다.
			상위 24비트는 무시된다.
			OutputStream의 자식클래스들은 write메소드를 반드시 구현해야한다.
		 */
		fos.write(65);	//한 바이트 쓰기
		fos.write('A');	//한 바이트 쓰기
		
		for(int i=0; i< 255; i++){
			fos.write(i);
		}
		
		fos.write('\n');
		
		fos.write(2147483647);	// 4바이트 정수로 표현할수 있는 최대 리터럴 즉 11111111 11111111 11111111 11111111
		fos.write(255);	//1바이트 정수 최대 리터럴 11111111
		
		//하위 1바이트만 write하기 때문에 write된 값은 같다.
		//write(int b)에서 인자로 int타입을 쓰는 이유는 무엇일까?
		
		
		fos.close();	//fos객체 close
		System.out.println(">> file is written.");
		
	}

}
