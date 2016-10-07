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
		 * Account List���
		 */
		postList=postService.selectByBoardNo(boardNo);
		System.out.println(postList);
		/*
		 * Data(Vector) ����(ArrayList<Account>-->Vector)
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
		columnNames.add("��ȣ");
		columnNames.add("����");
		columnNames.add("�ۼ���");
		columnNames.add("�ۼ���¥");
		
		
		/*
		 * table Model ����
		 */
		tableModel = new DefaultTableModel(data, columnNames);
		table.setModel(tableModel);
		/*
		 * event source JTable
		 */
		//event handler ����
		//event handler ���̱�
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
					 * ��ȸ�� 
					 */
					postService.hits(findPost);
					
					/*
					 * �Խñ� ���θ� ����/����
					 */
					boolean istrue = false;
					if(findPost.getPostWriter() != null && FirstPageService.activeMember != null ){
						if(findPost.getPostWriter().equals(FirstPageService.activeMember.getId())){
							istrue = true;
								
						}else{
								istrue = false;
						}
					
					}else if(findPost.getPostWriter() != null){
						if(findPost.getPostWriter().equals("�͸�")){
							istrue = true;
						}else{
							istrue=false;
						}
					}
					prPanel.modifyB.setVisible(istrue);
					prPanel.deleteB.setVisible(istrue);
					

					
					/*
					 * ȭ����ȯ
					 */
					fpFrame.getPostParentCard().add(prPanel,"�Խñ�");
					fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "�Խñ�");
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
