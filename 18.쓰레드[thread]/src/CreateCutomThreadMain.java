
public class CreateCutomThreadMain {

	public static void main(String[] args) {
		
		
		
		System.out.println("1. main");
		CreateCustomThread cct = new CreateCustomThread();
		
		/*
		 public void start()
		Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread. 
		The result is that two threads are running concurrently
		 */
		//cct.start();	//����� ���� ������ ����� ����. �������� ���ο� ������ ����
		CreateUpperAThread cut = new CreateUpperAThread();
		cut.start();
	
		
		System.out.println("2. main return");
		
		
		
	}

}
