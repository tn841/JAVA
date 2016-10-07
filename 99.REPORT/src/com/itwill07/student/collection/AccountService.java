package com.itwill07.student.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
 ���°�ü��������ΰ�����
 ���°�ü���� �����������ϴ�Ŭ����
   
 */
public class AccountService {
	public static final int SUCCESS=0;
	public static final int WRONG_NO=1;
	public static final int INSUFFICIENT_BALANCE=2;
	
	private ArrayList<Account> accountList=new ArrayList<Account>();
	
	public AccountService() {
		/*
		accountList.add(new Account(no, owner, balance, iyul))
		accountList.add(new Account(no, owner, balance, iyul))
		accountList.add(new Account(no, owner, balance, iyul))
		accountList.add(new Account(no, owner, balance, iyul))
		accountList.add(new Account(no, owner, balance, iyul))
		accountList.add(new Account(no, owner, balance, iyul))
		*/
	}
	/*
	 * 0.�����߰�
	 */
	public void addAccount(Account addAccount){
		accountList.add(addAccount);
	}
	/*
	 *1.���� �Ѱ��¼� ��ȯ 
	 */
	public int getAccountNumber() {
		return accountList.size();
	}
	/*
	 * 2.���� ���ܰ��ȯ
	 */
	
	public int getTotBalance(){
		int tot=0;	//�� �ܰ� ������ ����
		Iterator<Account> accIter = accountList.iterator();	//accountList�� ��ȸ�� Iterator���� �� ����
		while(accIter.hasNext()){
			Account accTemp = accIter.next();
			tot += accTemp.getBalance() + tot;
		}
		
		return tot;
	}
	/*
	 * 3.���¹�ȣ���ڷ� �޾Ƽ� ���°�ü1�� �ּ� ��ȯ
	 */
	public Account findByNo(String no){
		Account findAccount=null;
		Iterator<Account> accIter = accountList.iterator();
		while(accIter.hasNext()){
			Account tempAcc = accIter.next();
			if(tempAcc.getNo().equals(no)){
				findAccount = tempAcc;
				break;
			}
		}
		return findAccount;
	}
	/*
	 * 4.�������̸����ڷ� �޾Ƽ�   ����List��ü�ּҹ�ȯ
	 */
	public ArrayList<Account> findByOwner(String owner){
		ArrayList<Account> findAccountList = new ArrayList<Account>();
		Iterator<Account> accIter = accountList.iterator();
		while(accIter.hasNext()){
			Account tempAcc = accIter.next();
			if(tempAcc.getOwner().equals(owner)){
				findAccountList.add(tempAcc);
			}
		}
		return findAccountList;
	}
	/*
	 * 5.�����ܰ��μ���(5000)�޾Ƽ� �ܰ�(5000)�̻���  ArrayList��ü(���°�ü��)�ּҹ�ȯ
	 */
	public ArrayList<Account> findByBalance(int balance) {
		ArrayList<Account> findAccountList = new ArrayList<Account>();
		Iterator<Account> accIter = accountList.iterator();
		while(accIter.hasNext()){
			Account tempAcc = accIter.next();
			if(tempAcc.getBalance() >= balance){
				findAccountList.add(tempAcc);
			}
		}
		return findAccountList;
	}
	
	/*
	 * 6.���������μ���(0.1) �޾Ƽ� ����(0.1) �̻��� ArrayList��ü(���°�ü��) �ּҹ�ȯ
	 */
	/*
	 *7.���µ� �ܰ������ ������������ 
	 */
	public void balanceDESC(){
		ArrayList<Account> tempList = new ArrayList<Account>();
		
		Object[] o = accountList.toArray();
		Account[] accObj = new Account[o.length];
		
		for (int i = 0; i < accObj.length; i++) {
			accObj[i] = (Account)o[i];
		}
		
		Arrays.sort(accObj);
		
		
		for (int i = 0; i < accObj.length; i++) {
			tempList.add(accObj[i]);
		}
		 
		accountList = tempList;

	}
	/*
	8.���µ� ��ȣ(���ڿ�)������ ������������
	*/
	
	
	/*
	 9. ���¹�ȣ�� �Ա��ҵ� �޾Ƽ� �Ա� 
	 */
	public int ipGum(String no, int m) {
		/*
		 * 1.��ȣ�� ����ã��
		 * 2.�ܰ�����(update)
		 */
		int result;
		Account tempAcc = this.findByNo(no);
		if(tempAcc==null){
			result = AccountService.WRONG_NO;
		}
		else{
			tempAcc.saveMoney(m);
			result=AccountService.SUCCESS;
		}
		
		return result;
	}
	public void ipGum2(String no, int m) throws WrongNumberException {
		
		
		/*
		 * �Աݼ���      void return
		 * ���¹�ȣ����  WrongNumberException
		 * 
		 */
		Account findAccount=this.findByNo(no);
		if(findAccount==null){
			throw new WrongNumberException("�߸��Ȱ��¹�ȣ �Դϴ�.");
		}
		else{
			findAccount.saveMoney(m);
		}
		
	}
	/*
	 11. ���¹�ȣ�� �ݾ� �޾Ƽ� ��� 
	 */
	
	public void culGum(String no, int money) throws WrongNumberException, BalanceException{
		/*
		 * �Աݼ���      void return
		 * ���¹�ȣ����  WrongNumberException
		 * �ܰ��������  BalanceException
		 */
		
		Account findAcc = this.findByNo(no);

		if(findAcc == null){
			throw new WrongNumberException("���� ���� ��ȣ �Դϴ�.");
		}
		findAcc.withdrawMoney(money);
		
	}
	
	
	
	
	/*******************************************/
	public static void print(Account account){
		account.print();
	}
	
	public static void print(Account[] accArr){
		for (int i = 0; i < accArr.length; i++) {
			accArr[i].print();
		}
	}
	
	public static void print(ArrayList<Account> accounts){
		for (int i = 0; i < accounts.size(); i++) {
			AccountService.print(accounts.get(i));
		}
	}
	/******************************************/
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	

	
}







