
public class CarMain {

	public static void main(String[] args) {
		
		/*
		 * 1. ����
		 *   - Ŭ������ ����ؼ� �� ��ü ����
		 *   - �� ��ü�� ������ �Է�
		 */
	
		Car car1 = new Car();	//��ü(�ν��Ͻ�) ���� �� ����
		
		//������ �ν��Ͻ��� ������ �Է�
		car1.no = "23��2973";	
		car1.inTime = 12;
		
		
		/*
		 * 2. 2�ð��� ���� �� ����
		 *   - �����ð��� ��ü�� �Է�
		 *   - ���ڿ�� ��� �� ��ü Setting
		 */
		car1.outTime = 14;
		car1.fee = (car1.outTime - car1.inTime)*1000;
		
		
		/*
		 * 3. ���������
		 *  
		 */
		System.out.println("*********************************************************");
		System.out.println("������ȣ\t�����ð�\t�����ð�\t�������");
		System.out.println("---------------------------------------------------------");
		System.out.println(car1.no+"\t"+car1.inTime+"\t\t"+car1.outTime+"\t\t"+car1.fee);
		System.out.println("*********************************************************");
	}

}
