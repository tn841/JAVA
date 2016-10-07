package com.itwill.cafe.post.model;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostService;

public class PostSearchModel {
	private PostService postService;
	private DefaultTableModel dtModel;

	public PostSearchModel(ArrayList<String> colName, int boardNo, String title) throws Exception {
		int row = 0;
		int col = colName.size();
		System.out.println("열 갯수:" + col);
		postService = new PostService();

		ArrayList<Post> postList = postService.selectByBoardNo(boardNo);
		
		/*Iterator<Post> iter = postList.iterator();
		while (iter.hasNext()) {
			if (!iter.next().getPostTitle().equalsIgnoreCase(title)) {
				iter.remove();
			}
		}*/
		/************************/
		Post[] titleData = new Post[postList.size()];
		String strP = ".*" + title + ".*";
		
		for (int i = 0; i < titleData.length; i++) {
			titleData[i] = new Post();
			titleData[i] = postList.get(i);
		}
		
		Pattern p = Pattern.compile(strP);
		ArrayList<Post> postArray=new ArrayList<Post>();
		for (int i = 0; i < titleData.length; i++) {
			Matcher m = p.matcher(titleData[i].getPostTitle());
			if (m.matches()) {
				System.out.print(titleData[i] + ",");
				System.out.println();
				postArray.add(titleData[i]);
				
			}
		}
		
		for (Post post : postArray) {
			row++;
			// System.out.print(post.getPostTitle()+" ");
		}

		Object[][] data = new Object[row][col];
		row = 0;

		for (Post post : postArray) {
			data[row][0] = post.getNo();
			data[row][1] = post.getPostTitle();
			data[row][2] = post.getPostWriter();
			data[row][3] = post.getPosttingDate();
			row++;
		} // data셋팅

		row = 0;
		for (String str : colName) {
			row++;
		}
		Object[] colNameArr = new Object[row];
		row = 0;
		for (String str : colName) {
			colNameArr[row] = str;
			row++;
		} // colName셋팅 완료

		dtModel = new DefaultTableModel(data, colNameArr);
		// for (Object object : colNameArr) {
		// System.out.print(object+" ");
		// }
	}

	public DefaultTableModel getDtModel() {
		return dtModel;
	}

	public void setDtModel(DefaultTableModel dtModel) {
		this.dtModel = dtModel;
	}

}
