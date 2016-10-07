package com.itwill07.student.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
 계좌객체들을멤버로가지며
 계좌객체들의 업무실행을하는클래스
   
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
	 * 0.계좌추가
	 */
	public void addAccount(Account addAccount){
		accountList.add(addAccount);
	}
	/*
	 *1.은행 총계좌수 반환 
	 */
	public int getAccountNumber() {
		return accountList.size();
	}
	/*
	 * 2.은행 총잔고반환
	 */
	
	public int getTotBalance(){
		int tot=0;	//총 잔고를 저장할 변수
		Iterator<Account> accIter = accountList.iterator();	//accountList를 순회할 Iterator선언 및 생성
		while(accIter.hasNext()){
			Account accTemp = accIter.next();
			tot += accTemp.getBalance() + tot;
		}
		
		return tot;
	}
	/*
	 * 3.계좌번호인자로 받아서 계좌객체1개 주소 반환
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
	 * 4.계좌주이름인자로 받아서   계좌List객체주소반환
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
	 * 5.계좌잔고인수로(5000)받아서 잔고(5000)이상인  ArrayList객체(계좌객체들)주소반환
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
	 * 6.계좌이율인수로(0.1) 받아서 이율(0.1) 이상인 ArrayList객체(계좌객체들) 주소반환
	 */
	/*
	 *7.계좌들 잔고순으로 내림차순정렬 
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
	8.계좌들 번호(문자열)순으로 오름차순정렬
	*/
	
	
	/*
	 9. 계좌번호와 입금할돈 받아서 입금 
	 */
	public int ipGum(String no, int m) {
		/*
		 * 1.번호로 계좌찾기
		 * 2.잔고증가(update)
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
		 * 입금성공      void return
		 * 계좌번호오류  WrongNumberException
		 * 
		 */
		Account findAccount=this.findByNo(no);
		if(findAccount==null){
			throw new WrongNumberException("잘못된계좌번호 입니다.");
		}
		else{
			findAccount.saveMoney(m);
		}
		
	}
	/*
	 11. 계좌번호와 금액 받아서 출금 
	 */
	
	public void culGum(String no, int money) throws WrongNumberException, BalanceException{
		/*
		 * 입금성공      void return
		 * 계좌번호오류  WrongNumberException
		 * 잔고부족오류  BalanceException
		 */
		
		Account findAcc = this.findByNo(no);

		if(findAcc == null){
			throw new WrongNumberException("없는 계좌 번호 입니다.");
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







