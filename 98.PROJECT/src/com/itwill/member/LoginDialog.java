package com.itwill.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField passTF;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { LoginDialog dialog = new
	 * LoginDialog(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog.
	 */
	public LoginDialog(Frame owner) {
		super(owner);
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("id");
			lblId.setBounds(42, 33, 57, 15);
			contentPanel.add(lblId);
		}
		{
			JLabel lblPass = new JLabel("pass");
			lblPass.setBounds(24, 73, 57, 15);
			contentPanel.add(lblPass);
		}
		{
			idTF = new JTextField();
			idTF.setBounds(80, 30, 116, 21);
			contentPanel.add(idTF);
			idTF.setColumns(10);
		}
		{
			passTF = new JPasswordField();
			passTF.setBounds(80, 70, 116, 21);
			contentPanel.add(passTF);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = idTF.getText();
						String pass = new String(passTF.getPassword());
						System.out.println("1.UI event LOGIN��ư");
						MemberFrame mf = (MemberFrame) getOwner();
						mf.getContentPane().setBackground(Color.blue);
						boolean isSuccess = false;
						try {
							isSuccess = mf.memberService.login(id, pass);

							if (isSuccess) {
								mf.setTitle(id+" �� �α��μ���");
								dispose();
							} else {
								int result = JOptionPane.showConfirmDialog(null, "�α��ν��� ����ҷ���");
								switch (result) {
								case JOptionPane.OK_OPTION:
									break;

								case JOptionPane.CANCEL_OPTION:
									dispose();
									break;
								}
							}
						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null,
									"�ַι߻� ���ø����̼��� �����մϴ�.");
							System.exit(0);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						// System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
