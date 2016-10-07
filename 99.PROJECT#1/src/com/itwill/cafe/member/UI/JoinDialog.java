package com.itwill.cafe.member.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.member.MemberVO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JTextField pwTF;
	private JTextField pwCheckTF;
	private JTextField nameTF;
	private JTextField birthTF;
	private JTextField eMailTF;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			JoinDialog dialog = new JoinDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 *?
	/**
	 * Create the dialog.
	 */
	public JoinDialog(LoginDialog loginDialog) {
		setResizable(false);
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(27, 22, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("PW");
			lblNewLabel_1.setBounds(27, 47, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("PW \uD655\uC778");
			lblNewLabel_2.setBounds(27, 72, 57, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setBounds(27, 97, 57, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			lblNewLabel_4.setBounds(27, 122, 57, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("e-mail");
			lblNewLabel_5.setBounds(27, 147, 57, 15);
			contentPanel.add(lblNewLabel_5);
		}
		{
			idTF = new JTextField();
			idTF.setBounds(125, 19, 116, 21);
			contentPanel.add(idTF);
			idTF.setColumns(10);
		}
		{
			pwTF = new JPasswordField();
			pwTF.setBounds(125, 44, 116, 21);
			contentPanel.add(pwTF);
			pwTF.setColumns(10);
		}
		{
			pwCheckTF = new JPasswordField();
			pwCheckTF.setBounds(125, 69, 116, 21);
			contentPanel.add(pwCheckTF);
			pwCheckTF.setColumns(10);
		}
		{
			nameTF = new JTextField();
			nameTF.setBounds(125, 94, 116, 21);
			contentPanel.add(nameTF);
			nameTF.setColumns(10);
		}
		{
			birthTF = new JTextField();
			birthTF.setBounds(125, 119, 116, 21);
			contentPanel.add(birthTF);
			birthTF.setColumns(10);
		}
		{
			eMailTF = new JTextField();
			eMailTF.setBounds(125, 144, 116, 21);
			contentPanel.add(eMailTF);
			eMailTF.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton okButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String pwStr=new String(pwTF.getText());
							String pwCheckStr=new String(pwCheckTF.getText());
							if(pwStr.equals(pwCheckStr)){
								loginDialog.getMemberService().joinMember(new MemberVO(0, idTF.getText(), nameTF.getText(), pwStr, false, eMailTF.getText(), 0, 2, 0, Integer.parseInt(birthTF.getText())));
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "비밀번호 와 비밀번호 확인이 다릅니다.");
							}
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
