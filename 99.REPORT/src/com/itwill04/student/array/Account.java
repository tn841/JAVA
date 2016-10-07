package com.itwill04.student.array;

/**
 * 은행에서 사용하는 계좌 객체를 일반화한 클래스
 * @author SUMIN
 * @version 0.1
 * @since 0.1
 * 
 *
 */
public class Account {
	private String no;		//계좌번호
	private String ower;	//계좌 주 이름
	private int balance;	//잔고
	private double iyul;	//이율
	/**
	 * 기본값으로 초기화된 계좌객체생성
	 */
	public Account(){
		
	}
	/**
	 * 
	 * @param no 계좌번호
	 * @param ower	계좌주
	 * @param balance	잔고
	 * @param iyul	이율
	 */
	public Account(String no, String ower, int balance, double iyul) {
		this.no = no;
		this.ower = ower;
		this.balance = balance;
		this.iyul = iyul;
	}

	/*
	 * 입금
	 */
	/**
	 * 입금 메소드
	 * @param m
	 */
	public void saveMoney(int m){
		this.balance += m;
	}
	
	/*
	 * 출금
	 */
	/**
	 * 출금메소드
	 * @param m 출금할돈 양수만가능
	 */
	public void withdrawMoney(int m){
		if(this.balance-m < 0){
			System.out.println("잔고가 부족하여 출금 할 수 없습니다.");
			return;
		}
		this.balance -= m;
	}
	
	/*
	 * 출력
	 */
	/**
	 * 계좌정보 출력
	 */
	public void print(){
		System.out.println(
				this.no+"\t"+
				this.ower+"\t"+
				this.balance+"\t"+
				this.iyul);
	}
	
	
	/*
	 * Account data set
	 */
	public void setAccountData(String no, String owner, int balance, double iyul){
		this.setNo(no);
		this.setOwer(owner);
		this.setBalance(balance);
		this.setIyul(iyul);
	}
	
	
	//setter, getter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOwer() {
		return ower;
	}
	public void setOwer(String ower) {
		this.ower = ower;
	}
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
