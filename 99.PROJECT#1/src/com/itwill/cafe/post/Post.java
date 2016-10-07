package com.itwill.cafe.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.itwill.cafe.comment.Comment;

/*
 * 	- 게시글을 정의하는 VO클래스 진성
 */
public class Post implements Serializable, Comparable<Post>{
	public static final int FREEBOARD=0;
	public static final int IMAGEBOARD=1;
	
	private int no;	//게시글 고유번호
	private String noStr;
	//private String noStr; //고유번호 String변환
	private String postTitle;	//게시글 제목
	private String postWriter;	//게시글 작성자
	private String posttingDate;	//게시글 작성일
	private int postHits;       //게시글 조회수
	private int postCount;		//게시글 생성시마다 ++
	private String postContent;	//게시글 내용
	private ArrayList<Comment> postComment;	//게시글 댓글List
	private int postLike;		//게시글 좋아요 수
	private int boardNo;
	
	


	public Post() {
		this.getNo();
	}

	public Post(String postTitle, String postContent) {
		//this.numberG();
		this.postTitle = postTitle;
		this.postContent = postContent;
		//this.postWriter
		this.posttingDate();
	}
	
	public Post(String postTitle, String postContent, int boardNo) {
		//this.numberG();
		this.boardNo = boardNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		//this.postWriter
		this.posttingDate();
	}
	
	@Override
	public String toString(){
		return no+"\t"+postTitle+"\t"+postContent+"\t"+postWriter+"\t"+posttingDate+"\t 게시판 번호 :"+boardNo;
	}
	public void numberG(){
		 
		this.no = this.no+postCount;
		this.noStr= "$$"+this.no;
		postCount=postCount+1;
		
	}

	public void posttingDate(){
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int am_pm=cal.get(Calendar.AM_PM);
		//int hour_of_day = cal.get(Calendar.HOUR_OF_DAY);
		String apm = Integer.toString(am_pm);
	
		String ampm="오전";
		if(apm.equals("0")){
			  ampm="오전";
		}else{
			  ampm="오후";
		}
		
		this.posttingDate = ""+year+"."+month+"."+day
							+"  "+ampm+hour+":"+min+":"+sec;
	}
	
	
	//getter setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNoStr() {
		return noStr;
	}


	public void setNoStr(String noStr) {
		this.noStr = noStr;
	}
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostWriter() {
		return postWriter;
	}

	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}


	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public ArrayList<Comment> getPostComment() {
		return postComment;
	}

	public void setPostComment(ArrayList<Comment> postComment) {
		this.postComment = postComment;
	}

	public int getPostLike() {
		return postLike;
	}

	public void setPostLike(int postLike) {
		this.postLike = postLike;
	}
	public int getPostHits() {
		return postHits;
	}

	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}
	public String getPosttingDate() {
		return posttingDate;
	}


	public void setPosttingDate(String posttingDate) {
		this.posttingDate = posttingDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public int compareTo(Post o) {
		int nextPost = o.getNo();
		return nextPost-this.no;
	}
}
