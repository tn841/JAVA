package byte_stream.filter_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedFileCopyMain {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("KakaoTalk_Setup.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("copy22.exe");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int count = 0;
		int starCount = 0;
		
		while(true){
			int readByte = bis.read();
			if(readByte == -1){
				break;
			}
			count++;
			if(count % 1000000 == 0){
				System.out.print("★");
				starCount++;
				if(starCount % 10 == 0){
					System.out.println();
				}
			}
			bos.write(readByte);
		}
		System.out.println();
		bis.close();
		fis.close();
		
		bos.close();
		fos.close();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(">>  copy complete - "+count + " 걸린시간 : "+(endTime - startTime)+"ms");
	}

}
