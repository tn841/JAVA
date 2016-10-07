package com.itwill.cafe.comment;

import java.util.ArrayList;
import java.util.Calendar;

import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.member.MemberDao;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostDao;

/*
 * 게시글을 관리하는 클래스
 */
public class CommentService {
	/*
	 * 게시글 서비스 구현에 필요한 Dao 객체선언
	 */
	private MemberDao memberDao;
	private PostDao postDao;
	private CommentDao commentDao;
	
	/*
	 * CommentService 생성자
	 * 	- Dao객체들 생성
	 */
	public CommentService() throws Exception{
		postDao = new PostDao();
		commentDao = new CommentDao();
		memberDao = new MemberDao();
	}
	
	
	
	
	
	/******************* 영범 추가 **********************/
	/******************** 댓글 **************************/
	/****************************************************/
	/****************************************************/
	/****************************************************/
	
	/*
 		VO 찾기	*******************************************************
	 */

	//모든 코멘트 찾기(ArrayList)
	public ArrayList<Comment> allComments() throws Exception{
		return commentDao.selectAll();
	}

	//번호로 코멘트 하나 찾기(Comment)
	public Comment findCommentByNo(int no) throws Exception{
		return commentDao.selectByNo(no);
	}

	//작성자로 코멘트 여럿 찾기(ArrayList)
	public ArrayList<Comment> findCommentsByName(String name) throws Exception{
		return commentDao.selectByName(name);
	}

	//게시글 번호로 코멘트 여럿 찾기(ArrayList)
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

	//UI 이벤트 시 알맞는 댓글VO 고유 넘버 리턴
	public int getCmtNoByAction(int i, int postNo) throws Exception{
		return findCommentsByPostNo(postNo).get(i).getCmtNo();
	}
	
	//로그인 된 멤버 이름 찾기
	public String findeLoginMemberName() throws Exception{
		
		if (FirstPageService.getActiveMember()==null) {
			return "비회원";
		}
		else	return FirstPageService.getActiveMember().getName();
	}
	
	//모든 게시글 보기
	public ArrayList<Post> allPost() throws Exception{
		return postDao.selectAll();
	}
	
	
	
	/*
 	글쓰기 *******************************************************
	 */

	
	//작성 된 comment -> File저장 -> 객체 불러옴
	//name은 회원 dao에서 로그인된 놈(selectLogin()) 객체받아서 getName(getId)
	//cmtContent는 UI에서 받음
	//현재 보여지고 있는 게시글의 고유번호 받음 
	public Comment writeComment(String name,String cmtContent, int postNo) throws Exception{
		commentDao.insert(new Comment(getCmtNo(),name, cmtContent, postNo));
		return commentDao.selectByNo(getCmtNo()-1);
	}

	//reDate write
	public Comment reWriteCmt(String name,String cmtContent, int postNo,int index) throws Exception{
		commentDao.insertAt(new Comment(getCmtNo(),name, cmtContent, postNo),index);
		return commentDao.selectByNo(getCmtNo()-1);
	}
	//고유넘버 생성
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
 	VO에서 String 분리 *******************************************************
	 */

	//객체에서 작성자 분리
	public String getName(Comment comment){
		if (comment!=null) {
			return comment.getWriterName();
		}
		return null;
	}

	//객체에서 글쓴시간 분리(Calendar -> String)
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

	//객체에서 작성글 분리
	public String getComment(Comment comment){
		if (comment != null) {
			return comment.getCmtContent();
		}
		return null;
	}

	//작성자 시간
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


	
	
	
	
	
	
	
	
	
	//*********************** Test용 **************************
	//*********************** Test용 **************************
	//*********************** Test용 **************************
	//*********************** Test용 **************************
	
	//Reset
	public void cmtreset() throws Exception{
		commentDao.testReset();
	}
	
	
	

}
