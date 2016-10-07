package com.itwill05.student.service;

/*
 * 계좌객체들을 멤버로 가지며 
 * 계좌객체들의 업무실행을 하는 클래스
 */
public class AccountService {
	private Account[] accounts = { 
			new Account("1111", "KIM", 500000, 0.02), 
			new Account("2222", "KIM", 40000, 0.025),
			new Account("3333", "LEE", 43000, 0.015), 
			new Account("4444", "Park", 10000, 0.075),
			new Account("5555", "Ku", 14000, 0.056), 
			new Account("6666", "KIM", 16000, 0.045),
			new Account("7777", "Jung", 73000, 0.015), 
			new Account("8888", "Bea", 83500, 0.095),
			new Account("9999", "Hoo", 64400, 0.045), };


	public int getAccountNumber() {
		return accounts.length;
	}

	public int totalBalance() {
		int temp = 0;
		for (int i = 0; i < accounts.length; i++) {
			temp += accounts[i].getBalance();
		}
		return temp;
	}

	public static void headerPrint() {
		System.out.println("-----------------------------");
		System.out.println("번호\t이름\t잔고\t이율");
		System.out.println("-----------------------------");
	}

	public static void footerPrint() {
		System.out.println("-----------------------------");
	}
	
	public void print(){
		AccountService.headerPrint();
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].getNo() + "\t" + accounts[i].getOwer() + "\t" + accounts[i].getBalance() + "\t"
					+ accounts[i].getIyul());
		}
		AccountService.footerPrint();
	}
	
	public static void print(Account acc) {
		AccountService.headerPrint();
		System.out.println(acc.getNo() + "\t" + acc.getOwer() + "\t" + acc.getBalance() + "\t" + acc.getIyul());
		AccountService.footerPrint();
	}

	public static void print(Account[] accArr) {
		AccountService.headerPrint();
		for (int i = 0; i < accArr.length; i++) {
			if (accArr[i] != null) {
				System.out.println(accArr[i].getNo() + "\t" + accArr[i].getOwer() + "\t" + accArr[i].getBalance() + "\t"
						+ accArr[i].getIyul());
			}
		}
		AccountService.footerPrint();
	}

	public Account findAccountByNO(String no) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getNo().equals(no)) {
				return this.accounts[i];
			}
		}
		return null;
	}

	public Account[] findAccountByName(String name) {
		int sizeOfArr = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getOwer().equals(name)) {
				sizeOfArr++;
			}
		}
		
		Account[] tempArr = new Account[sizeOfArr];
		int index = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getOwer().equals(name)) {
				tempArr[index++] = accounts[i];
			}
		}
		return tempArr;
	}

	public Account[] findAccountByBalance(int balance) {
		int sizeOfArr = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getBalance() >= balance) {
				sizeOfArr++;
			}
		}
		
		Account[] tempArr = new Account[sizeOfArr];
		int index = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getBalance() >= balance) {
				tempArr[index++] = accounts[i];
			}
		}
		return tempArr;
	}
	
	public void balanceDESC(){
		for (int i = 0; i < accounts.length; i++) {
			for (int j = 0; j < accounts.length; j++) {
				if(accounts[i].getBalance() > accounts[j].getBalance()){
					Account temp = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = temp;
				}
			}
		}
	}//balanceDESC()
	
	public void ownerNameASC(){
		for (int i = 0; i < accounts.length; i++) {
			for (int j = 0; j < accounts.length; j++) {
				if(      accounts[i].getOwer().compareTo(accounts[j].getOwer()) < 0 ){
					Account temp = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = temp;
				}
			}
		}
	}//ownerNameASC()

}
