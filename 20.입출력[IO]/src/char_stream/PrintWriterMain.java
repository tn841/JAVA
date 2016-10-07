package char_stream;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(
				new FileWriter("PrintWriter.txt"));
		
		pw.write('��');
		pw.write('��');
		pw.write('��');
		
		pw.print("�����");
		pw.println("�����");
		
		pw.write('1');
		pw.write('2');
		pw.write('3');
		pw.write('4');
		
		pw.flush();
	}

}
