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
			System.out.println("Ŭ���̾�Ʈ ���� ���� : "+socket);
			System.out.println("���� ����");
		}catch(Exception e1){
			System.out.println("���� : "+e1.getMessage());
		}
	}
	
	/*
	 * �������κ��� �б�
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
	 * ���Ͽ� ����
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
