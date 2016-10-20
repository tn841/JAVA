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
					/**************로그인 체크******************/
					public void actionPerformed(ActionEvent e) {
						try {
							
							if(memberService.login(idTF.getText(), new String(pwField.getPassword()))){
								System.out.println("로그인 성공");
								firstFrame.getMemberInfoPanel().getLblID().setText(idTF.getText());
								firstFrame.getMemberInfoPanel().showMemberInfo(idTF.getText());
								firstFrame.getCl().show(firstFrame.getCardParent(), "memberInfo");	//카드 레이아웃 카드 전환
								//로그인 성공한 
								//권한체크하여 게시판 리스트 및 게시글 리스트 새로고침 해야함.
								FirstPageService.setActiveMember(memberService.returnMember(idTF.getText()));	//현재 로그인한 회원정보 저장
								firstFrame.getBoardList().reLoad();	//메인 게시판 list 새로고침
								firstFrame.getFirstPagePostPanel().reload();//메인 게시글들 새로고침
								System.out.println("로그인한 회원 정보 : "+FirstPageService.getActiveMember());
								
								firstFrame.getMemberInfoPanel().createModifyButton();
								
								
								if(FirstPageService.getActiveMember().getAuth() == 0){
									firstFrame.getMemberInfoPanel().createAuthButton();
								}
							
								/*
								 * 로그인 성공하면 새로운 쓰레드를 생성하여 무한히 반복하며 나에게온 msg확인
								 */
							
								
								dispose();
							}else{
								System.out.println("로그인 실패");
							}
								
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						/**************로그인 체크******************/
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				/************회원가입**************/
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
