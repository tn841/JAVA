package com.itwill.cafe.post.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.message.MessageVO;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostService;

public class PostTableModel{
	private PostService postService;
	private DefaultTableModel dtModel;
	
	public PostTableModel(ArrayList<String> colName, int boardNo) throws Exception{
		int row=0;
		int col=colName.size();
		System.out.println("열 갯수:"+col);
		postService = new PostService();
		
		
		ArrayList<Post> postList = postService.selectByBoardNo(boardNo);
		
		for (Post post : postList) {
			row++;
			//System.out.print(post.getPostTitle()+" ");
		}
	
		
		Object[][] data = new Object[row][col];
		row=0;
		
		for (Post post : postList) {
			data[row][0] = post.getNo();
			data[row][1] = post.getPostTitle();
			data[row][2] = post.getPostWriter();
			data[row][3] = post.getPosttingDate();
			row++;
		}//data셋팅
			
		
		
		row=0;
		for(String str : colName){
			row++;
		}
		Object[] colNameArr = new Object[row];
		row=0;
		for (String str : colName) {
			colNameArr[row] = str;
			row++;
		}//colName셋팅 완료
		
		dtModel = new DefaultTableModel(data, colNameArr);
//		for (Object object : colNameArr) {
//			System.out.print(object+" ");
//		}
	}

	public DefaultTableModel getDtModel() {
		return dtModel;
	}

	public void setDtModel(DefaultTableModel dtModel) {
		this.dtModel = dtModel;
	}
	
}
