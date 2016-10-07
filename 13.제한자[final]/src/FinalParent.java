/*
 * ������(final)
 * 1. Ŭ���� �տ� ���� ���
 * 	- ��ӱ��� 					ex) public final class String{} -> String Ŭ������ ������� ������.
 * 
 * 2. ����޼ҵ� �տ� ���� ���
 * 	- �������̵�(������) ����	ex) public final void print(){}; -> print()�޼ҵ带 ���������� ������.
 * 
 * 3. ������� �տ� ���� ���
 * 	- ���, ���� ����, ������ ����	ex) public final int PORT_NUM = 21;	-> ��� PORT_NUM, ����� ���ÿ� �ʱ�ȭ or �����ڿ��� �ʱ�ȭ
 */
public class FinalParent {
	public final int PORT_NUMBER = 80;
	public final double INCENTIVE_RATE;	//��ü ���� ������ �ִ� instance ���
	
	public static final int	SHOUTH = 0;	 
	public static final int	NORTH = 1;	 
	public static final int	EAST = 2;	 
	public static final int	WEST = 3;	 //Ŭ������ ���� �ִ� static ���
	
	public FinalParent() {
		INCENTIVE_RATE = 0.1;
	}
	
	public void constantCheck(){
//		������ �Ұ����ϴ�.
//		this.PORT_NUMBER = 8080;
//		INCENTIVE_RATE = 0.2;
		
		//������ �����ϴ�.
		System.out.println(PORT_NUMBER);
		System.out.println(INCENTIVE_RATE);
		System.out.println(FinalParent.EAST);
		System.out.println(FinalParent.NORTH);
		System.out.println(FinalParent.SHOUTH);
		System.out.println(FinalParent.WEST);
		
	}
	
	public final void cannotOverriding(){
		System.out.println("������ �Ұ����� final �޼ҵ��Դϴ�. ����� ��");
	}
	
	public void method3(){
		System.out.println("������ ������ �Ϲ� �޼ҵ�");
	}
}
