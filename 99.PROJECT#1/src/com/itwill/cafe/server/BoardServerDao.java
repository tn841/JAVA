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
			boardList.add(new Board(0, "�����Խ���", 0, 0));
			oos.writeObject(boardList);
			oos.close();
		}
	}

	/*
	 * �����б�(����)
	 */
	public ArrayList<Board> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Board> boardList = (ArrayList<Board>) ois.readObject();
		return boardList;
	}

	/*
	 * ���Ͼ���(��������)
	 */
	public void saveData(ArrayList<Board> boardList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		System.out.println("���� ���ÿ� �����͸� ���� ���ϴ�.");
		oos.writeObject(boardList);
		oos.flush();
		oos.close();
	}

	/**
	 * @throws Exception
	 **************************************/

	/*
	 * �Խ��� ����
	 */
	public void insertBoard(Board board) throws Exception {

		ArrayList<Board> boardList = this.readData();
		boardList.add(board);
		this.saveData(boardList);
	}

	/*
	 * �Խ��� ����
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
	 * ��ü �Խ��� ����(�Խ��ǹ�ȣ,�Խ����̸�,�Խ�������,�Խ��Ǳ���)
	 */
	public ArrayList<Board> allBoard() throws Exception {
		ArrayList<Board> boardList = this.readData();
		return boardList;
	}

	/*
	 * ���ٱ��� �ֳ�?
	 */
	public boolean authCheck(int no, int auth) throws Exception {
		boolean authC = false;
		ArrayList<Board> boardList = this.readData();
		for (Board board : boardList) {
			if (1 == no) { // ui���� �Խ����� ���ý� ���õ� �Խ����� ��ȣ�� no�� �����´�
							// ���̸� �������� ����.. ������ ������ �������� ������� ������
							// ���Ѵ�.
				if (board.getBoardAuth() <= auth) {
					authC = true;
					return authC;
				}
			}
		}
		return authC;
	}

	/*
	 * �Խ��� ��ȣ�� ã��
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
	 * �Խ��� �������� ã��
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
	 * �Խ��� ����
	 */
	public boolean boardUpdate(Board upboard) throws Exception { 	// up������ ������
																	// �����ͼ�(������ ������ �Խ����� ��ȣ��
																	// ������ ���� ��θ� �Է��Ѵ�.)
																	// �����Ǿ��ִ� ��ȣ�� ��, ��ȣ�� ������ �����Ѵ�.
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
