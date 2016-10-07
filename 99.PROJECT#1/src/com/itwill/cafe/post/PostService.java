package com.itwill.cafe.post;

import java.util.ArrayList;
import java.util.Collections;

import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.comment.CommentDao;
import com.itwill.cafe.member.MemberDao;

/*
 * 게시글을 관리하는 클래스
 */
public class PostService {
	private PostDao postDao;
	private CommentDao commentDao;
	private BoardDao boardDao;
	private MemberDao memberDao;
	
	/*
	 *  0. Default Constructor
	 */
	public PostService() throws Exception {
		postDao=new PostDao();
		commentDao=new CommentDao();
		boardDao=new BoardDao();
		memberDao=new MemberDao();
	}
	/*
	 * 	1. 게시글을 작성(생성)
	 *   	- UI --> 데이타를 받는다(Post title,Post content)
	 *  	- Post title,Post content --> 받은 데이타를 이용해 PostDao에서 업데이트한다
	 *   	- MemberDao --> 작성자데이타를 받아온다
	 *   	- Post --> 고유번호자동생한다
	 *   	- PostDao --> 게시글을 추가한다.
	 */

	
	public void writePost(Post post, int boardNo) throws Exception{
		Post temp = new Post(post.getPostTitle(), post.getPostContent(), boardNo);
		//postDao.numberG(post);
		ArrayList<Post> postList = postDao.selectAll();
		
		
		if (postList.size()!=0) {
			int su =  postList.get(postList.size()-1).getNo()+1;
			temp.setNo(su);
			postDao.insertPost(temp);
		}
		else{
			temp.setNo(1);
			postDao.insertPost(temp);
		}
		
		
		System.out.println("게시판 번호 기반 게시글 생성"+post.getNo());
		
		//postDao.insertPost(temp);
	}
	/*
	 * ##.게시글 읽기
	 * 		
	 * 
	 */
	public Post readPost(int postNo) throws Exception{
			return postDao.selectByNo(postNo);
	}
	/*
	 * 	2. 게시글을 수정
	 *  	-게시글의 고유번호를 이용하여 게시글을 수정한다 
	 */
	public void modifyPost(Post post) throws Exception{
		postDao.selectByNo(post.getNo());
		postDao.updatePost(post);
	}
	/*
	 * 	3. 게시글을 삭제
	 *		-게시글의 고유번호를 이용하여 게시글을 삭제한다
	 */
	public void deletePost(Post post) throws Exception{
		postDao.deletePost(post.getNo());
	}
	/*
	 * 
	 */
	public ArrayList<Post> selectALL() throws Exception{
		
		return postDao.selectAll();
	}

	
	/*
	 *  4. 조회수 증가
	 */
	public void hits(Post post) throws Exception{
		postDao.selectByNo(post.getNo());
		postDao.hits(post);
	}
	/*
	 *  5. 좋아요
	 */
	public void likes(Post post) throws Exception{
		postDao.selectByNo(post.getNo());
		postDao.likes(post);
	}
	
	/*
	 *  6. 게시판 고유번호 기반으로 게시글들 반환
	 */
	public ArrayList<Post> selectByBoardNo(int boardNo) throws Exception{
		ArrayList<Post> postList= postDao.selectByBoardNo(boardNo);
		Collections.sort(postList);
		return postList;
	}
	
	/*
	 * 7. 게시판 고유번호로 게시글 삭제
	 */
	public boolean deleteByNo(int no) throws Exception{
		postDao.removeByNo(no);
		return true;
	}
	
	
	/********************comments*******************/
	
	/********************board***********************/
	
}
