/*
�߻�Ŭ����
  1.����: �ϳ��̻��� �߻�޼ҵ尡 ���ǵǾ��ִ� Ŭ����
     ex> public abstract class Test{
         	//�߻�޽��();
         	public abstract int print(int i);
         	//�Ϲݸ޽��();
         	public void test(){
         	}
         }
         ==>�߻�޽��: �޽���� �����κ��� ���� ����(prototype)�� �����ϴ� �޽��
            ex> public abstarct int print(int i);          
               
  2. �߻�Ŭ������ �ҿ����� �߻�޽�带 �����Ƿ� ��ü������ �Ұ����ϴ�.
      Test t=new Test();(X)
      
  3. �߻�Ŭ������ �߻�Ŭ������ ��ӹ޾Ƽ� �߻�޽�带 
     ����(�������̵�)�ϴ� �ڽ� Ŭ������ ����� ���(��ü����)�ؾ��Ѵ� 
*/

public abstract class AbstractParent {	//�ϳ� �̻��� �߻�޼ҵ尡 ������ �߻� Ŭ����.
	public void method1(){
		System.out.println("������ �޼ҵ�");
	}
	
	public abstract void method2();	//�߻� �޼ҵ�
	
}
