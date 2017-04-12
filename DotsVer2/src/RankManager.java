import java.io.*;
import java.util.*;


public class RankManager {
	public static Vector<String> vList = new Vector<String>();
	private FileWriter fw;
	private BufferedWriter bufferW;
	private FileInputStream in;
	private DataInputStream in2;
	private FileOutputStream out;
	private DataOutputStream out2;
	private int data;

	private byte[] buffer;
	private String str;
	private String[] str2;
	
	public RankManager()
	{
		try{
		in = new FileInputStream("score.txt");
		in2 = new DataInputStream(in);
		
		int data = 0;
		BufferedWriter bufferW;
		byte[] buffer;
		}catch(Exception e){}
		
	}//RankManger()
	
	
	public void readFile(){	//파일 읽기
		try{
			while((data = in2.available()) != 0)	//파일 끝까지 읽는다.
			{
				buffer = new byte[data];	//byte형 배열 buffer 데이터를 담고
				in2.read(buffer);			//그 buffer에 담긴 데이터를 읽는다.
				
				String str = new String(buffer);	//데이터를 문자열에 저장
				String[] str2 = str.split("\n");	//"\n" 기준으로 문자를 나눔
					
				for(int i=0; i<str2.length; i++){
					str2[i] = str2[i].replace("\r", "");
					vList.add(str2[i]);
				}
			}
				
//			for(int i=0; i<vList.size(); i++){
//				System.out.println(vList.get(i));
//			}
//			System.out.println("vector size : "+vList.size());
				
			in2.close();
			in.close();
				
			}catch(Exception e){}
	}//readFile()
	
	
	public void descendingSort(){	//내림차순 정렬 메소드
		Collections.sort(vList);	//vector를 오름차순으로 정렬
		Collections.reverse(vList);	//순서 뒤바꾸기
	}//descendingSort()
	
	public void writeFile(){	//파일 쓰기
		try{
			out = new FileOutputStream("score.txt");
			out2 = new DataOutputStream(out);
			
			
			
			for(int i=0; i<vList.size(); i++){
				String str = vList.get(i);	//vector에 저장된 순서대로 저장		
				out2.writeBytes(str);
				out2.writeBytes("\n");
			}
			
			out2.close();
			out.close();
		}catch(Exception e){}
	}//writeFile()
	
}//RankManager class

