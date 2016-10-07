package com.itwill05.student.service;

/*
 * ������ �������� Ŭ����
 * 	- Car[] ��ü�� ��������� ������
 * 	- �������񽺸� �ϴ� Ŭ����
 */

public class CarService {
	public static int totalSpace;		//������ ��ü ����
	public static int totalCarCount;	//�����忡 �ִ� ���� ���, ���� ����
	public static int emptyCount; 	//�����忡 ���� �ڸ� ��, ���� ����
	
	private Car[] carArr;	//�ڵ��� ��ü���� ����Ǵ� �ڵ��� �迭 (������)

	public CarService() { // �⺻ �����ڷ� ��ü ������ �������� 30��
		totalSpace = 30;
		carArr = new Car[totalSpace];
	}

	public CarService(int number) {
		totalSpace = number;
		carArr = new Car[totalSpace];
	}

	public int getParkingCount() {
		return carArr.length;
	}

	public int getEmpty() {
		int empty = 0;
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] == null) {
				empty++;
			}
		}
		return empty;
	}

	public void enterCar(Car car) {
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] == null) {
				carArr[i] = car;
				totalCarCount++;
				break;
			}
		}
	}

	public Car getCarByNo(String string) {
		Car tempCar = null;
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null && carArr[i].getNo().equals(string)) {
				tempCar = carArr[i];
			}
		}
		return tempCar;
	}

	public Car[] getCarsByInTime(int inTime) {
		int count = 0;
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null && carArr[i].getInTime() >= inTime) {
				count++;
			}
		}

		Car[] tempCars = new Car[count];
		int index = 0;

		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null && carArr[i].getInTime() >= inTime) {
				tempCars[index++] = carArr[i];
			}
		}

		return tempCars;
	}// getCarsByInTime

	public void print() {
		Car.headerPrint();
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null) {
				carArr[i].print();
			}
		}
		Car.footerPrint();
	}// print()

	public static void print(Car[] cars) {
		Car.headerPrint();
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				cars[i].print();
			}
		}
		Car.footerPrint();
	}//print(Car[] cars)

	public Car culcha(String no, int outTime) {
		Car culchaTemp = null;
		for (int i = 0; i < carArr.length; i++) {
			if( !isNull(carArr[i]) && carArr[i].getNo().equals(no)){
				carArr[i].setOutTime(outTime);
				carArr[i].calculateFee();
				culchaTemp = carArr[i];
				carArr[i] = null;
				break;
			}
		}
		return culchaTemp;
	}
	
	public boolean isNull(Car car){
		if(car == null){
			return true;
		}
		else
			return false;
	}

	public int sumOfFee(int inTime) {
		int totalFee = 0;
		System.out.println("--------------------------------------------");
		System.out.println("��ȣ\t����\t����\t���\t"+inTime+"�� ���ؿ��");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < carArr.length; i++) {
			if( !isNull(carArr[i]) && carArr[i].getOutTime()==0){	//���� ���� ���� ������ ���ؼ���,
				totalFee += (inTime - carArr[i].getInTime())*1000;
				carArr[i].printNoEnter();
				System.out.println("\t"+(inTime - carArr[i].getInTime())*1000);
			}
		}
		System.out.println("--------------------------------------------");
		return totalFee;
	}

}
