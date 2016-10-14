package com.itwill.member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MemberFrame extends JFrame {
	MemberService memberService;
	/*
	private OrderService orderService;
	private ProductService productService;
	*/
	private JPanel contentPane;
	private JTextField idTF;
	private JTextField nameTF;
	private JPasswordField passwordField;
	private JCheckBox chckbxMarried;
	private JComboBox ageCB;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame frame = new MemberFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void memberList() throws Exception{
		ArrayList<Member> memberList=
				memberService.getMemberList();
		String memberStr="";
		for (Member member : memberList) {
			memberStr=memberStr+member.toString()+"\n";
		}
		textArea.setText(memberStr);
	}
	/**
	 * Create the frame.
	 */
	public MemberFrame() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		/************회원가입*************/
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) throws RuntimeException{
				System.out.println("1.UI event 가입버튼!!!");
				
				String id=idTF.getText();
				char[] passCharArray=
						passwordField.getPassword();
				String password=new String(passCharArray);
				
				String name=nameTF.getText();
				boolean isMarried=false;
				if(chckbxMarried.isSelected()){
					isMarried=true;
				}
				String ageStr=(String)ageCB.getSelectedItem();
				
				System.out.println(id);
				System.out.println(password);
				System.out.println(name);
				System.out.println(isMarried);
				System.out.println(ageStr);
				/*
				 * 유효성체크(null체크,....)
				 */
				
				boolean success=false;
				try {
					success = memberService.joinMember(
							new Member(0,id,password,name,null,Integer.parseInt(ageStr),isMarried));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "가입실패 다시해바바요!!!");
					e1.printStackTrace();
				}
				if(success){
					/*
					 * UI전환
					 */
					try {
						
						memberList();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "가입실패 ID중복 다시해바바요!!!");
					
				}
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uB85C\uADF8\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * LoginDialog
				 */
				LoginDialog loginD=new LoginDialog(MemberFrame.this);
				loginD.setModal(true);
				//loginD.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				loginD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				loginD.setVisible(true);
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\uD68C\uC6D0\uC0AD\uC81C");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_3);
		/************회원리스트*************/
		JButton btnNewButton_2 = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
					
					memberList();
					
				} catch (Exception e1) {
					throw new RuntimeException(e1.getMessage());
				}
				
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel passwordTF = new JPanel();
		contentPane.add(passwordTF, BorderLayout.CENTER);
		passwordTF.setLayout(null);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(12, 10, 57, 15);
		passwordTF.add(lblId);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(12, 77, 57, 15);
		passwordTF.add(lblName);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setBounds(12, 38, 57, 15);
		passwordTF.add(lblNewLabel);
		
		JLabel lblIsmarried = new JLabel("isMarried");
		lblIsmarried.setBounds(12, 102, 57, 15);
		passwordTF.add(lblIsmarried);
		
		idTF = new JTextField();
		idTF.setBounds(100, 7, 116, 21);
		passwordTF.add(idTF);
		idTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setBounds(100, 74, 116, 21);
		passwordTF.add(nameTF);
		nameTF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 38, 116, 21);
		passwordTF.add(passwordField);
		
		chckbxMarried = new JCheckBox("married");
		chckbxMarried.setBounds(100, 98, 115, 23);
		passwordTF.add(chckbxMarried);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(12, 139, 57, 15);
		passwordTF.add(lblAge);
		
		ageCB = new JComboBox();
		ageCB.setBounds(100, 136, 78, 21);
		passwordTF.add(ageCB);
		ageCB.addItem("10");
		ageCB.addItem("20");
		ageCB.addItem("30");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(228, 6, 232, 148);
		passwordTF.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		try {
			memberService=new MemberService();
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
			
		}
		memberList();
	}
	
	
}
