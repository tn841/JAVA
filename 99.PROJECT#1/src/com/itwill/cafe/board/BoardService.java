package com.itwill.cafe.board;

import java.util.ArrayList;

import com.itwill.cafe.comment.CommentDao;
import com.itwill.cafe.member.MemberDao;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostDao;

/*
 * 	게시판을 관리하기 위한 서비스 클래스
 */
public class BoardService {
	/*
	 * 게시판 서비스 구현에 필요한  DAO 객체 선언
	 */	
	private BoardDao boardDao;
	private PostDao postDao;
	
	
	/*
	 * BoardService 생성자
	 * 	- Dao객체들 생성 (new xxxDao();)
	 */
	public BoardService() throws Exception{
		boardDao = new BoardDao();
	}
	
	
	/*
	 * 	1. 게시판 생성
	 * 	- 필요한 인자
	 * 		: 게시판 이름, 게시판 열람 권한, 게시판 유형
	 *  - 반환값
	 *  	: 성공시 true, 실패시 false
	 *  - 기타
	 *  	: 게시판 고유번호는 자동으로 생성
	 */
	public boolean createBoard(Board board) throws Exception{
		System.out.println("게시판을 생성합니다.\n필요한 정보 : (Board) 게시판 고유번호(int), 게시판제목(String), 게시판고유권한(int), 게시판 타입(int)");
		ArrayList<Board> boardList = boardDao.allBoard();
		int su =  boardList.get(boardList.size()-1).getNo()+1;
		board.setNo(su);
		boardDao.insertBoard(board);
		return true;
	}
	
	
	/*
	 * 	2. 게시판 수정
	 *  - 필요한 인자
	 *  	: 게시판 고유 번호
	 *  - 반환값
	 *  	: 성공시 true, 실패시 false
	 */
	public boolean modifyBoard(Board upboard) throws Exception{
		System.out.println("게시판을 수정합니다.\n필요한 정보 : (Board) 게시판 고유번호(int), 게시판제목(String), 게시판고유권한(int), 게시판 타입(int)");
		boolean ch = boardDao.boardUpdate(upboard); //upboard는 업데이트할 보드의 정보 모두를 가져와야함.. 번호체크 및 수정이 DAO에 들어있음
		return ch;
	}
	
	/*
	 * 	3. 게시판 삭제
	 *  - 필요한 인자
	 *  	: 게시판 고유 번호
	 *  - 반환값
	 *  	: 성공시, 실패시
	 */
	public boolean deleteBoard(int no) throws Exception{
		System.out.println("게시판을 삭제합니다.\n필요한 정보 : 게시판 고유번호(int)"); // 해당번호의 게시판이 없을때?
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
	 * 	4. 게시글 검색
	 * 	- 필요한 인자
	 * 		: 게시판 고유번호, 검색어
	 *  - 반환값
	 *  	: 게시글 객체들 
	 */
	public ArrayList<Post> findPostByKeyword(int no,String keyword) throws Exception{
		System.out.println("게시판의 게시글을 검색합니다.\n필요한 정보 : 게시판 고유번호(int), 검색어(String)");
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
	 *  5.게시판 타입 선별
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
	 *  6. 페이지 네이션구현..
	 */
	//public ArrayList<Post> page() throws Exception{
		
	//s}
	
	
	/*
	 *  7. 게시판 고유번호로 게시판 VO객체 하나 찾기
	 */
	public Board selectByNo(int no) throws Exception{
		return boardDao.selectByNo(no);
	}
	
	/*
	 *  8. 게시판 권한별로 게시판 ArrayList찾기
	 */
	public ArrayList<Board> selectByAuth(int auth) throws Exception{
		return boardDao.selectByAllAuth(auth);
	}
}
