import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionCatchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("strmt1");
		try {	//적극적 처리
			System.out.println("stmt1-1");
			FileInputStream fin = new FileInputStream("ab.txt");
			System.out.println("stmt1-2");
			int readChar = fin.read();
			System.out.println((char)readChar);
		} catch (IOException e) {	//예외 클래스의 상위로의 캐스팅
			System.out.println("catch stmt1-3");
			System.out.println("IOExecption:"+e.getMessage());
			System.out.println("catch stmt1-4");
		}
		
		System.out.println("strmt2");
		try{
			System.out.println("strmt2-1");
			Class.forName("One");
			System.out.println("strmt2-2");
		}catch (ClassNotFoundException e) {
			System.out.println("strmt2-3");
			System.out.println("ClassNotFoundException:"+e.getMessage());
			System.out.println("strmt2-4");
		}
		
		System.out.println("strmt3");
		
		
		
		System.out.println("strmt4");
		
		System.out.println("strmt5");
		
		System.out.println("strmt6");
		
		System.out.println("main return");
		
	}

}
