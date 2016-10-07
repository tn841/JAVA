package com.itwill.cafe.comment;

import java.util.ArrayList;
import java.util.Calendar;

import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.member.MemberDao;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostDao;

/*
 * �Խñ��� �����ϴ� Ŭ����
 */
public class CommentService {
	/*
	 * �Խñ� ���� ������ �ʿ��� Dao ��ü����
	 */
	private MemberDao memberDao;
	private PostDao postDao;
	private CommentDao commentDao;
	
	/*
	 * CommentService ������
	 * 	- Dao��ü�� ����
	 */
	public CommentService() throws Exception{
		postDao = new PostDao();
		commentDao = new CommentDao();
		memberDao = new MemberDao();
	}
	
	
	
	
	
	/******************* ���� �߰� **********************/
	/******************** ��� **************************/
	/****************************************************/
	/****************************************************/
	/****************************************************/
	
	/*
 		VO ã��	*******************************************************
	 */

	//��� �ڸ�Ʈ ã��(ArrayList)
	public ArrayList<Comment> allComments() throws Exception{
		return commentDao.selectAll();
	}

	//��ȣ�� �ڸ�Ʈ �ϳ� ã��(Comment)
	public Comment findCommentByNo(int no) throws Exception{
		return commentDao.selectByNo(no);
	}

	//�ۼ��ڷ� �ڸ�Ʈ ���� ã��(ArrayList)
	public ArrayList<Comment> findCommentsByName(String name) throws Exception{
		return commentDao.selectByName(name);
	}

	//�Խñ� ��ȣ�� �ڸ�Ʈ ���� ã��(ArrayList)
	public ArrayList<Comment> findCommentsByPostNo(int postNo) throws Exception{
		ArrayList<Comment> cList = commentDao.selectAll();
		ArrayList<Comment> tempList = new ArrayList<Comment>();
		for (Comment comment : cList) {
			if (comment.getPostNo()==postNo) {
				tempList.add(comment);
			}
		}
		return tempList;
	}

	//UI �̺�Ʈ �� �˸´� ���VO ���� �ѹ� ����
	public int getCmtNoByAction(int i, int postNo) throws Exception{
		return findCommentsByPostNo(postNo).get(i).getCmtNo();
	}
	
	//�α��� �� ��� �̸� ã��
	public String findeLoginMemberName() throws Exception{
		
		if (FirstPageService.getActiveMember()==null) {
			return "��ȸ��";
		}
		else	return FirstPageService.getActiveMember().getName();
	}
	
	//��� �Խñ� ����
	public ArrayList<Post> allPost() throws Exception{
		return postDao.selectAll();
	}
	
	
	
	/*
 	�۾��� *******************************************************
	 */

	
	//�ۼ� �� comment -> File���� -> ��ü �ҷ���
	//name�� ȸ�� dao���� �α��ε� ��(selectLogin()) ��ü�޾Ƽ� getName(getId)
	//cmtContent�� UI���� ����
	//���� �������� �ִ� �Խñ��� ������ȣ ���� 
	public Comment writeComment(String name,String cmtContent, int postNo) throws Exception{
		commentDao.insert(new Comment(getCmtNo(),name, cmtContent, postNo));
		return commentDao.selectByNo(getCmtNo()-1);
	}

	//reDate write
	public Comment reWriteCmt(String name,String cmtContent, int postNo,int index) throws Exception{
		commentDao.insertAt(new Comment(getCmtNo(),name, cmtContent, postNo),index);
		return commentDao.selectByNo(getCmtNo()-1);
	}
	//�����ѹ� ����
	public int getCmtNo() throws Exception{
		int tempNo = 1;
		ArrayList<Comment> cL = commentDao.selectAll();
		for (Comment comment : cL) {
			int temp = comment.getCmtNo();
			if (tempNo <= temp) {
				tempNo = temp;
			}
		}
		tempNo += 1;
		return tempNo;
	}

	
	/*
 	VO���� String �и� *******************************************************
	 */

	//��ü���� �ۼ��� �и�
	public String getName(Comment comment){
		if (comment!=null) {
			return comment.getWriterName();
		}
		return null;
	}

	//��ü���� �۾��ð� �и�(Calendar -> String)
	public String getTime(Comment comment){
		if (comment != null) {
			int year = comment.getWriteTime().get(Calendar.YEAR);
			int month= comment.getWriteTime().get(Calendar.MONTH);
			int day  = comment.getWriteTime().get(Calendar.DAY_OF_MONTH);
			int hour = comment.getWriteTime().get(Calendar.HOUR_OF_DAY);
			int min  = comment.getWriteTime().get(Calendar.MINUTE);
			return year+"."+(month+1)+"."+day+". "+hour+":"+min;
		}
		return null;
	}

	//��ü���� �ۼ��� �и�
	public String getComment(Comment comment){
		if (comment != null) {
			return comment.getCmtContent();
		}
		return null;
	}

	//�ۼ��� �ð�
	public String getNameTime(Comment comment){
		if (comment!=null) {
			return getName(comment)+" "+getTime(comment);
		}else return null;
	}

	
	/*
		deleted ******************************************************
	 */
	public void deleteComment(int no) throws Exception{
		commentDao.deleteByNo(no);
	}
	public void delete(Comment comment) throws Exception{
		commentDao.delete(comment);
	}
	
	
	/*
		Updated *******************************************************
	 */
	public void updateComment(Comment comment) throws Exception{
		commentDao.update(comment);
	}
	public void updateComment(String cmt,int no) throws Exception{
		commentDao.updateByNo(cmt, no);
	}


	
	
	
	
	
	
	
	
	
	//*********************** Test�� **************************
	//*********************** Test�� **************************
	//*********************** Test�� **************************
	//*********************** Test�� **************************
	
	//Reset
	public void cmtreset() throws Exception{
		commentDao.testReset();
	}
	
	
	

}
