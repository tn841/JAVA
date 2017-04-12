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
	
	
	public void readFile(){	//���� �б�
		try{
			while((data = in2.available()) != 0)	//���� ������ �д´�.
			{
				buffer = new byte[data];	//byte�� �迭 buffer �����͸� ���
				in2.read(buffer);			//�� buffer�� ��� �����͸� �д´�.
				
				String str = new String(buffer);	//�����͸� ���ڿ��� ����
				String[] str2 = str.split("\n");	//"\n" �������� ���ڸ� ����
					
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
	
	
	public void descendingSort(){	//�������� ���� �޼ҵ�
		Collections.sort(vList);	//vector�� ������������ ����
		Collections.reverse(vList);	//���� �ڹٲٱ�
	}//descendingSort()
	
	public void writeFile(){	//���� ����
		try{
			out = new FileOutputStream("score.txt");
			out2 = new DataOutputStream(out);
			
			
			
			for(int i=0; i<vList.size(); i++){
				String str = vList.get(i);	//vector�� ����� ������� ����		
				out2.writeBytes(str);
				out2.writeBytes("\n");
			}
			
			out2.close();
			out.close();
		}catch(Exception e){}
	}//writeFile()
	
}//RankManager class

