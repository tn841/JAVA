package com.itwill.cafe.post;

import java.util.ArrayList;
import java.util.Collections;

import com.itwill.cafe.board.BoardDao;
import com.itwill.cafe.comment.CommentDao;
import com.itwill.cafe.member.MemberDao;

/*
 * �Խñ��� �����ϴ� Ŭ����
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
	 * 	1. �Խñ��� �ۼ�(����)
	 *   	- UI --> ����Ÿ�� �޴´�(Post title,Post content)
	 *  	- Post title,Post content --> ���� ����Ÿ�� �̿��� PostDao���� ������Ʈ�Ѵ�
	 *   	- MemberDao --> �ۼ��ڵ���Ÿ�� �޾ƿ´�
	 *   	- Post --> ������ȣ�ڵ����Ѵ�
	 *   	- PostDao --> �Խñ��� �߰��Ѵ�.
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
		
		
		System.out.println("�Խ��� ��ȣ ��� �Խñ� ����"+post.getNo());
		
		//postDao.insertPost(temp);
	}
	/*
	 * ##.�Խñ� �б�
	 * 		
	 * 
	 */
	public Post readPost(int postNo) throws Exception{
			return postDao.selectByNo(postNo);
	}
	/*
	 * 	2. �Խñ��� ����
	 *  	-�Խñ��� ������ȣ�� �̿��Ͽ� �Խñ��� �����Ѵ� 
	 */
	public void modifyPost(Post post) throws Exception{
		postDao.selectByNo(post.getNo());
		postDao.updatePost(post);
	}
	/*
	 * 	3. �Խñ��� ����
	 *		-�Խñ��� ������ȣ�� �̿��Ͽ� �Խñ��� �����Ѵ�
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
	 *  4. ��ȸ�� ����
	 */
	public void hits(Post post) throws Exception{
		postDao.selectByNo(post.getNo());
		postDao.hits(post);
	}
	/*
	 *  5. ���ƿ�
	 */
	public void likes(Post post) throws Exception{
		postDao.selectByNo(post.getNo());
		postDao.likes(post);
	}
	
	/*
	 *  6. �Խ��� ������ȣ ������� �Խñ۵� ��ȯ
	 */
	public ArrayList<Post> selectByBoardNo(int boardNo) throws Exception{
		ArrayList<Post> postList= postDao.selectByBoardNo(boardNo);
		Collections.sort(postList);
		return postList;
	}
	
	/*
	 * 7. �Խ��� ������ȣ�� �Խñ� ����
	 */
	public boolean deleteByNo(int no) throws Exception{
		postDao.removeByNo(no);
		return true;
	}
	
	
	/********************comments*******************/
	
	/********************board***********************/
	
}
