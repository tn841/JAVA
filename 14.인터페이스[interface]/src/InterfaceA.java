/*
 * �������̽�
 * 	1. Ŭ������ ���� ��� �޼ҵ尡 �߻�޼ҵ�
 * 	2. ���߻���� ȿ�� (�߻�Ŭ�����δ� �Ұ��� �ϳ� �������̽��� ����)
 * 
 * 	- ����
 * 		- class Ű���� ��ſ� interface��� Ű���� ���
 * 		- �߻� �޼ҵ� �տ� abstract�� ������ �ʾƵ� �ȴ�.
 * 		ex) public interface Test{
 * 			public final int MEMBER = 1;	//����� ���� �� �ִ�.
 * 			public void method();
 * 			public void method2();
 * 		}
 * 
 * 	- ���
 * 		1. interface�� ���(implements)�޴´�.
 * 		2. �߻� �޼ҵ带 �������� �� ����Ѵ�.
 * 
 * 		ex) public class TestImpl implements Test{
 * 			public void method(){};
 * 			public void method2(){};
 * 		}
 * 		
 * 
 */
public interface InterfaceA {
	public void method1();
	public void method2();
}


