package com.itwill.cafe.board;

import java.io.Serializable;
import java.util.ArrayList;

import com.itwill.cafe.post.Post;

/*
 * 	게시판을 정의하는 VO클래스 준상
 */
public class Board implements Serializable{
	private int no;	//게시판 고유 번호
	private String BoardTitle;	//게시판 제목
	private int BoardAuth;	//게시판 열람할 수 있는 권한
	private int BoardType;	//게시판 유형
	private ArrayList<Post> post;	//게시판에 담긴 게시글List
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
