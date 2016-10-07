package com.itwill06.student.lotto;

public class LottoService {
	private Lotto[] lottoArray;
	
	public void generateNumber(){
		lottoArray = new Lotto[1];
		lottoArray[0] = new Lotto();
		lottoArray[0].generateNumber();
	}
	
	public void generateNumber(int num){
		lottoArray = new Lotto[num];
		for (int i = 0; i < lottoArray.length; i++) {
			lottoArray[i] = new Lotto();
			lottoArray[i].generateNumber();
		}
	}
	public void print(){
		for (int i = 0; i < lottoArray.length; i++) {
			System.out.print(">> "+(i+1)+".\t");
			lottoArray[i].print();
		}
	}
}
