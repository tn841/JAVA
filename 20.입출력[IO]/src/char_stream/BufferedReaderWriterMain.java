package char_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterMain {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader("BufferedReader.txt"));
		
		BufferedWriter bw=
				new BufferedWriter(
						new FileWriter("BufferedWriter.txt"));
		
		/**
		<< String java.io.BufferedReader.readLine() throws IOException >>
			Reads a line of text. 
			A line is considered to be 
			terminated by any one of a line feed ('\n'),
			a carriage return ('\r'),
			or a carriage return followed immediately by a linefeed.
		Returns:
			A String containing the contents of the line, 
			not including any line-termination characters, 
			or null if the end of the stream has been reached 
		 */
		
		String firstLine = br.readLine();
		System.out.println(firstLine);
		String secondLine = br.readLine();
		System.out.println(secondLine);
		int lineCount=0;
		
		while (true) {
			String readLine=br.readLine();
			if(readLine==null)break;
			lineCount++;
			bw.write(lineCount+":"+readLine);
			bw.newLine();
			System.out.print(lineCount+":"+readLine+"\n");
		}
		System.out.println(">>write BufferedWriter.txt");
		
		
		bw.write("버퍼드라이터");
		bw.newLine();
		bw.write("버퍼드라이터\n");
		bw.flush();
		
		System.out.println("line seperator:"+System.lineSeparator());
	}

}
