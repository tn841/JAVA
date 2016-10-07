package com.itwill.cafe.post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.itwill.cafe.main.FirstPageService;

public class PostDao {
	
	public PostDao() throws Exception {
		init();
	}
	/*************copy & paste***************/
	private File postFile;
	/*
	 * 초기화메쏘드
	 */
	private void init() throws Exception{
		postFile = new File("post.dat");
		if(!postFile.exists()){
			postFile.createNewFile();
			ObjectOutputStream oos = 
					new ObjectOutputStream(
							new FileOutputStream(postFile));
			oos.writeObject(new ArrayList<Post>());
			oos.close();
		}
	}
	/*
	 * 파일읽기(연걸)
	 */
	private ArrayList<Post> readData() throws Exception{
		ObjectInputStream ois =
				new ObjectInputStream(
						new FileInputStream(postFile));
		@SuppressWarnings("unchecked")
		ArrayList<Post> postList = (ArrayList<Post>)ois.readObject();
		
		return postList;
	} 
	/*
	 * 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<Post> postList) throws Exception{
		ObjectOutputStream oos= 
				new ObjectOutputStream(
						new FileOutputStream(postFile));
		oos.writeObject(postList);
		oos.flush();
		oos.close();
	}
	
	/**************************************/
	/*
	 * 게시글 추가
	 */
	public void insertPost(Post post) throws Exception{
		ArrayList<Post> postList = this.readData();
		postList.add(post);
		if(FirstPageService.activeMember == null){
			post.setPostWriter("익명");
		}else{
			post.setPostWriter(FirstPageService.activeMember.getId());
		}
		this.saveData(postList);
	}
	/*
	 * 게시글 삭제
	 */
	public void deletePost(int no) throws Exception{
		ArrayList<Post> postList=this.readData();
		for(Post post : postList){
			
				if(post.getNo()==no){
					postList.remove(post);
					break;
				}
			
		}
		this.saveData(postList);
	}
	
	
	public boolean removeByNo(int no) throws Exception {
        ArrayList<Post> postList = this.readData();
        Iterator<Post> iter = postList.iterator();
        while(iter.hasNext()){
            if(iter.next().getBoardNo()==no){
                iter.remove();
            }
        }

        this.saveData(postList);
        return true;
    }

	
	/*
	 * 게시글 번호로 찾기
	 */
	public Post selectByNo(int no) throws Exception{
		Post findPost=null;
		ArrayList<Post> postList=this.readData();
		for(Post post : postList){
			if(post.getNo()==no){
				findPost=post;
				break;
			}
		}
		return findPost;
	}
	/*
	 * 게시글 제목으로 찾기
	 */
	public ArrayList<Post> selectByTitle(String title) throws Exception{
		Post findPost=null;
		ArrayList<Post> findPostList=this.readData();
		ArrayList<Post> postList=this.readData();
		for (Post post : postList) {
			if(post.getPostTitle().equalsIgnoreCase(title)){
				findPost=post;
			}
		}
		findPostList.add(findPost);
		return findPostList;
	}
	/*
	 * 게시글 전체 찾기
	 */
	public ArrayList<Post> selectAll() throws Exception{
		ArrayList<Post> postList=this.readData();
		
		for (Post post : postList) {
			System.out.println(post);
		}
		return postList;
	}

	
	
	/*
	 * 업데이트
	 */
	public void updatePost(Post updatePost) throws Exception{
		ArrayList<Post> postList=this.readData();
		for(Post post : postList){
			if(post.getNo()==updatePost.getNo()){
				
				post.setPostTitle(updatePost.getPostTitle());
				post.setPostContent(updatePost.getPostContent());
				post.posttingDate();
				
			}
		}
		this.saveData(postList);
		
	}
	/*
	 * 고유번호생성
	 */
	public void numberG(Post post) throws Exception{
		ArrayList<Post> postList=this.readData();
		if(postList.size() != 0){
			post.setNo(postList.get(postList.size()-1).getNo()+1);
			
		}
	}
	
	/*
	 * 특정 게시판에 속한 게시글들만 반환
	 */
	public ArrayList<Post> selectByBoardNo(int boardNo) throws Exception{
		ArrayList<Post> postList=this.readData();
		
		ArrayList<Post> resultList = new ArrayList<Post>();
		
		for (Post post : postList) {
			if(post.getBoardNo() == boardNo){
				resultList.add(post);
			}
		}
		return resultList;
	}
	
	/*
	 * 좋아요 
	 */
	public void likes(Post findPost) throws Exception{
		ArrayList<Post> postList=this.readData();
		for (Post post : postList) {
			if(post.getNo()==findPost.getNo()){
					
				findPost.setPostLike(findPost.getPostLike()+1);
				post.setPostLike(post.getPostLike()+1);
			}
		}
		saveData(postList);
	}
	/*
	 * 조회수
	 */
	public void hits(Post findPost) throws Exception{
		ArrayList<Post> postList=this.readData();
		for (Post post : postList) {
			if(post.getNo()==findPost.getNo()){
				
				post.setPostHits(post.getPostHits()+1);
			}
		}
		saveData(postList);
	}
 
}
