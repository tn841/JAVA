package com.itwill06.student.lotto;

public class LottoServiceMain {

	public static void main(String[] args) {
		
		LottoService LottoServ = new LottoService();
		LottoServ.generateNumber(5);
		LottoServ.print();
		
	}

}
