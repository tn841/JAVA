package com.itwill.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysCollectionsUtilMain {


	public static void main(String[] args) {
		/**
		 * 배열
		 */
		//1. 기본 타입 정렬
		int[] arr = {15, 35 ,89 ,65 ,12 ,45 ,64 ,32 ,35 ,78 ,56};
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		
		String[] strArr = {"동해물과", "백두산이", "마르고", "닳도록", "하느님이", "보우하사", "우리나라", "만세"};
		Arrays.sort(strArr);
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i]+" ");
		}
		System.out.println();
		System.out.println();
		
		//2. 객체 타입 정렬
		Account[] accounts = {
				new Account("1111", "BONG", 56888, 0.02),
				new Account("2222", "AONG", 23000, 0.03),
				new Account("3333", "DONG", 33000, 0.04),
				new Account("4444", "FONG", 99000, 0.12),
				new Account("5555", "HONG", 78000, 0.08),
				new Account("6666", "CONG", 45000, 0.03),
				new Account("7777", "DONG", 67000, 0.28),
				new Account("8888", "ZONG", 33000, 0.68),
				new Account("9999", "OONG", 22000, 0.88),
		};
		
		
		//comparable 인터페이스를 이용한 정렬
		System.out.println(">>번호 오름차순(Comparable");
		Arrays.sort(accounts);	
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		
		//comparator 인터페이스를 이용한 정렬
		System.out.println(">>잔고 오름차순(Comparator)");
		Arrays.sort(accounts, new AccountBalanceComparator());
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		System.out.println(">>이름 오름차순(Comparator)");
		Arrays.sort(accounts, new AccountNameComparator(0));
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		

		
		/*MyArrays.sort(accounts);
		for (int i = 0; i < accounts.length; i++) {
					accounts[i].print();
		}*/
		
		
		/**
		 * Collections
		 */
		ArrayList<Account> accList = new ArrayList<Account>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<String> strList = new ArrayList<String>();
		
		
		intList.add(13);
		intList.add(36);
		intList.add(38);
		intList.add(97);
		intList.add(65);
		intList.add(15);
		intList.add(64);
		
		Collections.sort(intList);
		
		/*
		 * enhanced for
		 */
		for(Integer tempScore : intList){
			System.out.print(tempScore+" ");
		}
		System.out.println();
		
		strList.add("asd");
		strList.add("ger");
		strList.add("wnv");
		strList.add("xde");
		strList.add("rgg");
		strList.add("jjy");
		strList.add("qcb");
		
		Collections.sort(strList);
		for(String tempList : strList){
			System.out.print(tempList+ " ");
		}
		System.out.println();
		
		
		for(int i=0; i<accounts.length; i++){
			accList.add(accounts[i]);
		}
		
		Collections.sort(accList, new Comparator<Account>(){
			@Override
			public int compare(Account o1, Account o2) {
				return o1.getOwner().compareTo(o2.getOwner());
			}
		});
		
		for(Account tempList : accList){
			tempList.print();
		}
		
		System.out.println();
		
		Collections.sort(accList, new Comparator<Account>(){
			@Override
			public int compare(Account o1, Account o2) {
				return o2.getOwner().compareTo(o1.getOwner());
			}
		});
		
		//Collections.sort(accList, new AccountNameComparator());	//comparator 인터페이스를 구현한 객체를 인자로 전달.
		for(Account tempList : accList){
			tempList.print();
		}
		
		
	}

}
