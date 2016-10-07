package com.itwill.cafe.board.UI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class BoardShowPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public BoardShowPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setText("00 \uAC8C\uC2DC\uD310");
		textField.setBounds(25, 12, 116, 24);
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 102));
		panel.setBounds(25, 71, 420, 249);
		add(panel);

	}

}
