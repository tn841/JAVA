
public class Round {
	public static void main(String[] args) {
		double avg = 85.56214;
		/*
		 * ��������Ÿ�� �Ҽ���2�ڸ������� ǥ���Ͻÿ�(3°�ڸ������ݿø�)
		 * casting�̿�
		 */
		System.out.println("�־��� ��:"+avg);
		double t1 = avg*100;
		t1 = t1 + 0.5;
		int t2 = (int)t1;
		double t3 = t2/100.0;
		

		System.out.println("�Ҽ���2�ڸ����� ǥ���� ���:"+t3);

		

		
	}
}
