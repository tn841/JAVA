package com.itwill.cafe.board;

import java.util.ArrayList;

import com.itwill.cafe.comment.CommentDao;
import com.itwill.cafe.member.MemberDao;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostDao;

/*
 * 	�Խ����� �����ϱ� ���� ���� Ŭ����
 */
public class BoardService {
	/*
	 * �Խ��� ���� ������ �ʿ���  DAO ��ü ����
	 */	
	private BoardDao boardDao;
	private PostDao postDao;
	
	
	/*
	 * BoardService ������
	 * 	- Dao��ü�� ���� (new xxxDao();)
	 */
	public BoardService() throws Exception{
		boardDao = new BoardDao();
	}
	
	
	/*
	 * 	1. �Խ��� ����
	 * 	- �ʿ��� ����
	 * 		: �Խ��� �̸�, �Խ��� ���� ����, �Խ��� ����
	 *  - ��ȯ��
	 *  	: ������ true, ���н� false
	 *  - ��Ÿ
	 *  	: �Խ��� ������ȣ�� �ڵ����� ����
	 */
	public boolean createBoard(Board board) throws Exception{
		System.out.println("�Խ����� �����մϴ�.\n�ʿ��� ���� : (Board) �Խ��� ������ȣ(int), �Խ�������(String), �Խ��ǰ�������(int), �Խ��� Ÿ��(int)");
		ArrayList<Board> boardList = boardDao.allBoard();
		int su =  boardList.get(boardList.size()-1).getNo()+1;
		board.setNo(su);
		boardDao.insertBoard(board);
		return true;
	}
	
	
	/*
	 * 	2. �Խ��� ����
	 *  - �ʿ��� ����
	 *  	: �Խ��� ���� ��ȣ
	 *  - ��ȯ��
	 *  	: ������ true, ���н� false
	 */
	public boolean modifyBoard(Board upboard) throws Exception{
		System.out.println("�Խ����� �����մϴ�.\n�ʿ��� ���� : (Board) �Խ��� ������ȣ(int), �Խ�������(String), �Խ��ǰ�������(int), �Խ��� Ÿ��(int)");
		boolean ch = boardDao.boardUpdate(upboard); //upboard�� ������Ʈ�� ������ ���� ��θ� �����;���.. ��ȣüũ �� ������ DAO�� �������
		return ch;
	}
	
	/*
	 * 	3. �Խ��� ����
	 *  - �ʿ��� ����
	 *  	: �Խ��� ���� ��ȣ
	 *  - ��ȯ��
	 *  	: ������, ���н�
	 */
	public boolean deleteBoard(int no) throws Exception{
		System.out.println("�Խ����� �����մϴ�.\n�ʿ��� ���� : �Խ��� ������ȣ(int)"); // �ش��ȣ�� �Խ����� ������?
		ArrayList<Board> aboard = boardDao.allBoard();
		for (Board board : aboard) {
			if (board.getNo() == no) {
				boardDao.deleteBoard(no);
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 	4. �Խñ� �˻�
	 * 	- �ʿ��� ����
	 * 		: �Խ��� ������ȣ, �˻���
	 *  - ��ȯ��
	 *  	: �Խñ� ��ü�� 
	 */
	public ArrayList<Post> findPostByKeyword(int no,String keyword) throws Exception{
		System.out.println("�Խ����� �Խñ��� �˻��մϴ�.\n�ʿ��� ���� : �Խ��� ������ȣ(int), �˻���(String)");
		ArrayList<Post> fbbk = null;
		Board boardNo = boardDao.selectByNo(no);
		if (boardNo.getNo() == no) {
			fbbk = postDao.selectByTitle(keyword);
		}
		return fbbk;
	}
	
	public ArrayList<Board> allBoard() throws Exception {
        return boardDao.allBoard();
	}
	
	
	/*
	 *  5.�Խ��� Ÿ�� ����
	 */
	public ArrayList<Post> findPostByBoardtype(int no) throws Exception{
		ArrayList<Post> fpbbt = postDao.selectAll();
		ArrayList<Post> result = null;
		for (Post postList : fpbbt) {
//			if (postList.getBoardNo == no) {
//				result = fpbbt;
//			}
		}
		
		return result;
	}
	/*
	 *  6. ������ ���̼Ǳ���..
	 */
	//public ArrayList<Post> page() throws Exception{
		
	//s}
	
	
	/*
	 *  7. �Խ��� ������ȣ�� �Խ��� VO��ü �ϳ� ã��
	 */
	public Board selectByNo(int no) throws Exception{
		return boardDao.selectByNo(no);
	}
	
	/*
	 *  8. �Խ��� ���Ѻ��� �Խ��� ArrayListã��
	 */
	public ArrayList<Board> selectByAuth(int auth) throws Exception{
		return boardDao.selectByAllAuth(auth);
	}
}
