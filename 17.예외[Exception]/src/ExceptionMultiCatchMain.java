import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExceptionMultiCatchMain {

	public static void main(String[] args) {
		try{
			System.out.println("stmt1");
			System.out.println("stmt1-1");
			FileInputStream fis = new FileInputStream("a.txt");
			System.out.println("stmt1-2");
			int readChar = fis.read();
			System.out.println((char) readChar);
			System.out.println("stmt1-3");
			System.out.println("stmt2");
			System.out.println("stmt2-1");
			Class.forName("One");
			System.out.println("stmt2-2");
			System.out.println("main return");
		}catch (FileNotFoundException e) {
			System.out.println("catch FileNotFoundException:"+e.getMessage());
		}catch (IOException e) {
			System.out.println("catch IOException:"+e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("catch ClassNotFoundException:"+e.getMessage());
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

}
