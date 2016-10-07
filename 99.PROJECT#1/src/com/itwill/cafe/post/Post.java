package com.itwill.cafe.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.itwill.cafe.comment.Comment;

/*
 * 	- �Խñ��� �����ϴ� VOŬ���� ����
 */
public class Post implements Serializable, Comparable<Post>{
	public static final int FREEBOARD=0;
	public static final int IMAGEBOARD=1;
	
	private int no;	//�Խñ� ������ȣ
	private String noStr;
	//private String noStr; //������ȣ String��ȯ
	private String postTitle;	//�Խñ� ����
	private String postWriter;	//�Խñ� �ۼ���
	private String posttingDate;	//�Խñ� �ۼ���
	private int postHits;       //�Խñ� ��ȸ��
	private int postCount;		//�Խñ� �����ø��� ++
	private String postContent;	//�Խñ� ����
	private ArrayList<Comment> postComment;	//�Խñ� ���List
	private int postLike;		//�Խñ� ���ƿ� ��
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
		return no+"\t"+postTitle+"\t"+postContent+"\t"+postWriter+"\t"+posttingDate+"\t �Խ��� ��ȣ :"+boardNo;
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
	
		String ampm="����";
		if(apm.equals("0")){
			  ampm="����";
		}else{
			  ampm="����";
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
