package com.itwill04.student.array;

public class AccountArrayMain {

	public static void main(String[] args) {
		Account[] accounts = {
				new Account("1111", "KIM", 500000, 0.02),
				new Account("2222", "김김", 40000, 0.025),
				new Account("3333", "LEE", 43000, 0.015),
				new Account("4444", "Park", 10000, 0.075),
				new Account("5555", "Ku", 14000, 0.056),
				new Account("6666", "Hong", 16000, 0.045),
				new Account("7777", "Jung", 73000, 0.015),
				new Account("8888", "Bea", 83500, 0.095),
				new Account("9999", "Hoo", 64400, 0.045),				
				};
		
		System.out.println("1. 은행 총 계좌수: ");
		System.out.println(">> "+accounts.length);
		
		System.out.println("2. 은행 총 잔고 : ");
		int balanceTotal = 0;
		for(int i=0; i<accounts.length; i++){
			balanceTotal += accounts[i].getBalance();
		}
		System.out.println(">> "+ balanceTotal+"원");
		
		System.out.println("3. 계좌번호 6666번인 계좌의 정보 출력");
		for(int i=0; i<accounts.length; i++){
			if(accounts[i].getNo().equals("6666")){
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		System.out.println("4. 계좌주 LEE인 계좌들 정보출력");
		for (int i = 0; i < accounts.length; i++) {
			String tempOwner = accounts[i].getOwer();
			if (tempOwner.equals("LEE")) {
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		System.out.println("5. 계좌잔고 50000원 이상인 계좌들 정보출력");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getBalance() >= 50000) {
				System.out.print(">> ");
				accounts[i].print();
			}
		}
		
		System.out.println("6. 계좌이율 0.1 이상인 계좌들 정보출력");
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
