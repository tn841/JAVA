package com.itwill.cafe.post;

import java.util.ArrayList;

public class PostDaoTest {

	public static void main(String[] args) throws Exception{
		PostDao postDao=new PostDao();
		System.out.println("----insertPost----");
		/*
		postDao.insertPost(new Post(1, "����δ��� ��","�����"));
		postDao.insertPost(new Post(2, "���ػ���� ��","���ػ�"));
		postDao.insertPost(new Post(3, "�迵������ ��","�迵��"));
		*/
	    System.out.println("------selectByNo-------");
	    Post findPost=postDao.selectByNo(2);
	    System.out.println(findPost);
	    System.out.println("-------selectAll-------");
	    ArrayList<Post> postList=postDao.selectAll();
	    for(Post post : postList){
	    	System.out.println(post);
	    }
	    
	    System.out.println("-------delete---------");
	    postDao.deletePost(1);
	    postList=postDao.selectAll();
	    for(Post post : postList){
	    	System.out.println(post);
	    }
	    System.out.println("-----update--------");
	    //Post updatePost=new Post(3, "�迵������ ���� ��", "�迵��");
	    //postDao.updatePost(new Post(3, "�迵������ ���� ��", "�迵��"));
		System.out.println(postDao.selectByNo(3));
		
		
		
		
	}
}
