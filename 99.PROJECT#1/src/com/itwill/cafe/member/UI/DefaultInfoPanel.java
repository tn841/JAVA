package com.itwill.cafe.member.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.itwill.cafe.main.FirstPageFrame;

public class DefaultInfoPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DefaultInfoPanel(FirstPageFrame fpFrame) {
		setBackground(new Color(250, 128, 114));
		setLayout(null);
		
		JButton LoginBtn = new JButton("\uB85C\uADF8\uC778");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginDialog loginD = new LoginDialog(fpFrame);
					loginD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					loginD.setModal(true);
					loginD.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		LoginBtn.setBounds(32, 83, 89, 27);
		add(LoginBtn);

	}
	
	
}
