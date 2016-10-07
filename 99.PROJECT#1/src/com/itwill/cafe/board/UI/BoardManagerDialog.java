package com.itwill.cafe.board.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.cafe.board.Board;
import com.itwill.cafe.board.BoardService;
import com.itwill.cafe.main.FirstPageFrame;
import com.itwill.cafe.post.PostService;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardManagerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ArrayList<Board> boardList;
	BoardService boardService;
	private DefaultTableModel tableModel;
	private Vector<String> columnNames;
	private JTextField titleTF;
	private JTextField authTF;
	private JTextField typeTF;
	private String name;
	private String auth;
	private String type;
	PostService postServ;
	private int no;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			BoardManagerDialog dialog = new BoardManagerDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public void selectBoardList() throws Exception{
		boardService = new BoardService();
		boardList = new ArrayList<Board>();
		boardList.clear();
		
		boardList = boardService.allBoard();
		System.out.println(boardList);
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		for (Board board : boardList) {
			Vector rowVector = new Vector<String>();
			rowVector.add(board.getNo());
			rowVector.add(board.getBoardTitle());
			rowVector.add(board.getBoardAuth());
			rowVector.add(board.getBoardType());
			data.add(rowVector);
		}
		columnNames = new Vector<String>();
		columnNames.add("게시판 번호");
		columnNames.add("게시판 이름");
		columnNames.add("게시판 권한");
		columnNames.add("게시판 타입");
		
		tableModel = new DefaultTableModel(data, columnNames);
		table.setModel(tableModel);
	}
	public BoardManagerDialog(FirstPageFrame fpFrame) throws Exception {
		setTitle("\uAC8C\uC2DC\uD310 \uAD00\uB9AC");
		postServ = new PostService();
		setBounds(100, 100, 619, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 366, 192);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						name=table.getValueAt(table.getSelectedRow(), 1)+"";
						titleTF.setText(name);
						auth=table.getValueAt(table.getSelectedRow(), 2)+"";
						authTF.setText(auth);
						type=(Integer)table.getValueAt(table.getSelectedRow(), 3)+"";
						typeTF.setText(type);
						no=(Integer)table.getValueAt(table.getSelectedRow(), 0);
						
						try {
							selectBoardList();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				this.selectBoardList();
			}
			scrollPane.setViewportView(table);
		}
		
		titleTF = new JTextField();
		titleTF.setBounds(468, 8, 116, 21);
		contentPanel.add(titleTF);
		titleTF.setColumns(10);
		
		authTF = new JTextField();
		authTF.setBounds(468, 39, 116, 21);
		contentPanel.add(authTF);
		authTF.setColumns(10);
		
		typeTF = new JTextField();
		typeTF.setBounds(468, 70, 116, 21);
		contentPanel.add(typeTF);
		typeTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uAC8C\uC2DC\uD310 \uC81C\uBAA9");
		lblNewLabel.setBounds(390, 11, 85, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC8C\uC2DC\uD310 \uAD8C\uD55C");
		lblNewLabel_1.setBounds(390, 40, 73, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC8C\uC2DC\uD310 \uD0C0\uC785");
		lblNewLabel_2.setBounds(390, 70, 85, 15);
		contentPanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boardService.modifyBoard(new Board(BoardManagerDialog.this.no, titleTF.getText(), Integer.parseInt(authTF.getText()), Integer.parseInt(typeTF.getText())));
					selectBoardList();
					titleTF.setText("");
					typeTF.setText("");
					authTF.setText("");
					fpFrame.getBoardList().reLoad();
					fpFrame.getFirstPagePostPanel().reload();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "빈칸을 채워줘...");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(487, 100, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC0DD\uC131");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boardService.createBoard(new Board(0, titleTF.getText(), Integer.parseInt(authTF.getText()), Integer.parseInt(typeTF.getText())));
					selectBoardList();
					titleTF.setText("");
					typeTF.setText("");
					authTF.setText("");
					fpFrame.getBoardList().reLoad();
					fpFrame.getFirstPagePostPanel().reload();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "빈칸을 채워줘...");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		btnNewButton_1.setBounds(487, 133, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton button = new JButton("\uC0AD\uC81C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boardService.deleteBoard(BoardManagerDialog.this.no);
					postServ.deleteByNo(BoardManagerDialog.this.no);//삭제 된 게시판에 존재하는 모든 게시글 삭제
					selectBoardList();
					titleTF.setText("");
					typeTF.setText("");
					authTF.setText("");
					fpFrame.getBoardList().reLoad();
					fpFrame.getFirstPagePostPanel().reload();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		button.setBounds(487, 166, 97, 23);
		contentPanel.add(button);
	}
}
