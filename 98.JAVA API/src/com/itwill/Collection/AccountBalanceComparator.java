package com.itwill.Collection;

import java.util.Comparator;

public class AccountBalanceComparator implements Comparator<Account> {
	
	public AccountBalanceComparator() {
	
	}
	
	public AccountBalanceComparator(int type){
		
	}
	
	@Override
	public int compare(Account o1, Account o2) {
		return o1.getBalance() - o2.getBalance();	//앞에서 뒤를 뺀다 -> ASC
	}
}
