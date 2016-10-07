package com.itwill.Collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {

	public static void main(String[] args) {
		HashSet<Account> accountSet = new HashSet<Account>();
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
		
		System.out.println("# Set.size():"+accountSet.size());
		System.out.println("1. add");
		accountSet.add(acc1);
		accountSet.add(acc2);
		accountSet.add(acc3);
		accountSet.add(acc4);
		accountSet.add(acc5);
		accountSet.add(acc6);
		accountSet.add(acc7);
		accountSet.add(acc8);
		accountSet.add(acc9);
		System.out.println("# Set.size():"+accountSet.size());
		System.out.println(">>HashSet:"+accountSet);
		boolean isAdd = accountSet.add(acc1);	//중복이므로 추가 불가능
		System.out.println("add(acc1):"+isAdd);
		Boolean isRemove = accountSet.remove(acc1);
		System.out.println("remove(acc1):"+isRemove);
		System.out.println("# Set.size():"+accountSet.size());
//		System.out.println("# HashSet --> Object[]");
//		Object[] objArr = accountSet.toArray();
//		for (int i = 0; i < objArr.length; i++) {
//			Account temp = (Account)objArr[i];
//			temp.print();
//		}
		
		//Iterator 이용하여 내용 출력
		System.out.println("# HashSet --> Iterator이용 출력");
		Iterator<Account> accIter = accountSet.iterator();

//		while(accIter.hasNext()){
//			//accIter.next().print();
//		}
		
		while (accIter.hasNext()) {
			Account tempAcc=accIter.next();
			System.out.print(tempAcc.getNo()+", ");
		}
		System.out.println();
		System.out.println();

		
		System.out.println("----------기본형-------------");
		HashSet lottoSet = new HashSet();
		while(lottoSet.size()<6){
			lottoSet.add((int)(Math.random()*45)+1);
		}
		System.out.println("# lottoSet.size():"+lottoSet.size());
//		Object[] temp = lottoSet.toArray();
//		for (int i = 0; i < temp.length; i++) {
//			System.out.print(temp[i]+", ");
//		}
		
		
		
		
		
		System.out.println();
		System.out.println(lottoSet.toString());
		
		System.out.println("----------String-------------");
		HashSet<String> stringSet = new HashSet<String>();
		
		String str1 = "ABC";
		String str2 = "BBC";
		String str3 = "CBC";
		String str4 = "DBC";
		String str5 = "JBC";
		String str6 = "HBC";
		String str7 = "IBC";
		String str8 = "ZBC";
		String str9 = "WBC";
		
		stringSet.add(str1);
		stringSet.add(str2);
		stringSet.add(str3);
		stringSet.add(str4);
		stringSet.add(str5);
		stringSet.add(str6);
		stringSet.add(str7);
		stringSet.add(str8);
		stringSet.add(str9);
		
		boolean isAdd2 = stringSet.add(str1);
		System.out.println("Add여부 :"+isAdd2);	//값비교
	
		System.out.println("----------Iteration-----------");
		Iterator<String> stringIter = stringSet.iterator();
		
		while(stringIter.hasNext()){
			System.out.println(stringIter.next());
		}
		
	}

}
