import java.io.IOException;

public class Second {
	public void second() throws IOException{	
		System.out.println("\t\tSecond.second() ����");
		Third third = new Third();
		third.third();
		System.out.println("\t\tSecond.second() ��ȯ");
		return;
	}
}
