package com.itwill03.student.constructor;

public class CarMethodMain {

	public static void main(String[] args) {
		

		//Car ��ü ���� �� ���� 2���� ���� �����ڸ� ���� �ʱ�ȭ 
		Car car1 = new Car("23��2973", 12);	
		Car car2 = new Car("72��7583", 13);
		Car car3 = new Car("94��3414", 14);
		
		
		//2�ð� �� ����
		car1.setOutTime(15);
		car2.setOutTime(15);
		car3.setOutTime(15);
		
		
		//��� ���
		car1.calculateFee();
		car2.calculateFee();
		car3.calculateFee();
	
		//���
		Car.headerPrint();	//Car Ŭ������ ���� �޼ҵ�
		car1.print();		//car1��ü�� print�޼ҵ�
		car2.print();		//car2��ü�� print�޼ҵ�
		car3.print();		//car3��ü�� print�޼ҵ�
		Car.footerPrint();	//Car Ŭ������ ���� �޼ҵ�
		
	
	
	}

}
