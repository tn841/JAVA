package com.itwill.cafe.post.UI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.board.UI.BoardDefaultViewPanel;
import com.itwill.cafe.comment.Comment;
import com.itwill.cafe.comment.CommentService;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostService;

public class PostListtingPanel extends JPanel {
	public static JTable table;
	private ArrayList<Post> postList;
	PostService postService ;
	private DefaultTableModel tableModel;
	private Vector<String> columnNames;
	
	public void selectPostList(int boardNo) throws Exception{
		postService = new PostService();
		postList = new ArrayList<Post>();
		postList.clear();
		/*
		 * Account List얻기
		 */
		postList=postService.selectByBoardNo(boardNo);
		System.out.println(postList);
		/*
		 * Data(Vector) 구성(ArrayList<Account>-->Vector)
		 */
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		//ArrayList<ArrayList<String>> data1=new ArrayList<String>();
		for (Post post : postList) {
			Vector rowVector=new Vector<String>();
			rowVector.add(post.getNo());
			rowVector.add(post.getPostTitle());
			rowVector.add(post.getPostWriter());
			rowVector.add(post.getPosttingDate()+"");
			data.add(rowVector);
		}
		columnNames=new Vector<String>();
		columnNames.add("번호");
		columnNames.add("제목");
		columnNames.add("작성자");
		columnNames.add("작성날짜");
		
		
		/*
		 * table Model 생성
		 */
		tableModel = new DefaultTableModel(data, columnNames);
		table.setModel(tableModel);
		/*
		 * event source JTable
		 */
		//event handler 제거
		//event handler 붙이기
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
	}
	
	

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PostListtingPanel(FirstPageFrame fpFrame, int boardNo) throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		this.selectPostList(boardNo);
		
		table.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {			}
			public void mousePressed(MouseEvent e) {			}	
			public void mouseExited(MouseEvent e) {			}
			public void mouseEntered(MouseEvent e) {			}
			public void mouseClicked(MouseEvent e) {	
				//System.out.println(table.getValueAt(table.getSelectedRow(), 0));
				
				int no = (int)table.getValueAt(table.getSelectedRow(), 0);
				try {
					Post findPost = postService.readPost(no);
					PostReadPanel prPanel = new PostReadPanel(fpFrame,no,boardNo );
					
					
					/*
					 * 조회수 
					 */
					postService.hits(findPost);
					
					/*
					 * 게시글 주인만 수정/삭제
					 */
					boolean istrue = false;
					if(findPost.getPostWriter() != null && FirstPageService.activeMember != null ){
						if(findPost.getPostWriter().equals(FirstPageService.activeMember.getId())){
							istrue = true;
								
						}else{
								istrue = false;
						}
					
					}else if(findPost.getPostWriter() != null){
						if(findPost.getPostWriter().equals("익명")){
							istrue = true;
						}else{
							istrue=false;
						}
					}
					prPanel.modifyB.setVisible(istrue);
					prPanel.deleteB.setVisible(istrue);
					

					
					/*
					 * 화면전환
					 */
					fpFrame.getPostParentCard().add(prPanel,"게시글");
					fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "게시글");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		//tableModel = new DefaultTableModel(columnNames,5);
		
		//table.setModel(tableModel);
		scrollPane.setViewportView(table);

	}

}
