package com.itwill04.student.array;

public class AccountArrayMain {

	public static void main(String[] args) {
		Account[] accounts = {
				new Account("1111", "KIM", 500000, 0.02),
				new Account("2222", "���", 40000, 0.025),
				new Account("3333", "LEE", 43000, 0.015),
				new Account("4444", "Park", 10000, 0.075),
				new Account("5555", "Ku", 14000, 0.056),
				new Account("6666", "Hong", 16000, 0.045),
				new Account("7777", "Jung", 73000, 0.015),
				new Account("8888", "Bea", 83500, 0.095),
				new Account("9999", "Hoo", 64400, 0.045),				
				};
		
		System.out.println("1. ���� �� ���¼�: ");
		System.out.println(">> "+accounts.length);
		
		System.out.println("2. ���� �� �ܰ� : ");
		int balanceTotal = 0;
		for(int i=0; i<accounts.length; i++){
			balanceTotal += accounts[i].getBalance();
		}
		System.out.println(">> "+ balanceTotal+"��");
		
		System.out.println("3. ���¹�ȣ 6666���� ������ ���� ���");
		for(int i=0; i<accounts.length; i++){
			if(accounts[i].getNo().equals("6666")){
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		System.out.println("4. ������ LEE�� ���µ� �������");
		for (int i = 0; i < accounts.length; i++) {
			String tempOwner = accounts[i].getOwer();
			if (tempOwner.equals("LEE")) {
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		System.out.println("5. �����ܰ� 50000�� �̻��� ���µ� �������");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getBalance() >= 50000) {
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		System.out.println("6. �������� 0.1 �̻��� ���µ� �������");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getIyul() >= 0.1) {
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		for (int i = 0; i < accounts.length; i++) {
			for (int j = 0; j < accounts.length - 1; j++) {
				if (accounts[j].getBalance() < accounts[j + 1].getBalance()) {
					int balTemp1 = accounts[j].getBalance();
					int balTemp2 = accounts[j + 1].getBalance();
					accounts[j].setBalance(balTemp2);
					accounts[j + 1].setBalance(balTemp1);

				}
			}
		}
		System.out.print(">> ");
		for (int i = 0; i < accounts.length; i++) {
			System.out.print(+accounts[i].getBalance() + " ");
		}
	}

}
