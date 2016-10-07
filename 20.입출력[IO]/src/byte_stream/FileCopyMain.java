package byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyMain {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("KakaoTalk_Setup.exe");
		FileOutputStream fos = new FileOutputStream("copy.exe");
		
		int count = 0;
		int starCount = 0;
		
		while(true){
			int readByte = fis.read();
			if(readByte == -1){
				break;
			}
			count++;
			if(count % 1000000 == 0){
				System.out.print("¡Ú");
				starCount++;
				if(starCount % 10 == 0){
					System.out.println();
				}
			}
			fos.write(readByte);
		}
		System.out.println();
		fis.close();
		fos.close();
		
		System.out.println(">>  copy complete - "+count);
	}

}
