package com.itwill.cafe.post.UI;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import com.itwill.cafe.board.UI.BoardDefaultViewPanel;
import com.itwill.cafe.main.FirstPageFrame;

public class PostWirteDialog extends JDialog {

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			PostWirteDialog dialog = new PostWirteDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public PostWirteDialog(FirstPageFrame fpFrame, int boardNo) {
		setResizable(false);
		setTitle("\uAC8C\uC2DC\uAE00 \uC791\uC131");
		setBounds(100, 100, 397, 445);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		PostWritePanel postWritePanel = new PostWritePanel(fpFrame, boardNo, this);
		getContentPane().add(postWritePanel, BorderLayout.CENTER);
		{
			System.out.println(boardNo);
		}
	}
}
