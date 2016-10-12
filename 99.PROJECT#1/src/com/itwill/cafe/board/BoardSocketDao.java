package com.itwill.cafe.board;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class BoardSocketDao {
	int boardNo = 0;
	private Socket socket;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	public BoardSocketDao()  {
		try{
			socket = new Socket("192.168.12.12", 8888);
			System.out.println("클라이언트 소켓 생성 : "+socket);
			System.out.println("소켓 생성");
		}catch(Exception e1){
			System.out.println("에러 : "+e1.getMessage());
		}
	}
	
	/*
	 * 소켓으로부터 읽기
	 */
	private ArrayList<Board> readData() throws Exception {
		String signal = "sendAll";
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(signal);
		out.flush();
		out.close();
	
		in = new ObjectInputStream(socket.getInputStream());
		ArrayList<Board> boardList = (ArrayList<Board>) in.readObject();
		in.close();
		return boardList;
	}
	
	
	
	/*
	 * 소켓에 쓰기
	 */
	public void saveData(ArrayList<Board> boardList) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(boardList);
		oos.flush();
		oos.close();
	}


	/**
	 * @throws Exception
	 **************************************/

	/*
	 * 게시판 생성
	 */
	public void insertBoard(Board board) throws Exception {

		ArrayList<Board> boardList = this.readData();
		boardList.add(board);
		this.saveData(boardList);
	}

	/*
	 * 게시판 삭제
	 */
	public void deleteBoard(int no) throws Exception {
		ArrayList<Board> boardList = this.readData();
		for (Board board : boardList) {
			if (board.getNo() == no) {
				boardList.remove(board);
				break;
			}
		}
		this.saveData(boardList);
	}

	/*
	 * 전체 게시판 보기(게시판번호,게시판이름,게시판유형,게시판권한)
	 */
	public ArrayList<Board> allBoard() throws Exception {
		ArrayList<Board> boardList = this.readData();
		return boardList;
	}

	/*
	 * 접근권한 있냐?
	 */
	public boolean authCheck(int no, int auth) throws Exception {
		boolean authC = false;
		ArrayList<Board> boardList = this.readData();
		for (Board board : boardList) {
			if (1 == no) { // ui에서 게시판을 선택시 선택된 게시판의 번호를 no로 가져온다
							// 참이면 다음으로 진행.. 보드의 권한을 가져오고 사용자의 권한을
							// 비교한다.
				if (board.getBoardAuth() <= auth) {
					authC = true;
					return authC;
				}
			}
		}
		return authC;
	}

	/*
	 * 게시판 번호로 찾기
	 */
	public Board selectByNo(int no) throws Exception {
		Board findBoard = null;
		ArrayList<Board> boardList = this.readData();
		for (Board board : boardList) {
			if (board.getNo() == no) {
				findBoard = board;
				break;
			}
		}
		return findBoard;
	}

	/*
	 * 게시판 권한으로 찾기
	 */
	public ArrayList<Board> selectByAllAuth(int auth) throws Exception {
		ArrayList<Board> findBoard = new ArrayList<Board>();
		ArrayList<Board> boardList = this.readData();
		for (Board board : boardList) {
			if (board.getBoardAuth() >= auth) {
				findBoard.add(board);
			}
		}
		return findBoard;
	}

	/*
	 * 게시판 수정
	 */
	public boolean boardUpdate(Board upboard) throws Exception { 	// up보드의 정보를
																	// 가져와서(수정시 수정할 게시판의 번호와
																	// 변경할 내용 모두를 입력한다.)
																	// 형성되어있는 번호와 비교, 번호가 있으면 수정한다.
		ArrayList<Board> boardList = this.readData();
		for (Board board : boardList) {
			if (board.getNo() == upboard.getNo()) {
				//board.setNo(upboard.getNo());
				board.setBoardAuth(upboard.getBoardAuth());
				board.setBoardTitle(upboard.getBoardTitle());
				board.setBoardType(upboard.getBoardType());
				this.saveData(boardList);
				return true;
			} 
		}
		this.saveData(boardList);
		return false;
	}
}
