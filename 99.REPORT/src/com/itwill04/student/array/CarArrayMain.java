package com.itwill04.student.array;

public class CarArrayMain {

	public static void main(String[] args) {
		//Car[] carArray = new Car[30];	//�ڵ��� ��ü�� ���� �迭�� ������ ��, �ڵ��� ��ü�� ���������� �ʾҴ�.
		/*
		 * ������ȣ�� �ߺ����� �ʴ´�.
		 */
		Car[] carArray = {
			null, null, new Car("1111", 5), null, null,
			null, null, null, null, new Car("1112", 5),
			null, null, new Car("8977", 7), null, null,
			null, new Car("1234", 10), null, null, null,
			null, null, null, null, new Car("6666", 9),
			null, null, new Car("9999", 11), null, null
		};// Car��ü 30���� ������ �迭 carArray�� �幮�幮 car��ü�� �� �ִ�.
		
		System.out.println("1. �� ���� ��ȹ�� : ");
		System.out.println(">> "+carArray.length+"\n");
		
		
		System.out.println("2. �� ���� ��ȹ ���� : ");//�� á���� ����
		int count = 0;
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null){
				count++;
			}
		}
		if(count == carArray.length){
			System.out.println("�����Դϴ�.");
		}
		System.out.println(">> "+count+"\n");
		
	
		
		/*
		 * ����
		 */
		System.out.println("3. ���� : ��ȣ='3456' �����ð�=8");
		Car car1 = new Car("3456", 8);
		for(int i=0; i<carArray.length; i++){
			if(carArray[i] == null){
				carArray[i] = car1;
				break;	//for�� ���鼭 ù��° null�ΰ��� �� ��ü�� �ְ��� for�� Ż��
			}
		}//for
		System.out.println(">> �����Ϸ�.");
		System.out.println();
		
		System.out.println("4. '8977'�� ������ ã�Ƽ� ���");

		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null && carArray[i].getNo().equals("8977")){	//null�� �ƴϰ� "8977"�� ��ü�� ã�´�.
				Car.headerPrint();
				carArray[i].print();
				Car.footerPrint();
				break;
			}
		}
		System.out.println();
		
		System.out.println("5. �����ð��� 9������ ������ ã�Ƽ� ���");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null && carArray[i].getInTime() > 9){
				carArray[i].print();
			}
		}
		Car.footerPrint();
		System.out.println();
		
		
		System.out.println("6. ��ü �������� ��� : ");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null)
				carArray[i].print();
		}
		Car.footerPrint();
		System.out.println();
		
		System.out.println("7. '6666'�� ���� ���� �� �ش� ���� ���� ���: ");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null && carArray[i].getNo().equals("6666")){
				carArray[i].setOutTime(15);
				carArray[i].calculateFee();
				carArray[i].print();
				carArray[i] = null;	//�ش� �迭�ε����� null�� ����ָ� ���� ���μ��� �Ϸ�
				break;
			}
		}
		Car.footerPrint();
		System.out.println();
		
		System.out.println("8. ����ð�(15��) �����忡�ִ� ������ ������ ���: ");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null ){
				carArray[i].print();
			}
		}
		Car.footerPrint();
		System.out.println();
		
	
		
		
	}

}
