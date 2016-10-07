package com.itwill.cafe.member.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.itwill.cafe.board.UI.BoardManagerDialog;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.main.MsgBoxThread;
import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.message.UI.ListMsg;
import javax.swing.border.LineBorder;

public class MemberInfoPanel extends JPanel {
	private JLabel lblName;
	
	private MemberService memberService;
	private JLabel lblID;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private FirstPageFrame fpFrame2;
	private JLabel lblMsgCount;
	private JPanel msgBoxPanel;
	private JPanel modifyPanel;

	
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberInfoPanel(FirstPageFrame fpFrame) throws Exception {
		fpFrame2 = fpFrame;
		memberService = new MemberService();
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
		lblNewLabel.setBounds(43, 12, 62, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(14, 29, 62, 18);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC774\uB984 :");
		label.setBounds(14, 51, 62, 18);
		add(label);
		
		lblID = new JLabel("");
		lblID.setBounds(70, 29, 62, 18);
		add(lblID);
		
		lblName = new JLabel("");
		lblName.setBounds(70, 51, 62, 18);
		add(lblName);
		
		
		/*****************로그아웃**********************/
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberService.logout();
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
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(25, 147, 89, 27);
		add(btnNewButton);
		/*****************로그아웃**********************/
		
		/**********쪽지함 라벨*************/
		/**********쪽지함 라벨*************/
		
		msgBoxPanel = new JPanel();
		msgBoxPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ListMsg listMsgD = new ListMsg();
					listMsgD.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		msgBoxPanel.setBorder(new LineBorder(new Color(128, 128, 128), 3));
		msgBoxPanel.setBackground(Color.PINK);
		msgBoxPanel.setBounds(14, 74, 114, 40);
		add(msgBoxPanel);
		msgBoxPanel.setLayout(null);
		JLabel label_2 = new JLabel("\uCABD\uC9C0\uD568");
		label_2.setBounds(14, 12, 42, 18);
		msgBoxPanel.add(label_2);
		
		lblMsgCount = new JLabel("");
		lblMsgCount.setBounds(60, 12, 40, 18);
		msgBoxPanel.add(lblMsgCount);
		
		
		
		/******************관리자 버튼**********************/
		
			btnNewButton_1 = new JButton("\uAC8C\uC2DC\uD310");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						BoardManagerDialog bmDialog = new BoardManagerDialog(fpFrame);
						bmDialog.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton_1.setBounds(70, 118, 75, 27);
			btnNewButton_1.setVisible(false);
			add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("\uD68C\uC6D0");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberManagerDialog mmd;
					try {
						mmd = new MemberManagerDialog();
						mmd.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_2.setBounds(5, 118, 62, 27);
			btnNewButton_2.setVisible(false);
			add(btnNewButton_2);
			
			modifyPanel = new JPanel();
			modifyPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("수정버튼");
					ModifyInfoDialog mid;
					try {
						mid = new ModifyInfoDialog(fpFrame);
						mid.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			modifyPanel.setBackground(new Color(245, 222, 179));
			modifyPanel.setBounds(109, 1, 35, 18);
			add(modifyPanel);
			modifyPanel.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("\uC218\uC815");
			lblNewLabel_2.setBounds(5, 2, 30, 15);
			modifyPanel.add(lblNewLabel_2);
			lblNewLabel_2.setBackground(Color.DARK_GRAY);
			
			
			
		
		/******************관리자 버튼**********************/

	}
	public JPanel getMsgBoxPanel() {
		return msgBoxPanel;
	}
	public void setMsgBoxPanel(JPanel msgBoxPanel) {
		this.msgBoxPanel = msgBoxPanel;
	}
	public JLabel getLblMsgCount() {
		return lblMsgCount;
	}
	public void setLblMsgCount(JLabel lblMsgCount) {
		this.lblMsgCount = lblMsgCount;
	}
	
	public JButton getMemberAuthButton(){
		return btnNewButton_1;
	}
	
	public JButton getBoardAuthButton(){
		return btnNewButton_2;
	}
	
	public void createModifyButton(){
		System.out.println("수정버튼 생성");
		modifyPanel = new JPanel();
		modifyPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("수정버튼");
				ModifyInfoDialog mid;
				try {
					mid = new ModifyInfoDialog(fpFrame2);
					mid.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		modifyPanel.setBackground(new Color(245, 222, 179));
		modifyPanel.setBounds(106, 1, 35, 18);
		add(modifyPanel);
		modifyPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uC218\uC815");
		lblNewLabel_2.setBounds(5, 2, 24, 15);
		modifyPanel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
	}
	
	public void createAuthButton(){
		/*btnNewButton_1 = new JButton("\uAC8C\uC2DC\uD310");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BoardManagerDialog bmDialog = new BoardManagerDialog(fpFrame2);
					bmDialog.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(70, 100, 75, 27);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\uD68C\uC6D0");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberManagerDialog mmd;
				try {
					mmd = new MemberManagerDialog();
					mmd.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(5, 100, 62, 27);
		add(btnNewButton_2);*/
		btnNewButton_1.setVisible(true);
		btnNewButton_2.setVisible(true);
	}
	
	public JLabel getLblID() {
		return lblID;
	}

	public void setLblID(JLabel lblID) {
		this.lblID = lblID;
	}

	/*
	 * 	회원 정보 보여주는 메소드
	 */
	public void showMemberInfo(String id) throws Exception{
		MemberVO member = memberService.returnMember(id);
		//this.lblAuth.setText(Integer.toString(member.getAuth()));
		this.lblName.setText(member.getName());
	}
}
