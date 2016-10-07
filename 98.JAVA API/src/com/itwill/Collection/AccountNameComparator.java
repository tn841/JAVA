package com.itwill.Collection;

import java.util.Comparator;

public class AccountNameComparator implements Comparator<Account>{
	public static final int ASC = 0;
	public static final int DESC = 1;
	
	private int orderType ;
	
	public AccountNameComparator() {
		this.orderType = AccountNameComparator.ASC;
	}
	
	public AccountNameComparator(int type){
		this.orderType =type;
	}
	
	@Override
	public int compare(Account o1, Account o2) {
		if(orderType == AccountNameComparator.ASC){
			return o1.getOwner().compareTo(o2.getOwner());
		}
		else if(orderType == AccountNameComparator.DESC){
			return o2.getOwner().compareTo(o1.getOwner());
		}
		else{
			throw new RuntimeException("정렬 과정에서 런타임 에러발생");
		}
	}
}
