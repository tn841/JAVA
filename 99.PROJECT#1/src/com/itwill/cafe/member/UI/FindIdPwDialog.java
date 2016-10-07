package com.itwill.cafe.member.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.member.MemberVO;

public class FindIdPwDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTF;
	private JTextField birthTF;
	private JTextField eMailTF;
	private MemberVO memberVO=null;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			FindIdPwDialog dialog = new FindIdPwDialog();
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
	 */
	public FindIdPwDialog(LoginDialog loginDialog) throws Exception {
		setResizable(false);
		setTitle("ID/PW\uCC3E\uAE30");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(46, 39, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1.setBounds(46, 64, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(46, 89, 57, 15);
		contentPanel.add(lblEmail);
		
		nameTF = new JTextField();
		nameTF.setBounds(115, 36, 116, 21);
		contentPanel.add(nameTF);
		nameTF.setColumns(10);
		
		birthTF = new JTextField();
		birthTF.setBounds(115, 61, 116, 21);
		contentPanel.add(birthTF);
		birthTF.setColumns(10);
		
		eMailTF = new JTextField();
		eMailTF.setBounds(115, 86, 116, 21);
		contentPanel.add(eMailTF);
		eMailTF.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton okButton = new JButton("ID/PW\uBCF4\uAE30");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							memberVO=loginDialog.getMemberService().findidpass(new MemberVO(0, "", nameTF.getText(), "", false, eMailTF.getText(), 0, 0, 0, Integer.parseInt(birthTF.getText())));
							if(memberVO!=null){
								ShowIdPwDialog showIdPwDialog=new ShowIdPwDialog(FindIdPwDialog.this);
								showIdPwDialog.setModal(true);
								showIdPwDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								//findIdPwDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
								showIdPwDialog.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "입력하신 정보가 일치하지 않습니다.");
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
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
	
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public JTextField getNameTF() {
		return nameTF;
	}
	public void setNameTF(JTextField nameTF) {
		this.nameTF = nameTF;
	}
	public JTextField getBirthTF() {
		return birthTF;
	}
	public void setBirthTF(JTextField birthTF) {
		this.birthTF = birthTF;
	}
	public JTextField geteMailTF() {
		return eMailTF;
	}
	public void seteMailTF(JTextField eMailTF) {
		this.eMailTF = eMailTF;
	}
	
	
}
