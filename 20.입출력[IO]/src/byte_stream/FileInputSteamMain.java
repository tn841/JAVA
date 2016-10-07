package byte_stream;

import java.io.FileInputStream;

/*
 * 	1. DataSoure선정 -> 파일
 * 	2. InputStream객체 생성(빨대)
 * 	3. InputStream객체를 사용하여 파일로부터 한 바이트 씩 read한다. (무한히 read할 수도 있다.)
 * 	4. InputStream객체 닫기
 */
public class FileInputSteamMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("fileOut.txt");	//FileInputStream객체 선언 및 생성
		
		
		/**
		 * public abstract int read() throws IOException
		 * 
			Reads the next byte of data from the input stream. 
			The value byte is returned as an int in the range 0 to 255. 
			If no byte is available because the end of the stream has been reached, the value -1 is returned. 
			This method blocks until input data is available, the end of the stream is detected, or an exception is thrown. ★★★ (읽기가능 할때 까지 block된다!)
			A subclass must provide an implementation of this method.
			
			inputStream객체의 다음 데이터의 byte를 read한다.
			0~255 범위의 int 값이 반환된다.
			스트림의 끝에 도달하여 read할 byte가 없는 경우 -1이 반환된다.
			read메소드는 데이터가 사용가능할때 까지 block한다, 스트림의 끝은 포착된다, 또는 예외는 throw된다. (소켓 read 할 경우)
			
		 */
		int readByte = fis.read();
		System.out.println("read bytes : "+Integer.toBinaryString(readByte));
		readByte = fis.read();
		System.out.println("read bytes : "+Integer.toBinaryString(readByte));
		

		while((readByte = fis.read())!=-1){	//읽은 값이 -1이면 파일의 끝이라는 뜻
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
