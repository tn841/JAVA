/*
 * static ������(������, modifier)
 * 1. ���������, �޼ҵ�(Ŭ����) �տ� ������ �ִ�.
 * 2. static �����ڰ� �پ��ִ� ������ �޼ҵ�� ��ü�������̵� ����̰����ϴ�.
 * 3. Ŭ������ �������ִ� �������޼ҵ��̴�.
 * 		-> Ŭ���� ����, Ŭ���� �޼ҵ����Ѵ�.
 * 4. Ŭ�����κ��� �����Ǵ� ��ü���� �����Ѵ� ����(�޼ҵ�)�̴�.
 * 		-> ���뺯��(�޼ҵ�)��� �Ѵ�.
 * 
 * 	-����:
 * 		������� :  public static int i;
 * 		����޼ҵ� : public static void print();
 *
 */
public class Static {
	public int instance_var = 100;
	public static int static_var = 100;
	
	public void instance_method(){
		System.out.println("��ü �޼ҵ�");
	}
	public static void static_method(){
		System.out.println("���� �޼ҵ�");
		//���� �޼ҵ忡���� ������������(this)�� ����� �� ����. �����غ��� �翬�Ѱ�,, 
		//��ü�� ��������� �ʱ� ������ this��� ���� ���� �� ���� ����.
	}
}
