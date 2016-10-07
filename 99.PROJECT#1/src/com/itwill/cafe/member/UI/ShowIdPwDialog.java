package com.itwill.cafe.member.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.member.MemberVO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowIdPwDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IdTF;
	private JTextField PwTF;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			ShowIdPwDialog dialog = new ShowIdPwDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 * @throws Exception 
	 * @throws  
	 */
	public ShowIdPwDialog(FindIdPwDialog findIdPwDialog) throws Exception {
		setResizable(false);
		setTitle("ID/PW\uD655\uC778");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(63, 55, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("PW");
			lblNewLabel_1.setBounds(63, 92, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			IdTF = new JTextField();
			IdTF.setBounds(132, 52, 116, 21);
			contentPanel.add(IdTF);
			IdTF.setColumns(10);
		}
		{
			PwTF = new JTextField();
			PwTF.setBounds(132, 89, 116, 21);
			contentPanel.add(PwTF);
			PwTF.setColumns(10);
		}
		IdTF.setText(findIdPwDialog.getMemberVO().getId());
		PwTF.setText(findIdPwDialog.getMemberVO().getPassword());
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
