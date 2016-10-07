package com.itwill.cafe.board;

import java.io.Serializable;
import java.util.ArrayList;

import com.itwill.cafe.post.Post;

/*
 * 	�Խ����� �����ϴ� VOŬ���� �ػ�
 */
public class Board implements Serializable{
	private int no;	//�Խ��� ���� ��ȣ
	private String BoardTitle;	//�Խ��� ����
	private int BoardAuth;	//�Խ��� ������ �� �ִ� ����
	private int BoardType;	//�Խ��� ����
	private ArrayList<Post> post;	//�Խ��ǿ� ��� �Խñ�List
	public final static int TEXT_TYPE_BOARD = 1;
	public final static int IMAGE_TYPE_BOARD = 2;
	public final static int VOTE_TYPE_BOARD = 3;
	
	public Board(int no, String boardTitle, int boardAuth, int boardType) {
		super();
		this.no = no;
		this.BoardTitle = boardTitle;
		this.BoardAuth = boardAuth;
		this.BoardType = boardType;
	}
	/*
	 private Board(int no, String boardTitle, int boardAuth, int boardType, ArrayList<Post> post) {
		super();
		this.no = no;
		BoardTitle = boardTitle;
		BoardAuth = boardAuth;
		BoardType = boardType;
		this.post = post;
	}
	*/

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBoardTitle() {
		return BoardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}

	public int getBoardAuth() {
		return BoardAuth;
	}

	public void setBoardAuth(int boardAuth) {
		BoardAuth = boardAuth;
	}

	public int getBoardType() {
		return BoardType;
	}

	public void setBoardType(int boardType) {
		BoardType = boardType;
	}

	public ArrayList<Post> getPost() {
		return post;
	}

	public void setPost(ArrayList<Post> post) {
		this.post = post;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return BoardTitle;
	}
}
