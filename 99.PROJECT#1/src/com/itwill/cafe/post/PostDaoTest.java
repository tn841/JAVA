package com.itwill.cafe.post;

import java.util.ArrayList;

public class PostDaoTest {

	public static void main(String[] args) throws Exception{
		PostDao postDao=new PostDao();
		System.out.println("----insertPost----");
		/*
		postDao.insertPost(new Post(1, "±è¼ö¹Î´ÔÀÇ ±Û","±è¼ö¹Î"));
		postDao.insertPost(new Post(2, "À¯ÁØ»ó´ÔÀÇ ±Û","À¯ÁØ»ó"));
		postDao.insertPost(new Post(3, "±è¿µ¹ü´ÔÀÇ ±Û","±è¿µ¹ü"));
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
	    //Post updatePost=new Post(3, "±è¿µ¹ü´ÔÀÇ ¼öÁ¤ ±Û", "±è¿µ¹ü");
	    //postDao.updatePost(new Post(3, "±è¿µ¹ü´ÔÀÇ ¼öÁ¤ ±Û", "±è¿µ¹ü"));
		System.out.println(postDao.selectByNo(3));
		
		
		
		
	}
}
