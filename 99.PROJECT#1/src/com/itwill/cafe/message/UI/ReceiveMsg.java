package com.itwill.cafe.message.UI;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.message.MessageService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiveMsg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField titleTextField;
	private JTextField senderTextField;
	private MessageService msgService;
	private MemberService memberService;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			ReceiveMsg dialog = new ReceiveMsg();
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
	public ReceiveMsg(ListMsg listMsg) throws Exception {
		setResizable(false);
		setTitle("\uCABD\uC9C0");
		msgService = new MessageService();
		setBounds(100, 100, 361, 541);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel senderLabel = new JLabel("\uBCF4\uB0B8\uC0AC\uB78C");
			senderLabel.setBounds(12, 36, 57, 15);
			contentPanel.add(senderLabel);
		}
		
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
		
		JTextArea contentTextArea = new JTextArea();
		scrollPane.setColumnHeaderView(contentTextArea);
		
		senderTextField = new JTextField();
		senderTextField.setBounds(97, 33, 116, 21);
		contentPanel.add(senderTextField);
		senderTextField.setColumns(10);
		
		titleTextField.setText(listMsg.getMsgVO().getMsgTitle());
		senderTextField.setText(listMsg.getMsgVO().getMsgSender());
		contentTextArea.setText(listMsg.getMsgVO().getMsgContent());
		
		JButton deleteBtn = new JButton("\uC0AD\uC81C");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int msgNo = (int)listMsg.getTable().getValueAt(listMsg.getTable().getSelectedRow(), 0);
				try {
					msgService.deleteMessage(msgNo);
					listMsg.reLoad();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(msgNo);
			}
		});
		deleteBtn.setBounds(227, 462, 105, 27);
		contentPanel.add(deleteBtn);
		
	}
}
