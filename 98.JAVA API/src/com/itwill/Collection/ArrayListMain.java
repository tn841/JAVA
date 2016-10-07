package com.itwill.Collection;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		System.out.println("----------참조형-------------");
		Account acc1 = new Account("1111", "BONG", 33000, 0.02);
		Account acc2 = new Account("2222", "AONG", 23000, 0.03);
		Account acc3 = new Account("3333", "DONG", 33000, 0.04);
		Account acc4 = new Account("4444", "FONG", 99000, 0.12);
		Account acc5 = new Account("5555", "HONG", 78000, 0.08);
		Account acc6 = new Account("6666", "CONG", 33000, 0.03);
		Account acc7 = new Account("7777", "DONG", 33000, 0.28);
		Account acc8 = new Account("8888", "ZONG", 33000, 0.68);
		Account acc9 = new Account("9999", "OONG", 22000, 0.88);
		ArrayList accountList=new ArrayList();
		System.out.println("1.size : "+accountList.size());
		System.out.println("2.add");
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
		accountList.add(acc6);
		accountList.add(acc7);
		accountList.add(acc8);
		accountList.add(acc9);
		System.out.println("3.size : "+accountList.size());
		accountList.add(4, new Account("1234","PONG",12300,0.01));
		System.out.println("4.size : "+accountList.size());
		Account getAcc = (Account)accountList.get(4);
		getAcc.print();
		System.out.println(accountList.toString());
		
		System.out.println("3.remove(index)");
		Account removeAccount=(Account)accountList.remove(4);
		removeAccount.print();
		
		System.out.println("#.remove size:"+accountList.size());
		System.out.println("4.set(index,E)");
		accountList.set(0, new Account("0000", "이효리", 89000, 2.1));
		System.out.println("#.set size:"+accountList.size());
		System.out.println(">> ArrayList구조:"+accountList);
		
		System.out.println("6.이름  DONG인사람계좌들 출력");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount=(Account)accountList.get(i);
			if(tempAccount.getOwner().equals("DONG")){
				tempAccount.print();
			}
		}
		
		System.out.println("QUIZ >> 8.이름  DONG인 계좌모두삭제 출력");
		System.out.println("9. ArrayList --> Object[]");
		Object[] objectArray = accountList.toArray();
		for (int i = 0; i < objectArray.length; i++) {
			Account ta=(Account)objectArray[i];
			ta.print();
		}
		
		System.out.println("----------기본형-------------");
		
		ArrayList scoreList=new ArrayList();
		System.out.println("0.초기 size:"+scoreList.size());
		scoreList.add(new Integer(89));
		scoreList.add(67);
		scoreList.add(77);
		scoreList.add(55);
		scoreList.add(39);
		scoreList.add(81);
		scoreList.add(99);
		scoreList.add(64);
		scoreList.add("가나다");
		scoreList.add(23);
		System.out.println("1.add size:"+scoreList.size());
		System.out.println(">>ArrayList:"+scoreList);
		
		//int getScore = (int) scoreList.get(scoreList.size()-1);
		int getScore = (Integer) scoreList.get(scoreList.size()-1);
		System.out.println("2.get(10):"+getScore);
		
		int removeScore = (Integer) scoreList.remove(0);	//인자로 Index값을 받음
		System.out.println("3.remove(index):"+removeScore);
		
		Boolean isRemove = scoreList.remove(new Integer(99));	//인자로 Object를 받는 경우 -> Object의 값으로 찾아 삭제
		System.out.println("3.remove(Object):"+isRemove);
		
		isRemove = scoreList.remove("가나다");
		System.out.println("3.remove(Object):"+isRemove);
		//원래 기본적으로 .equals()는 객체의 주소를 비교하는 것인데
		//String과 Wrapper클래스의 .equals()는 값비교이다.
		
		ArrayList<Account> arrList = new ArrayList<Account>();
		arrList.add(new Account());
		arrList.get(0);
	}

}
