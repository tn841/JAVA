package com.itwill.cafe.member.UI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.board.Board;
import com.itwill.cafe.member.MemberService;
import com.itwill.cafe.member.MemberVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberManagerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField authTF;
	private MemberService memberService;
	private ArrayList<MemberVO> memberList;
	private DefaultTableModel tableModel;
	private Vector<String> columnNames;
	private int no;
	private String auth;
	private String id;

	/**
	 * Launch the application.
	 */
	public void selectMemberList() throws Exception {
		memberService = new MemberService();
		memberList = new ArrayList<MemberVO>();

		memberList = memberService.getMemberList();

		Vector<Vector<String>> data = new Vector<Vector<String>>();

		for (MemberVO memberVO : memberList) {
			Vector rowVector = new Vector<String>();
			rowVector.add(memberVO.getNo());
			rowVector.add(memberVO.getName());
			rowVector.add(memberVO.getId());
			
			rowVector.add(memberVO.getAuth());
			data.add(rowVector);
		}
		columnNames = new Vector<String>();
		columnNames.add("번호");
		columnNames.add("이름");
		columnNames.add("아이디");
		columnNames.add("권한");

		tableModel = new DefaultTableModel(data, columnNames);
		table.setModel(tableModel);
	}

	public static void main(String[] args) {
		try {
			MemberManagerDialog dialog = new MemberManagerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public MemberManagerDialog() throws Exception {
		setResizable(false);
		setTitle("\uD68C\uC6D0\uAD00\uB9AC");
		setBounds(100, 100, 604, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 365, 390);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id=table.getValueAt(table.getSelectedRow(), 2)+"";
				auth = table.getValueAt(table.getSelectedRow(), 3)+"";
				authTF.setText(auth);
			}
		});
		selectMemberList();
		scrollPane.setViewportView(table);

		authTF = new JTextField();
		authTF.setBounds(466, 14, 116, 21);
		contentPanel.add(authTF);
		authTF.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC720\uC800\uC758 \uAD8C\uD55C");
		lblNewLabel.setBounds(389, 17, 79, 15);
		contentPanel.add(lblNewLabel);

		JButton 수정 = new JButton("\uC218\uC815");
		수정.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberService.setAuth(id, Integer.parseInt(authTF.getText()));
					selectMemberList();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "텍스트필드를 채워주세용");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		수정.setBounds(485, 45, 97, 23);
		contentPanel.add(수정);

		JButton btnNewButton_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberService.removeById(id);
					selectMemberList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(485, 78, 97, 23);
		contentPanel.add(btnNewButton_1);
	}
}
