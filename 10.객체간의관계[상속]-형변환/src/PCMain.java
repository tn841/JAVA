/*
 * ��ü���������� ����ȯ
 * 1. �θ��ڽİ��迡 �ִ� Ŭ�����鿡���� �����ϴ�.
 * 
 * 2. �ڽ�Ÿ�԰�ü�� �θ�Ŭ����Ÿ������ ����ȯ
 * 		- �ڵ����� �̷������.(������)
 * 		Child c = new Child();
 * 		Parent p = c;	//�ڽ� ��ü�� �θ� Ŭ���� Ÿ������ ����ȯ �Ͽ���. 
 * 
 * 3. �θ� ��ü�� �ڽ�Ŭ����Ÿ������ ����ȯ
 * 		- ��Ģ�����δ� �Ұ����ϴ�.
 * 		- �θ��� Ż���� �ڽİ�ü�� �����ϴ�. (Parent p = c;)
 * 
 * 		Parent p = new Parent();
 * 		Child ccc = p; (X) -> ��Ÿ�� ������ ����.
 * 
 * 		Child c = new Child();
 * 		Parent p = c;	//�����δ� Child��ü�̳� ���⿡�� Parent��üó�� ���δ�.
 * 		Child cccc = (Child)p;	//�̷��� �θ��� Ż�� �� �ڽİ�ü�� ���� ����ȯ�� �����ϴ�.
 */
public class PCMain {

	public static void main(String[] args) {
		Child c1 = new Child();
		Parent p1 = c1;	//�θ� ��ü�� �ڽ� ��ü�� ����ȯ�Ǵ� ���� ����
		//c1�� p1�� ���� �ּҸ� ����Ų��.
		//�׷��� ��(type)�� �ٸ���.
		
		c1.method1();
		c1.method2();
		c1.method3();
		c1.method4();
		
		p1.method1();
		p1.method2();
		//p1.method3();
		//p1.method4();
		
		
		
		Parent p2 = new Child();
		
		
		
	}

}
