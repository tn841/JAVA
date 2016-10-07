package com.itwill07.student.collection;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AccountServiceCollectionMain {

	public static void main(String[] args) {
		/*
		1.AccountService��ü�� ���� �Ѱ��¼���ȯ����
		2.AccountService��ü�� ���� ���ܰ� ��ȯ����
		3.AccountService��ü�� ���¹�ȣ 6666���ٲ� ����1�� ����������
		4.AccountService��ü�� ������   DONG �ٲ�    ���µ�������
		
		5.AccountService��ü�� �����ܰ�(50000��)�ٲ� �ܰ��̻��� ���°�ü�迭�ּҹ�ȯ����
		6.AccountService��ü�� ��������(0.1)�ٲ� �����̻���  ���°�ü�迭�ּҹ�ȯ����
		7.���µ� �ܰ������ ������������
		8.���µ� ��ȣ(���ڿ�)������ ������������
		*/
		System.out.println("0.AccountService��ü ����");
		AccountService accountService=new AccountService();
		
		System.out.println("0-1. ���� �߰�");
		accountService.addAccount(new Account("1111", "ASD", 10000, 0.02));
		accountService.addAccount(new Account("2222", "BEC", 13000, 0.025));
		accountService.addAccount(new Account("3333", "DONG", 55000, 0.01));
		accountService.addAccount(new Account("4444", "ECX", 7000, 0.015));
		accountService.addAccount(new Account("5555", "DONG", 99700, 0.03));
		accountService.addAccount(new Account("6666", "CZC", 59700, 0.031));
		
		System.out.println("1.AccountService��ü�� ���� �Ѱ��¼���ȯ����");
		int count=accountService.getAccountNumber();
		System.out.println(">>���� �Ѱ��¼�:"+count);
		
		System.out.println("2.AccountService��ü�� ���� ���ܰ� ��ȯ����");
		int tot = accountService.getTotBalance();
		System.out.println(">>���� ���ܰ�:"+tot+"��");
		
		System.out.println("3.AccountService��ü�� ���¹�ȣ(6666)�ٲ�  ����1�� ����������");
		Account findAccount=accountService.findByNo("6666");
		if(findAccount!=null){
			findAccount.print();
		}else{
			System.out.println("6666�����¾�~~~��");
		}
		
		
		System.out.println("4.AccountService��ü�� �������̸�(DONG)�ٲ� ArrayList��ü(���°�ü��)�ּ���");
		ArrayList<Account> findAccounts=accountService.findByOwner("DONG");
		System.out.println(">>>findAccounts.length:"+findAccounts.size());
		AccountService.print(findAccounts);
		
		
		System.out.println("5.AccountService��ü�� �����ܰ�(5000��)�ٲ� �ܰ��̻��� ArrayList��ü(���°�ü��)�ּ� ��ȯ����");
		findAccounts = accountService.findByBalance(50000);
		System.out.println(">>>findAccounts.length:"+findAccounts.size());
		AccountService.print(findAccounts);
		
	//	System.out.println("6.AccountService��ü�� ��������(0.1)�ٲ� �����̻���  ArrayList��ü(���°�ü��)�ּ� ��ȯ����");
		
		
		System.out.println("7.���µ� �ܰ������ ������������");
		accountService.balanceDESC();
		AccountService.print(accountService.getAccountList());
		
		
		
	//	System.out.println("8.���µ� ��ȣ(���ڿ�)������ ������������");
		
		System.out.println("9.AccountService��ü�� ���¹�ȣ�� �� �ٲ� �Աݱ�ɼ�����");
		int result = accountService.ipGum("6666",1);
		switch (result) {
		case AccountService.SUCCESS:
			System.out.println(">>>�Աݼ���");
			break;

		case AccountService.WRONG_NO:
			System.out.println(">>>���¹�ȣ����");
			break;
		}
		
		System.out.println("10.AccountService��ü�� ���¹�ȣ�� �� �ٲ� �Աݱ�ɼ�����[Exception]");
		try {
			accountService.ipGum2("6666", 1);
			System.out.println(">>>�Աݼ���");
		} catch (WrongNumberException e) {
			System.out.println(">>>���¹�ȣ����");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		System.out.println("11.AccountService��ü�� ���¹�ȣ�� �� �ٲ� ��ݱ�ɼ�����[Exception]");
		
		try {
			accountService.culGum("6666", 100000);
			System.out.println(">>>��ݼ���");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			//e.printStackTrace();
		} 
		
		AccountService.print(accountService.getAccountList());

	
	}//end main 

}//enc class










