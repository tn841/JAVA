package com.itwill.cafe.board;

public class BoardMain {
/*
 * VOŬ������ DAOŬ������ ������ Main���� ������ �� �Ǵ��� �׽�Ʈ
 */
	 
	public static void main(String[] args) throws Exception {
		BoardService bServ = new BoardService();
		bServ.createBoard(new Board(0, "�Խ���1", 3, 0));
		bServ.createBoard(new Board(0, "�Խ���2", 2, 0));
		bServ.createBoard(new Board(0, "�Խ���3", 2, 0));
		bServ.createBoard(new Board(0, "�Խ���4", 1, 1));
		bServ.createBoard(new Board(0, "�Խ���5", 0, 0));
		
	}

}
