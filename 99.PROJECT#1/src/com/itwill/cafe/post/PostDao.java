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
	 * �ʱ�ȭ�޽��
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
	 * �����б�(����)
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
	 * ���Ͼ���(��������)
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
	 * �Խñ� �߰�
	 */
	public void insertPost(Post post) throws Exception{
		ArrayList<Post> postList = this.readData();
		postList.add(post);
		if(FirstPageService.activeMember == null){
			post.setPostWriter("�͸�");
		}else{
			post.setPostWriter(FirstPageService.activeMember.getId());
		}
		this.saveData(postList);
	}
	/*
	 * �Խñ� ����
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
	 * �Խñ� ��ȣ�� ã��
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
	 * �Խñ� �������� ã��
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
	 * �Խñ� ��ü ã��
	 */
	public ArrayList<Post> selectAll() throws Exception{
		ArrayList<Post> postList=this.readData();
		
		for (Post post : postList) {
			System.out.println(post);
		}
		return postList;
	}

	
	
	/*
	 * ������Ʈ
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
	 * ������ȣ����
	 */
	public void numberG(Post post) throws Exception{
		ArrayList<Post> postList=this.readData();
		if(postList.size() != 0){
			post.setNo(postList.get(postList.size()-1).getNo()+1);
			
		}
	}
	
	/*
	 * Ư�� �Խ��ǿ� ���� �Խñ۵鸸 ��ȯ
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
	 * ���ƿ� 
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
	 * ��ȸ��
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
