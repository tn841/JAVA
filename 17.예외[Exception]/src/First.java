import java.io.IOException;

public class First {
	public void first() throws IOException{
		System.out.println("\tFirst.first() ����");
		Second second = new Second();
		second.second();
		System.out.println("\tFirst.first() ��ȯ");
		return;
	}
}
