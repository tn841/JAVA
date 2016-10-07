package com.itwill.cafe.post.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.board.UI.BoardDefaultViewPanel;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostDao;
import com.itwill.cafe.post.PostService;
import com.itwill.cafe.post.model.PostTableModel;
import javax.swing.ScrollPaneConstants;

public class FirstPagePostItemPanel extends JPanel {
	private PostDao postDao;
	private PostService postService;
	
	private JTable table;
	private JTextField textField;
   public  int lineCount;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public FirstPagePostItemPanel(FirstPageFrame fpFrame, int boardNo) throws Exception {
		postDao = new PostDao();	//Dao 초기화
		postService = new PostService();
		
		ArrayList<Post> postList = postDao.selectAll();	//게시판이름으로 게시판에 속한 post만 가지고 온다.
		
		/******************자동생성 코드*******************/
		//setLayout(new BorderLayout(0, 0));
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		*/
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 153));
		//panel.setPreferredSize(new Dimension(520, 100));
		//scrollPane.setViewportView(panel);
		/******************자동생성 코드*******************/
		
		
		
		
		/**********테이블 처리****************/
		//모델 객체 생성
		ArrayList<String> colNameList = new ArrayList<String>();		
		colNameList.add("번호");
		colNameList.add("제목");
		colNameList.add("작성자");
		colNameList.add("날짜");
		
		PostTableModel postTableM = new PostTableModel(colNameList, boardNo);
		DefaultTableModel dtModel = postTableM.getDtModel();
		lineCount = dtModel.getRowCount();
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane();
		//scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane_1);
		table = new JTable();
		//table.setPreferredSize(new Dimension(400, 300));
		scrollPane_1.setViewportView(table);
		scrollPane_1.setPreferredSize(new Dimension(450, 100));
		table.setModel(dtModel);
		table.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {		}
			public void mousePressed(MouseEvent e) {		}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int postNo = (int)table.getValueAt(table.getSelectedRow(), 0);
				int getboardNo = boardNo;
				System.out.println("게시글 고유번호 : "+postNo+" 게시판 고유번호 : "+getboardNo);
				
				
				
				try {
					Post findPost = postService.readPost(postNo);
					PostReadPanel prPanel = new PostReadPanel(fpFrame,postNo,boardNo );
					
					if(fpFrame.getBoardDefaultViewPanel() == null){
						fpFrame.getBoardList().init(getboardNo);
					}
				
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
		/**********테이블 처리****************/

		
		textField = new JTextField();
		textField.setText("00\uAC8C\uC2DC\uD310");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		add(panel);
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
