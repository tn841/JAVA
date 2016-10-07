package com.itwill05.student.service;

public class AccountServiceMain {

	public static void main(String[] args) {
		/*
		1.은행 총계좌수
		2.은행 총잔고
		3.계좌번호 6666번인 계좌1개 정보출력
		4.계좌주   DONG인   계좌들  정보출력
		
		5.계좌잔고 50000원 이상인 계좌들  정보출력
		6.계좌들 잔고순으로 내림차순정렬
		7.계좌들 번호(문자열)순으로 오름차순정렬
		*/
		
		AccountService accountServ = new AccountService();
		
		System.out.println("1.은행 총계좌수");
		System.out.println(">> "+accountServ.getAccountNumber());
		
		System.out.println("2.은행 총잔고");
		System.out.println(">> "+accountServ.totalBalance());
		
		System.out.println("3.계좌번호 6666번인 계좌1개 정보출력");		
		Account findAccount = accountServ.findAccountByNO("6666");
		AccountService.print(findAccount);
	
		
		System.out.println("4.계좌주   KIM인   계좌들  정보출력");
		AccountService.print(accountServ.findAccountByName("KIM"));
		
		System.out.println("5.계좌잔고 50000원 이상인 계좌들  정보출력");
		AccountService.print(accountServ.findAccountByBalance(50000));
		
		System.out.println("6. 계좌들 잔고순으로 내림차순정렬");
		accountServ.balanceDESC();
		accountServ.print();
		
		System.out.println("7. 계좌주 이름(문자열)순으로 오름차순정렬");
		accountServ.ownerNameASC();
		accountServ.print();
		
	}//main

}
