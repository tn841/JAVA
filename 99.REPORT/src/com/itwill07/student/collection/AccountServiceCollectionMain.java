package com.itwill07.student.collection;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AccountServiceCollectionMain {

	public static void main(String[] args) {
		/*
		1.AccountService객체야 은행 총계좌수반환해줘
		2.AccountService객체야 은행 총잔고 반환해줘
		3.AccountService객체야 계좌번호 6666번줄께 계좌1개 참조변수줘
		4.AccountService객체야 계좌주   DONG 줄께    계좌들정보줘
		
		5.AccountService객체야 계좌잔고(50000원)줄께 잔고이상인 계좌객체배열주소반환해줘
		6.AccountService객체야 계좌이율(0.1)줄께 이율이상인  계좌객체배열주소반환해줘
		7.계좌들 잔고순으로 내림차순정렬
		8.계좌들 번호(문자열)순으로 오름차순정렬
		*/
		System.out.println("0.AccountService객체 생성");
		AccountService accountService=new AccountService();
		
		System.out.println("0-1. 계좌 추가");
		accountService.addAccount(new Account("1111", "ASD", 10000, 0.02));
		accountService.addAccount(new Account("2222", "BEC", 13000, 0.025));
		accountService.addAccount(new Account("3333", "DONG", 55000, 0.01));
		accountService.addAccount(new Account("4444", "ECX", 7000, 0.015));
		accountService.addAccount(new Account("5555", "DONG", 99700, 0.03));
		accountService.addAccount(new Account("6666", "CZC", 59700, 0.031));
		
		System.out.println("1.AccountService객체야 은행 총계좌수반환해줘");
		int count=accountService.getAccountNumber();
		System.out.println(">>은행 총계좌수:"+count);
		
		System.out.println("2.AccountService객체야 은행 총잔고 반환해줘");
		int tot = accountService.getTotBalance();
		System.out.println(">>은행 총잔고:"+tot+"원");
		
		System.out.println("3.AccountService객체야 계좌번호(6666)줄께  계좌1개 참조변수줘");
		Account findAccount=accountService.findByNo("6666");
		if(findAccount!=null){
			findAccount.print();
		}else{
			System.out.println("6666번계좌없~~~다");
		}
		
		
		System.out.println("4.AccountService객체야 계좌주이름(DONG)줄께 ArrayList객체(계좌객체들)주소줘");
		ArrayList<Account> findAccounts=accountService.findByOwner("DONG");
		System.out.println(">>>findAccounts.length:"+findAccounts.size());
		AccountService.print(findAccounts);
		
		
		System.out.println("5.AccountService객체야 계좌잔고(5000원)줄께 잔고이상인 ArrayList객체(계좌객체들)주소 반환해줘");
		findAccounts = accountService.findByBalance(50000);
		System.out.println(">>>findAccounts.length:"+findAccounts.size());
		AccountService.print(findAccounts);
		
	//	System.out.println("6.AccountService객체야 계좌이율(0.1)줄께 이율이상인  ArrayList객체(계좌객체들)주소 반환해줘");
		
		
		System.out.println("7.계좌들 잔고순으로 내림차순정렬");
		accountService.balanceDESC();
		AccountService.print(accountService.getAccountList());
		
		
		
	//	System.out.println("8.계좌들 번호(문자열)순으로 오름차순정렬");
		
		System.out.println("9.AccountService객체야 계좌번호와 돈 줄께 입금기능수행해");
		int result = accountService.ipGum("6666",1);
		switch (result) {
		case AccountService.SUCCESS:
			System.out.println(">>>입금성공");
			break;

		case AccountService.WRONG_NO:
			System.out.println(">>>계좌번호오류");
			break;
		}
		
		System.out.println("10.AccountService객체야 계좌번호와 돈 줄께 입금기능수행해[Exception]");
		try {
			accountService.ipGum2("6666", 1);
			System.out.println(">>>입금성공");
		} catch (WrongNumberException e) {
			System.out.println(">>>계좌번호오류");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		System.out.println("11.AccountService객체야 계좌번호와 돈 줄께 출금기능수행해[Exception]");
		
		try {
			accountService.culGum("6666", 100000);
			System.out.println(">>>출금성공");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			//e.printStackTrace();
		} 
		
		AccountService.print(accountService.getAccountList());

	
	}//end main 

}//enc class










