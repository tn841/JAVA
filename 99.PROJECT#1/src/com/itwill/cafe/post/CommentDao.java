package com.itwill.cafe.post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class CommentDao {
	private int noCount=1;
	public CommentDao() throws Exception {
		init();
	}
	
	/****************************************/	
	private File file;
	/*
	 * �ʱ�ȭ�޽��
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
	 * �����б�(����)
	 */
	private ArrayList<Comment> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Comment> commentList = (ArrayList<Comment>)ois.readObject();
		return commentList;
	}

	/*
	 * ���Ͼ���(��������)
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
		this.noCount++;
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
	
//	deselect
	public void cmtDeSelect() throws Exception{
		ArrayList<Comment> cList = readData();
		for (Comment comment : cList) {
			comment.setSelected(false);
		}
		saveData(cList);
	}
	
//	select By true
	Comment selectByTrue() throws Exception{
		ArrayList<Comment> cList = readData();
		Comment tempComment = null;
		for (Comment comment : cList) {
			if (comment.isSelected()==true) {
				tempComment = comment;
			}
		}
		return tempComment;
	}
	
//	delete by no
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
	
//	delete by isSelected
	void deleteByTrue() throws Exception{
		ArrayList<Comment> commentList = readData();
		for (Comment comment : commentList) {
			if (comment.isSelected() == true) {
				commentList.remove(comment);
				break;
			}
		}
		this.saveData(commentList);
	}
	
//	update(���� �ѹ��� �ڸ�Ʈ ����)
	void updateByNo(Comment updateComment) throws Exception{
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
	
//	update(���õǾ��� comment ���븸 ����)
	void updateBySelect(String cmtContent) throws Exception{
		ArrayList<Comment> commentList = readData();
		for (Comment comment : commentList) {
			if (comment.isSelected()==true) {
				comment.setCmtContent(cmtContent);
				comment.setWriteTime(Calendar.getInstance());
				break;
			}
		}
		saveData(commentList);
	}
	
	
//	Test�� Data reset
	public void testReset() throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(new ArrayList<Comment>());
		oos.close();
	}
	
//	getter setter
	int getCount() {
		return noCount;
	}
	void setCount(int count) {
		this.noCount = count;
	}
	
	
	
	
	
	
	
	
	
	
}
