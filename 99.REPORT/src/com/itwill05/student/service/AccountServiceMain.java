package com.itwill05.student.service;

public class AccountServiceMain {

	public static void main(String[] args) {
		/*
		1.���� �Ѱ��¼�
		2.���� ���ܰ�
		3.���¹�ȣ 6666���� ����1�� �������
		4.������   DONG��   ���µ�  �������
		
		5.�����ܰ� 50000�� �̻��� ���µ�  �������
		6.���µ� �ܰ������ ������������
		7.���µ� ��ȣ(���ڿ�)������ ������������
		*/
		
		AccountService accountServ = new AccountService();
		
		System.out.println("1.���� �Ѱ��¼�");
		System.out.println(">> "+accountServ.getAccountNumber());
		
		System.out.println("2.���� ���ܰ�");
		System.out.println(">> "+accountServ.totalBalance());
		
		System.out.println("3.���¹�ȣ 6666���� ����1�� �������");		
		Account findAccount = accountServ.findAccountByNO("6666");
		AccountService.print(findAccount);
	
		
		System.out.println("4.������   KIM��   ���µ�  �������");
		AccountService.print(accountServ.findAccountByName("KIM"));
		
		System.out.println("5.�����ܰ� 50000�� �̻��� ���µ�  �������");
		AccountService.print(accountServ.findAccountByBalance(50000));
		
		System.out.println("6. ���µ� �ܰ������ ������������");
		accountServ.balanceDESC();
		accountServ.print();
		
		System.out.println("7. ������ �̸�(���ڿ�)������ ������������");
		accountServ.ownerNameASC();
		accountServ.print();
		
	}//main

}
