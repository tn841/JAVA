package com.itwill.cafe.board.UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.itwill.cafe.board.BoardService;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.post.UI.PostListtingPanel;
import com.itwill.cafe.post.UI.PostWirteDialog;
import com.itwill.cafe.post.model.PostSearchModel;

public class BoardDefaultViewPanel extends JPanel {
	private BoardService boardService;
	private int boardNo;
	private static PostListtingPanel postListtingPanel;
	private static JScrollPane scrollPane;
	private static FirstPageFrame firstpFrame;
	private JTextField sTF;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public BoardDefaultViewPanel(FirstPageFrame fpFrame, int boardNo) throws Exception {
		boardService = new BoardService();
		firstpFrame=fpFrame;
		
		
		setLayout(null);
		
		JLabel lblBoardtitle = new JLabel(boardService.selectByNo(boardNo).getBoardTitle());
		lblBoardtitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lblBoardtitle.setBounds(14, 44, 162, 35);
		add(lblBoardtitle);
		
		JButton btnNewButton = new JButton("\uAE00\uC4F0\uAE30");
		/***********글쓰기****************/
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostWirteDialog pwDialog = new PostWirteDialog(fpFrame, boardNo);
				pwDialog.setModal(true);
				pwDialog.setVisible(true);
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 91, 523, 244);
		add(scrollPane);
		
		postListtingPanel = new PostListtingPanel(fpFrame, boardNo);
		scrollPane.setViewportView(postListtingPanel);
		btnNewButton.setBounds(440, 354, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("HOME");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "기본패널");
				try {
					fpFrame.getFirstPagePostPanel().reload();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(14, 5, 75, 27);
		add(btnNewButton_4);
		
		
		/************************************/
		sTF = new JTextField();
		sTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/****/
				ArrayList<String> colNameList = new ArrayList<String>();
				colNameList.add("번호");
				colNameList.add("제목");
				colNameList.add("작성자");
				colNameList.add("작성날짜");
				try {
					PostSearchModel postSearchM = new PostSearchModel(colNameList, boardNo, sTF.getText() + "");
					PostListtingPanel.table.setModel(postSearchM.getDtModel());
					PostListtingPanel.table.getColumnModel().getColumn(0).setPreferredWidth(5);
					PostListtingPanel.table.getColumnModel().getColumn(1).setPreferredWidth(200);
					PostListtingPanel.table.getColumnModel().getColumn(2).setPreferredWidth(10);
					PostListtingPanel.table.getColumnModel().getColumn(3).setPreferredWidth(80);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		sTF.setBounds(350, 53, 116, 21);
		add(sTF);
		sTF.setColumns(10);

		btnNewButton_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/****/
				ArrayList<String> colNameList = new ArrayList<String>();
				colNameList.add("번호");
				colNameList.add("제목");
				colNameList.add("내용");
				colNameList.add("작성날짜");
				try {
					PostSearchModel postSearchM = new PostSearchModel(colNameList, boardNo, sTF.getText() + "");
					PostListtingPanel.table.setModel(postSearchM.getDtModel());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(470, 52, 62, 23);
		add(btnNewButton_1);
		/************************************/
	}
	
	public static void postReload(int boardNo) throws Exception{
		System.out.println(boardNo+"보드 번호");
		postListtingPanel = new PostListtingPanel(firstpFrame,boardNo);
		postListtingPanel.selectPostList(boardNo);
		
		/*******/
		
		/*******/
		scrollPane.setViewportView(postListtingPanel);
	}
	
}
