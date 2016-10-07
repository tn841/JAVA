package byte_stream.filter_stream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {

public static void main(String[] args) throws Exception {
		
		FileOutputStream fos=
				new FileOutputStream("PrintStream.txt");
		PrintStream ps=new PrintStream(fos);
		
		
		//ps.write(49);
		//ps.write(50);
		//ps.write(51);
		
		ps.write('1');
		ps.write('2');
		ps.write('3');
		
		ps.print(123);
		ps.print("123");
		
		ps.write('t');
		ps.write('r');
		ps.write('u');
		ps.write('e');
		
		ps.print(true);
		ps.print("true");
		
		ps.write(51);
		ps.write(52);
		ps.write('.');
		ps.write(53);
		ps.write(53);
		
		ps.print(34.55);
		ps.print("34.55");
		
		/*
		ps.write('김');
		ps.write('경');
		ps.write('호');
		*/
		ps.print(new Object());
		ps.println();
		ps.println("김경호");
		ps.println("라인종결자");
		ps.println();
		ps.println();
		ps.println();
		ps.println();
		ps.flush();
		
		System.out.println(">> print PrintStream.txt");
		System.out.println("--------System.out-------");
		System.out.println(23.56);
		System.out.println(true);
		System.out.println("print");
		System.out.println('A');
		System.out.println(new Object().toString());
		System.out.println(21321);
	}

}
