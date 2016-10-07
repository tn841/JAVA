package com.itwill.cafe.post.UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.itwill.cafe.board.UI.BoardDefaultViewPanel;
import com.itwill.cafe.comment.Comment;
import com.itwill.cafe.comment.CommentService;
import com.itwill.cafe.comment.UI.CommentPanel;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostService;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class PostReadPanel extends JPanel {
	PostService postService;
	private JTextArea titleTA;
	private JTextArea contentTA;
	private JPanel buttonP;
	 JButton deleteB;
	 JButton modifyB;
	private JButton listB;
	private JPanel postP;
	private JLabel dateL;
	private JTextArea dateTA;
	private JLabel likesL;
	private JTextArea likesTA;
	private JLabel hitsL;
	private JTextArea hitsTA;
	private JButton likesB;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PostReadPanel(FirstPageFrame fpFrame, int no, int boardNo) throws Exception {
		
		this.setBounds(5,5,546,479);
		/*********************게시글 읽기****************************/
		try {
			postService =new PostService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Post findPost = postService.readPost(no);
		/*************************************************************/
		setLayout(null);
		
		postP = new JPanel();
		postP.setBackground(new Color(153, 153, 255));
		add(postP);
		postP.setBounds(0,0,544,300);
		postP.setLayout(null);
		
		JPanel titleP = new JPanel();
		titleP.setBackground(new Color(255, 204, 255));
		titleP.setBounds(12, 10, 520, 35);
		postP.add(titleP);
		titleP.setLayout(null);
		/*
		 * 제목
		 */
		JLabel postTitleP = new JLabel("\uC81C \uBAA9");
		postTitleP.setFont(new Font("굴림", Font.PLAIN, 12));
		postTitleP.setBounds(12, 8, 60, 29);
		titleP.add(postTitleP);
		titleTA = new JTextArea();
		titleTA.setBackground(new Color(255, 204, 255));
		titleTA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleTA.setBounds(57, 10, 451, 19);
		titleTA.setText(findPost.getPostTitle());//제목을 가져옴
		titleP.add(titleTA);
		
		JPanel stateP = new JPanel();
		stateP.setBackground(new Color(255, 204, 255));
		stateP.setBounds(12, 46, 520, 29);
		postP.add(stateP);
		stateP.setLayout(null);
		
		/*
		 * 작성자
		 */
		JLabel writerL = new JLabel("\uC791\uC131\uC790");
		writerL.setFont(new Font("굴림", Font.PLAIN, 12));
		writerL.setBounds(12, 9, 44, 15);
		stateP.add(writerL);
		
		JTextArea writerTA = new JTextArea();
		writerTA.setBackground(new Color(255, 204, 255));
		writerTA.setBounds(62, 9, 91, 19);
		writerTA.setText(findPost.getPostWriter());
		stateP.add(writerTA);
		
		/*
		 * 좋아요
		 */
		likesL = new JLabel("");
		likesL.setBackground(new Color(255, 204, 255));
		likesL.setIcon(new ImageIcon("C:\\JAVAIOT\\workspace_se\\99.PROJECT\\L.PNG"));
		likesL.setBounds(294, 6, 26, 19);
		stateP.add(likesL);
		likesTA = new JTextArea();
		likesTA.setBackground(new Color(255, 204, 255));
		likesTA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		likesTA.setBounds(322, 6, 51, 19);
		likesTA.setText(findPost.getPostLike()+"");
		stateP.add(likesTA);
		
		/*
		 * 조회수
		 */
		hitsL = new JLabel("\uC870\uD68C\uC218");
		hitsL.setBounds(401, 10, 44, 15);
		stateP.add(hitsL);
		
		hitsTA = new JTextArea();
		hitsTA.setBackground(new Color(255, 204, 255));
		hitsTA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		hitsTA.setBounds(457, 6, 51, 19);
		hitsTA.setText(findPost.getPostHits()+"");
		stateP.add(hitsTA);
		
		/*
		 * 내용
		 */
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 79, 520, 178);
		postP.add(scrollPane);
		contentTA = new JTextArea();
		scrollPane.setViewportView(contentTA);
		contentTA.setBackground(new Color(255, 204, 255));
		contentTA.setFont(new Font("나눔고딕코딩", Font.PLAIN, 13));
		contentTA.setText(findPost.getPostContent());
		buttonP = new JPanel();
		buttonP.setBackground(new Color(153, 153, 255));
		buttonP.setBounds(349, 267, 183, 23);
		postP.add(buttonP);
		buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.X_AXIS));
		
		deleteB = new JButton("\uC0AD\uC81C");
		deleteB.setBackground(new Color(255, 204, 255));
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 게시글 삭제
				 */
				try {
					postService.deletePost(findPost);
					System.out.println("삭제완료");
					
					//코멘트 같이 삭제
					CommentService cServ = new CommentService();
					ArrayList<Comment> cList =  cServ.findCommentsByPostNo(no);
					for (Comment comment : cList) {
						cServ.delete(comment);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					BoardDefaultViewPanel.postReload(boardNo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "전환패널");;
			}
		});
		deleteB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		buttonP.add(deleteB);
		
		modifyB = new JButton("\uC218\uC815");
		modifyB.setBackground(new Color(255, 204, 255));
		modifyB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 게시글 수정
				 */
				findPost.setPostTitle(titleTA.getText());
				findPost.setPostContent(contentTA.getText());
				
				try {
					postService.modifyPost(findPost);
					System.out.println("수정완료");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					BoardDefaultViewPanel.postReload(boardNo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "전환패널");;
			}
		});
		buttonP.add(modifyB);
		
		listB = new JButton("\uBAA9\uB85D");
		listB.setBackground(new Color(255, 204, 255));
		listB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 목록으로
				 */
				try {
					if(boardNo == 0){
						System.out.println("홈에서");
					}else{
						BoardDefaultViewPanel.postReload(boardNo);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "전환패널");;
			}
		});
		listB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		buttonP.add(listB);
		
		dateL = new JLabel("\uC791\uC131\uB0A0\uC9DC");
		dateL.setBounds(12, 267, 57, 23);
		postP.add(dateL);
		
		dateTA = new JTextArea();
		dateTA.setBackground(new Color(255, 204, 255));
		dateTA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		dateTA.setBounds(75, 267, 138, 24);
		dateTA.setText(findPost.getPosttingDate());
		postP.add(dateTA);
		
		/*
		 * 좋아요 버튼
		 */
		likesB = new JButton("\u4E43");
		likesB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
						
					postService.likes(findPost);
					likesTA.setText(findPost.getPostLike()+"");
					System.out.println("좋아요:"+findPost.getPostLike());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		likesB.setBackground(new Color(219, 112, 147));
		likesB.setBounds(246, 267, 51, 23);
		postP.add(likesB);
		
		CommentPanel commentPanel = new CommentPanel(no);
		add(commentPanel.scrollPane_commentPanel);
		
		
	}
}
