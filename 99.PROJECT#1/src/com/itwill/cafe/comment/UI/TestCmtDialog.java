package com.itwill.cafe.comment.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestCmtDialog extends JFrame {

	private JPanel contentPane;

	int postNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCmtDialog frame = new TestCmtDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCmtDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("post 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog jDiaLog = new JDialog();
				jDiaLog.setBounds(100, 100, 900, 800);
				CommentPanel commentPanel;
				try {
					commentPanel = new CommentPanel(1);
					jDiaLog.add(commentPanel.scrollPane_commentPanel);
					jDiaLog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		btnNewButton.setBounds(44, 187, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("post 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog jDiaLog = new JDialog();
				jDiaLog.setBounds(100, 100, 544, 177);
				CommentPanel commentPanel;
				try {
					commentPanel = new CommentPanel(postNo);
					jDiaLog.add(commentPanel.scrollPane_commentPanel);
					commentPanel.reGenerate(postNo);				//postNo need
					jDiaLog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		btnNewButton_1.setBounds(153, 187, 97, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("post 3");
		btnNewButton_2.setBounds(270, 187, 97, 23);
		panel.add(btnNewButton_2);
	}
}
