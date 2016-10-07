package com.itwill.cafe.post.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.itwill.cafe.board.UI.BoardDefaultViewPanel;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.post.Post;
import com.itwill.cafe.post.PostService;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;

public class PostWritePanel extends JPanel {
	PostService postService;
	private JTextField postTitleTF;
	private JTextPane postContentTA;

	/**
	 * Create the panel.
	 */
	public PostWritePanel(FirstPageFrame fpFrame, int boardNo, JDialog jDia) {
		setBackground(new Color(153, 153, 255));
		setLayout(null);
		
		JPanel postTitleP = new JPanel();
		postTitleP.setBackground(new Color(255, 204, 255));
		postTitleP.setBounds(12, 10, 355, 33);
		add(postTitleP);
		postTitleP.setLayout(null);
		
		JLabel postTiltleL = new JLabel("\uC81C\uBAA9");
		postTiltleL.setFont(new Font("굴림", Font.PLAIN, 12));
		postTiltleL.setBounds(7, 10, 35, 15);
		postTitleP.add(postTiltleL);
		
		postTitleTF = new JTextField();
		postTitleTF.setBackground(new Color(255, 204, 255));
		postTitleTF.setBounds(43, 7, 300, 21);
		postTitleP.add(postTitleTF);
		postTitleTF.setColumns(10);
		
		/***************************************************************/
		JButton writeB = new JButton("\uD655\uC778");
		writeB.setBackground(new Color(255, 204, 255));
		writeB.setBounds(281, 378, 86, 23);
		writeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String postTitle = postTitleTF.getText();
				String postContent=postContentTA.getText();
				System.out.println("게시글쓰기 잘되고 있나??");
				
				//boolean isWrite = false;
				try {
					postService.writePost(new Post(postTitle, postContent), boardNo);
					System.out.println("게시판 번호 : "+boardNo);
					BoardDefaultViewPanel.postReload(boardNo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jDia.dispose();
			}
		});
		add(writeB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 53, 355, 318);
		add(scrollPane);
		
		postContentTA = new JTextPane();
		postContentTA.setBackground(new Color(255, 204, 255));
		scrollPane.setViewportView(postContentTA);
		
		try {
			postService =new PostService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
