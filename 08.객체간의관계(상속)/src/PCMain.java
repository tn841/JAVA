/*
 * ���(Ŭ������ ����)
 * �θ�Ŭ����(��ü)�� ���(����, �޼ҵ�)���� �ڽ�Ŭ����(��ü)�� �����޴°�
 * 
 * 1. ����� ����ϴ� ����
 * 	- ������ �������� Ŭ������ ����, Ȯ���� ����
 * 2. �ڹٿ����� ���ϻ�Ӹ��� ����(�θ�Ŭ������ �Ѱ��� ����)
 * 3. �θ�Ŭ����(super)�� �ڽ�Ŭ����(sub)�� �����Ѵ�.
 * 4. �ڹٿ��� �����Ǿ����� ��� Ŭ�������� Object��� �θ�Ŭ������ ��� �޴´�.
 * 5. ��������� Ŭ�����鵵 Object Ŭ������� �ֻ���Ŭ������ ��� �޾ƾ� �Ѵ�.
 * 6. ������ ����� �ȵȴ� (�θ� 1000���� ����� ������ �ڽ��� �װ��� ��� ��� �޾ƾ��Ѵ�.)
 */
public class PCMain {

	public static void main(String[] args) {
		System.out.println("---------------parent--------------");
		Parent p = new Parent();
		p.member1 = "m1";
		p.member2 = "m2";
		p.method1();
		p.method2();
		System.out.println("---------------child--------------");
		Child ch = new Child();
		ch.member1 = "m1";
		ch.member2 = "m2";
		ch.member3 = "m3";
		ch.member4 = "m4";
		ch.method1();
		ch.method2();
		ch.method3();
		ch.method4();
		
	}

}
