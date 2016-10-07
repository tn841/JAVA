package com.itwill.cafe.member.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.member.MemberVO;

public class ModifyInfoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField birth;
	private JTextField eMail;
	private JTextField pw;
	private JTextField pwCheck;
	private MemberService memberServ;
	



	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public ModifyInfoDialog(FirstPageFrame fpFrame) throws Exception {
		setResizable(false);
		setTitle("\uC815\uBCF4\uC218\uC815");
		memberServ=new MemberService();
		MemberVO memberVO = FirstPageService.activeMember;
		setBounds(100, 100, 358, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\uC774\uB984");
			label.setBounds(56, 63, 57, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label.setBounds(56, 88, 57, 15);
			contentPanel.add(label);
		}
		{
			JLabel lblEmail = new JLabel("e-mail");
			lblEmail.setBounds(56, 113, 57, 15);
			contentPanel.add(lblEmail);
		}
		{
			JLabel lblPw = new JLabel("PW");
			lblPw.setBounds(56, 138, 57, 15);
			contentPanel.add(lblPw);
		}
		{
			JLabel lblPw_1 = new JLabel("PW\uD655\uC778");
			lblPw_1.setBounds(56, 163, 57, 15);
			contentPanel.add(lblPw_1);
		}
		{
			name = new JTextField();
			name.setBounds(168, 60, 116, 21);
			contentPanel.add(name);
			name.setColumns(10);
			name.setText(memberVO.getName());
		}
		{
			birth = new JTextField();
			birth.setBounds(168, 85, 116, 21);
			contentPanel.add(birth);
			birth.setColumns(10);
			birth.setText(memberVO.getBirth()+"");
		}
		{
			eMail = new JTextField();
			eMail.setBounds(168, 110, 116, 21);
			contentPanel.add(eMail);
			eMail.setColumns(10);
			eMail.setText(memberVO.getEmail());
		}
		{
			pw = new JTextField();
			pw.setBounds(168, 135, 116, 21);
			contentPanel.add(pw);
			pw.setColumns(10);
		}
		{
			pwCheck = new JTextField();
			pwCheck.setBounds(168, 160, 116, 21);
			contentPanel.add(pwCheck);
			pwCheck.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
			{
				JButton okButton = new JButton("\uC815\uBCF4\uC218\uC815\uD558\uAE30");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int birthDay=Integer.parseInt(birth.getText()+"");
						String pwStr=pw.getText()+"";
						String pwCheckStr=pwCheck.getText()+"";
						try {
							if(pwStr.equals(pwCheckStr)){
								memberServ.modifyMember(new MemberVO(FirstPageService.activeMember.getNo(), "", name.getText()+"", pwStr, true, eMail.getText()+"", 0, 0, 0, birthDay));
								memberServ.logout();
								
								/***********************/
								memberServ.logout();
								FirstPageService.setActiveMember(null);
								fpFrame.getBoardList().reLoad();
								fpFrame.getFirstPagePostPanel().reload();
								fpFrame.getCl().show(fpFrame.getCardParent(), "default");
								fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "기본패널");
								
								/*
								 * 관리자 버튼 제거
								 */
								try{
									if( FirstPageService.getActiveMember().getAuth() == 0){
										
									}
								}catch(Exception e2){
									fpFrame.getMemberInfoPanel().getMemberAuthButton().setVisible(false);
									fpFrame.getMemberInfoPanel().getBoardAuthButton().setVisible(false);
									System.out.println("활성 사용자가 없음.. 즉 비회원");
								}
								
							
								/*
								 * 메시지 확인 쓰레드 종료
								 */
								LoginDialog.mbThread.stop();								
								/***********************/
								
								dispose();
								
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
			{
				JButton btnNewButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {

							/***********************/
							memberServ.deleteMember();
							memberServ.logout();
						
							fpFrame.getBoardList().reLoad();
							fpFrame.getFirstPagePostPanel().reload();
							fpFrame.getCl().show(fpFrame.getCardParent(), "default");
							fpFrame.getPostCL().show(fpFrame.getPostParentCard(), "기본패널");
							
							/*
							 * 관리자 버튼 제거
							 */
							try{
								if( FirstPageService.getActiveMember().getAuth() == 0){
									
								}
							}catch(Exception e2){
								fpFrame.getMemberInfoPanel().getMemberAuthButton().setVisible(false);
								fpFrame.getMemberInfoPanel().getBoardAuthButton().setVisible(false);
								System.out.println("활성 사용자가 없음.. 즉 비회원");
							}
							
						
							/*
							 * 메시지 확인 쓰레드 종료
							 */
							LoginDialog.mbThread.stop();								
							/***********************/
							
							
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				buttonPane.add(btnNewButton);
			}
		}
	}

}
