package byte_stream.filter_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamMain {

	public static void main(String[] args) throws Exception {
		DataOutputStream dos = new DataOutputStream(
				new FileOutputStream("filter_data.txt"));
	
		Student st1 = new Student(2147483647, "sumin", 89.52, 'B', 470);//21474836472147483647214748364721474836472147483647
		
		dos.writeInt(st1.no);	//stream�� �⺻������ ������ 1byte�� ����. writeInt �޼ҵ� ���������� 1byte�� 4ȸ write�Ͽ� ���� �����͸� ���ϰ� �Է��� �� �ִ�.
		dos.writeUTF(st1.name);
		dos.writeDouble(st1.avg);
		dos.writeChar(st1.grade);
		dos.writeBoolean(true);
		
		System.out.println(">> write filter_data.txt");
		
		
		System.out.println(">> read filter_data.txt");
		DataInputStream dis = new DataInputStream(
				new FileInputStream("filter_data.txt"));
		
		System.out.println(dis.readInt());
		System.out.println(dis.readUTF());
		System.out.println(dis.readDouble());
		System.out.println(dis.readChar());
		System.out.println(dis.readBoolean());
		
		
		dos.close();
		dis.close();
		
		
		DataOutputStream studentDos = new DataOutputStream(
				new FileOutputStream("student"));
		
		Student st2 = new Student(2147483647, "sumin", 89.52, 'B', 470);
		studentDos.writeInt(st2.no);
		studentDos.writeUTF(st2.name);
		studentDos.writeDouble(st2.avg);
		studentDos.writeChar(st2.grade);
		
		DataInputStream stDis = new DataInputStream(
				new FileInputStream("student"));

		System.out.println(Integer.toBinaryString(stDis.readInt()));
		System.out.println(stDis.readUTF());
		System.out.println(stDis.readDouble());
		System.out.println(stDis.readChar());
		
		studentDos.close();
		stDis.close();
		
		
		
		
		
	}

}
//2147483647 2147483647 2147483647 2147483647