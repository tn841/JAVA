package com.itwill.cafe.comment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class CommentDao {
	public CommentDao() throws Exception {
		init();
	}
	
	/****************************************/	
	private File file;
	/*
	 * 초기화메쏘드
	 */
	private void init() throws Exception{
		file = new File("comment.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArrayList<Comment>());
			oos.close();
		}
	}
	/*
	 * 파일읽기(연결)
	 */
	private ArrayList<Comment> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Comment> commentList = (ArrayList<Comment>)ois.readObject();
		return commentList;
	}

	/*
	 * 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<Comment> CommentList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(CommentList);
		oos.flush();
		oos.close();
	}
	

//	insert	
	void insert(Comment comment) throws Exception{
		ArrayList<Comment> commentList = (ArrayList<Comment>)this.readData();
		commentList.add(comment);
		this.saveData(commentList);
	}
	
//	insert At index
	void insertAt(Comment comment, int index) throws Exception{
		ArrayList<Comment> commentList = (ArrayList<Comment>)this.readData();
		commentList.add(index+1, comment);
		this.saveData(commentList);
	}
	
//	selectAll
	public ArrayList<Comment> selectAll() throws Exception{
		ArrayList<Comment> commentList = this.readData();
		return commentList;
	}
	
//	selectByNo
	public Comment selectByNo(int no) throws Exception{
		Comment findComment = null;
		ArrayList<Comment> commentList = this.readData();
		for (Comment comment : commentList) {
			if (comment.getCmtNo()==no) {
				findComment = comment;
				break;
			}
		}
		return findComment;
	}
	
//	selectByName
	public ArrayList<Comment> selectByName(String name) throws Exception{
		ArrayList<Comment> commentList = this.readData();
		ArrayList<Comment> findCommentList = new ArrayList<Comment>();
		for (Comment comment : commentList) {
			if (comment.getWriterName().equals(name)) {
				findCommentList.add(comment);
			}
		}
		return findCommentList;
	}
	
	
	
//	delete by no
	void delete(Comment comment) throws Exception{
		ArrayList<Comment> cList = readData();
		for (Comment comment2 : cList) {
			if (comment2.getCmtNo()==comment.getCmtNo()) {
				cList.remove(comment2);
				break;
			}
		}
		this.saveData(cList);
		
	}
	
	
	void deleteByNo(int no) throws Exception{
		ArrayList<Comment> commentList = readData();
		for (Comment comment : commentList) {
			if (comment.getCmtNo() == no) {
				commentList.remove(comment);
				break;
			}
		}
		this.saveData(commentList);
	}
	
	
//	update(객체로 코멘트 수정)
	void update(Comment updateComment) throws Exception{
		ArrayList<Comment> commentList = readData();
		for (Comment comment : commentList) {
			if (comment.getCmtNo()==updateComment.getCmtNo()) {
				comment.setWriterName(updateComment.getWriterName());
				comment.setCmtContent(updateComment.getCmtContent());
				comment.setWriteTime(Calendar.getInstance());
				break;
			}
		}
		saveData(commentList);
	}
	void updateByNo(String cmt, int no) throws Exception{
		ArrayList<Comment> commentList = readData();
		for (Comment comment : commentList) {
			if (comment.getCmtNo()==no) {
				comment.setCmtContent(cmt);
				comment.setWriteTime(Calendar.getInstance());
				break;
			}
		}
		saveData(commentList);
	}
	
	
//	Test용 Data reset
	public void testReset() throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(new ArrayList<Comment>());
		oos.close();
	}
	
	
	
	
	
	
	
	
	
	
}
