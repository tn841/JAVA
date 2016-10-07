package com.itwill.cafe.message.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.main.FirstPageService;
import com.itwill.cafe.member.MemberDao;
import com.itwill.cafe.member.MemberVO;
import com.itwill.cafe.message.MessageService;
import com.itwill.cafe.message.MessageVO;

public class SendMsg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField titleTextField;
	
	//private MessageDao msgDao;
	private MessageVO msg;
	private MessageService msgService;
	private JComboBox receiverComboBox;
	private JTextArea contentTextArea;
	private MemberDao memberDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SendMsg dialog = new SendMsg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public SendMsg() throws Exception {
		setResizable(false);
		setTitle("\uCABD\uC9C0\uD568");
		msgService = new MessageService();
		memberDao = new MemberDao();
		
		setBounds(100, 100, 360, 531);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel receiverLabel = new JLabel("\uBC1B\uB294\uC0AC\uB78C");
			receiverLabel.setBounds(12, 36, 57, 15);
			contentPanel.add(receiverLabel);
		}
		
		
		/*
		 * 콤보박스 모델
		 */
		ArrayList<MemberVO> memberList = memberDao.selectAll();
		String[] idList = new String[memberList.size()];
		int count=0;
		for (MemberVO member : memberList) {
			idList[count] = member.getId();
			count++;
		}
		
		receiverComboBox = new JComboBox();
		receiverComboBox.setModel(new DefaultComboBoxModel(idList));
		receiverComboBox.setBounds(97, 33, 160, 21);
		contentPanel.add(receiverComboBox);
		
		JLabel titleLabel = new JLabel("\uC81C\uBAA9");
		titleLabel.setBounds(12, 67, 57, 15);
		contentPanel.add(titleLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(97, 64, 219, 21);
		contentPanel.add(titleTextField);
		titleTextField.setColumns(10);
		
		JLabel contentLabel = new JLabel("\uB0B4\uC6A9");
		contentLabel.setBounds(12, 103, 57, 15);
		contentPanel.add(contentLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 128, 320, 322);
		contentPanel.add(scrollPane);
		
		contentTextArea = new JTextArea();
		scrollPane.setColumnHeaderView(contentTextArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
			{
				JButton sendButton = new JButton("\uC804\uC1A1");
				sendButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							//msgDao.insert(msg);
							String receiverID = (String) receiverComboBox.getItemAt(receiverComboBox.getSelectedIndex());
							String titleStr = titleTextField.getText();
							String contentStr = contentTextArea.getText();
							MessageVO newMsg = new MessageVO(1, titleStr, contentStr, FirstPageService.getActiveMember().getId(), receiverID);
							System.out.println("보내는 메시지 데이터 확인 :"+newMsg.toString());
							msgService.createMessage(newMsg);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//리스트 갱신 메소드 호출하기
						
						dispose();
					}
				});
				sendButton.setActionCommand("Cancel");
				buttonPane.add(sendButton);
			}
		}
	}
}
