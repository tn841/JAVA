
public class AbstractMain {

	public static void main(String[] args) {
		/*
		 * �߻�Ŭ������ �ܵ� ��ü ���� �Ұ���
		 */
		//AbstarctParent ap = new AbstarctParent();
		
		AbstractChild ac = new AbstractChild();
		ac.method1();
		ac.method2();
		
		AbstractParent ap;	//��ü ������ �Ұ��� ������ ��ü ������ �����ϴ�. �ڽİ�ü�� �ּҸ� ���� �� �ִ�.
		ap = new AbstractChild();	//���� �������� ����ȯ�� �����ϴ�.
		ap.method1();
		ap.method2();
		
	}

}
