package com.itwill.cafe.post;

import java.util.ArrayList;

public class PostServiceMain {
	
	public static void main(String[] args) throws Exception {
		
		PostService postService = new PostService();
		PostDao postDao=new PostDao();
		/*
		postService.writePost(new Post("1111","1111"));
		postService.writePost(new Post("222","222"));
		postService.writePost(new Post("3333","3333"));
		postService.writePost(new Post("444","444"));
		*/
		ArrayList<Post> postList= postService.selectALL();
		
		postService.deletePost(postList.get(1));
		
		postService.selectALL();
		
	}

}
