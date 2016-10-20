package com.itwill.cafe.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.cafe.board.Board;

public class BoardServerDao {
	int boardNo = 0;

	public BoardServerDao() throws Exception {
		init();
	}

	private File file;

	private void init() throws Exception {
		file = new File("board.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			ArrayList<Board> boardList = new ArrayList<Board>();
			boardList.add(new Board(0, "자유게시판", 0, 0));
			oos.writeObject(boardList);
			oos.close();
		}
	}

	/*
	 * 파일읽기(연결)
	 */
	public ArrayList<Board> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Board> boardList = (ArrayList<Board>) ois.readObject();
		return boardList;
	}

	/*
	 * 파일쓰기(연결해제)
	 */
	public void saveData(ArrayList<Board> boardList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		System.out.println("서버 로컬에 데이터를 새로 씁니다.");
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
