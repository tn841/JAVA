package com.itwill.Collection;

public class GenericMain {
	public static void main(String[] arg){
		/*************************제네릭스 미사용***************************/
		NoGeneric ng = new NoGeneric();
		ng.setMember(new Account());
		Account tempAcc = (Account)ng.getMember();	//Account 객체로 캐스팅
		tempAcc.print();
		
		ng.setMember(new Car());
		Car tempCar = (Car)ng.getMember();	//Car 객체로 캐스팅
		tempCar.print();
		
		
		/******************제네릭스 사용**********************/
		Generics<Account> gene = new Generics<Account>();	//제네릭스를 <Account>로 선언했으므로 오직 Account객체만 담을 수 있다.
		gene.setMember(new Account("123", "sumin", 4562000, 0.55));
		tempAcc = gene.getMember();	//캐스팅이 필요없다.
		tempAcc.print();
		
		
	}
}
