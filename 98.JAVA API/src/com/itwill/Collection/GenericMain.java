package com.itwill.Collection;

public class GenericMain {
	public static void main(String[] arg){
		/*************************���׸��� �̻��***************************/
		NoGeneric ng = new NoGeneric();
		ng.setMember(new Account());
		Account tempAcc = (Account)ng.getMember();	//Account ��ü�� ĳ����
		tempAcc.print();
		
		ng.setMember(new Car());
		Car tempCar = (Car)ng.getMember();	//Car ��ü�� ĳ����
		tempCar.print();
		
		
		/******************���׸��� ���**********************/
		Generics<Account> gene = new Generics<Account>();	//���׸����� <Account>�� ���������Ƿ� ���� Account��ü�� ���� �� �ִ�.
		gene.setMember(new Account("123", "sumin", 4562000, 0.55));
		tempAcc = gene.getMember();	//ĳ������ �ʿ����.
		tempAcc.print();
		
		
	}
}
