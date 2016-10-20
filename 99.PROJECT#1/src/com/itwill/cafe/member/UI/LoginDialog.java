package com.itwill.cafe.member.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.main.MsgBoxThread;
import com.itwill.cafe.member.MemberService;

public class LoginDialog extends JDialog {
	private MemberService memberService;
	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField pwField;
	
	public static MsgBoxThread mbThread;


	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public LoginDialog(FirstPageFrame firstFrame) throws Exception {
		setResizable(false);
		memberService = new MemberService();
		
		
		
		setTitle("\uB85C\uADF8\uC778");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setBounds(52, 49, 62, 18);
		contentPanel.add(label);
		
		idTF = new JTextField();
		idTF.setBounds(128, 46, 116, 24);
		contentPanel.add(idTF);
		idTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setBounds(52, 95, 62, 18);
		contentPanel.add(label_1);
		
		pwField = new JPasswordField();
		pwField.setBounds(128, 92, 116, 24);
		contentPanel.add(pwField);
		
		JButton btnNewButton_1 = new JButton("ID/PW\uCC3E\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindIdPwDialog findIdPwDialog;
				try {
					findIdPwDialog = new FindIdPwDialog(LoginDialog.this);
					findIdPwDialog.setModal(true);
					findIdPwDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					//findIdPwDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					findIdPwDialog.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(94, 139, 97, 23);
		contentPanel.add(btnNewButton_1);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
			{
				JButton okButton = new JButton("\uB85C\uADF8\uC778");
				okButton.addActionListener(new ActionListener() {
					/**************�α��� üũ******************/
					public void actionPerformed(ActionEvent e) {
						try {
							
							if(memberService.login(idTF.getText(), new String(pwField.getPassword()))){
								System.out.println("�α��� ����");
								firstFrame.getMemberInfoPanel().getLblID().setText(idTF.getText());
								firstFrame.getMemberInfoPanel().showMemberInfo(idTF.getText());
								firstFrame.getCl().show(firstFrame.getCardParent(), "memberInfo");	//ī�� ���̾ƿ� ī�� ��ȯ
								//�α��� ������ 
								//����üũ�Ͽ� �Խ��� ����Ʈ �� �Խñ� ����Ʈ ���ΰ�ħ �ؾ���.
								FirstPageService.setActiveMember(memberService.returnMember(idTF.getText()));	//���� �α����� ȸ������ ����
								firstFrame.getBoardList().reLoad();	//���� �Խ��� list ���ΰ�ħ
								firstFrame.getFirstPagePostPanel().reload();//���� �Խñ۵� ���ΰ�ħ
								System.out.println("�α����� ȸ�� ���� : "+FirstPageService.getActiveMember());
								
								firstFrame.getMemberInfoPanel().createModifyButton();
								
								
								if(FirstPageService.getActiveMember().getAuth() == 0){
									firstFrame.getMemberInfoPanel().createAuthButton();
								}
							
								/*
								 * �α��� �����ϸ� ���ο� �����带 �����Ͽ� ������ �ݺ��ϸ� �����Կ� msgȮ��
								 */
							
								
								dispose();
							}else{
								System.out.println("�α��� ����");
							}
								
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						/**************�α��� üũ******************/
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				/************ȸ������**************/
				JButton cancelButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JoinDialog joinDialog=new JoinDialog(LoginDialog.this);
						joinDialog.setModal(true);
						joinDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						//findIdPwDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						joinDialog.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton btnNewButton = new JButton("\uCDE8\uC18C");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnNewButton);
			}
		}
	}
}
