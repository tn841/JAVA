/*
������: 
   - ���α׷��ڵ带 �����Ű�� �� 
   - ���ξ�����,AWT ������,��������� ������
   - ���� �����--> �ΰ������� ���ÿ� �ؾ��Ҷ�..
 
 
- ����� ���� �����尴ü ����� ���(����)
     

		type A:
	1. Thread Ŭ������ ��ӹ޴´�.
	2. Thread class�� run method�� overriding �Ѵ�.
		�������:public void run()
	3. Thread ��ü�� �����Ѵ�.
	4. Thread�� ���۽�Ų��.
	
    	type B:
	1. Runnable interface�� implements �Ѵ�.
	2. Runnable interface�� implements �Ѱ�ü�� Thread Ŭ������ �����ڿ� �־ Thread ��ü�� �����Ѵ�
   	3. Thread �� ���۽�Ų��.

   ����>>
    1. Thread Ŭ������ ��ӹ޾Ƽ� �����..
      ex> class ThreadEx extends Thread{
          		// run �޽�带 ������ �ؾ��Ѵ�.
          		 public void run(){
          		 	//����ڰ����� ������ �� �������ڵ�
          		 }
          } 
    2. Runnable interface�� implements �ؼ������
      ex>  class ThreadImpl implements Runnable{
           		public void run(){
          		 }
           } 

*/
public class MainThreadMain {

	public static void main(String[] args) {
		Thread cThread = Thread.currentThread();	//���� �޼ҵ�, ��ȯŸ���� Thread, ���¸�ü -> �߻� �޼ҵ� 
		String cThreadName = cThread.getName();
		System.out.println("���� ������ �̸� : "+cThreadName);
		MainThreadCalled mtc = new MainThreadCalled();
		System.out.println("1. main ������");
		mtc.main_called_method();
		System.out.println("2. main ������");
	}

}
