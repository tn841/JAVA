package com.itwill.cafe.board;

public class BoardMain {
/*
 * VO클래스와 DAO클래스를 가지고 Main에서 동작이 잘 되는지 테스트
 */
	 
	public static void main(String[] args) throws Exception {
		BoardService bServ = new BoardService();
		bServ.createBoard(new Board(0, "게시판1", 3, 0));
		bServ.createBoard(new Board(0, "게시판2", 2, 0));
		bServ.createBoard(new Board(0, "게시판3", 2, 0));
		bServ.createBoard(new Board(0, "게시판4", 1, 1));
		bServ.createBoard(new Board(0, "게시판5", 0, 0));
		
	}

}
