package com.itwill.Collection;
/**
   은행에서 사용하는 계좌 객체를 일반화한 클래스
   가격 300원
  @author KIM
  @version 0.1
  @since 0.1
 */
public class Account implements Comparable{
	
	private String no;  //계좌번호
	private String owner;//계좌주
	private int balance;//잔고
	private double iyul;//이율
	
	@Override
	public int compareTo(Object o) {	//Arrays.sort() 메소드 호출시 사용된다.
		Account nextAcc = (Account) o;
		return this.balance - nextAcc.getBalance();	//반환값이 0이면 같다. this.Account < nextAccount 이면 오름차순 
	}
	
	/**
	 * 기본값으로 초기화된 계좌객체생성자
	 */
	public Account() {
	
	}
	/**
	 * 인자값으로 초기화된 계좌객체생성자
	 * @param no 		계좌번호
	 * @param owner		계좌주
	 * @param balance	잔고
	 * @param iyul		이율
	 */
	public Account(String no, String owner, int balance, double iyul) {
		
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}


	/*
	 * 입금
	 */
	/**
	 * 입금메쏘드
	 * @param m 입금할돈
	 */
	public void saveMoney(int m){
		this.balance=this.balance+m;
		//this.balance+=m;
	}
	
	/*
	 * 출금
	 */
	/**
	 * 출금메쏘드
	 * @param m 출금할돈 양수만가능
	 */
	public void withdrawMoney(int m){
		
		this.balance=this.balance-m;
		if(this.balance<0){
			this.balance = this.balance + m;
			System.out.println(">>잔고부족");
		}
		
	}
	public void headerPrint(){
		System.out.println("*********************************");
		System.out.println("번호\t이름\t잔고\t이율");
		System.out.println("*********************************");
	}
	public void footerPrint(){
		System.out.println("*********************************");
	}
	/**
	 * 계좌정보 출력
	 */
	public void print(){
		System.out.println(
				this.no+"\t"+
				this.owner+"\t"+
				this.balance+"\t"+
				this.iyul);
	}
	
	/*
	 * Account data set
	 */
	public void setAccountData(
			String no,String owner,int balance,double iyul){
		/*
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
		*/
		this.setNo(no);
		this.setOwner(owner);
		this.setBalance(balance);
		this.setIyul(iyul);
	}
	
	//setter,getter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * 계좌의 잔고를 반환하는메쏘드
	 * @return 계좌잔고
	 */
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getIyul() {
		return iyul;
	}
	public void setIyul(double iyul) {
		this.iyul = iyul;
	}
	
	
	
	
	
}
