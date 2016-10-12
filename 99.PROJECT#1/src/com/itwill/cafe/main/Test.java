package com.itwill.cafe.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import com.itwill.cafe.board.Board;
import com.itwill.cafe.board.BoardService;
import com.itwill.cafe.member.MemberVO;

public class Test extends JFrame {

	private JPanel contentPane;
	private BoardService boardService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Test() throws Exception {
		boardService = new BoardService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		BoardList2 boardList2;
		try {
			boardList2 = new BoardList2();
			boardList2.setBounds(5, 5, 176, 291);
			System.out.println("asdfasdf");
			contentPane.setLayout(null);
			contentPane.add(boardList2);
			
			JButton createBtn = new JButton("\uAC8C\uC2DC\uD310 \uC0DD\uC131");
			createBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						boardService.createBoard(new Board(3, "test", 3, 0));
						boardList2.reLoad();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			createBtn.setBounds(225, 107, 154, 45);
			contentPane.add(createBtn);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	public class BoardList2 extends JPanel {

		//private BoardDao boardDao;
		private Listm listModel;
		

		private JList<Board> list;
		
		/**
		 * Create the panel.
		 * @throws Exception 
		 */
		public BoardList2() throws Exception {
		
			setBackground(new Color(0, 204, 204));
			setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 12, 130, 247);
			add(scrollPane);
			
			
			//BoardDao로 부터 모든 게시판 리스트 가져오기?? 권한 따져서 가지고 오는 게 더 나을듯..
			//boardDao = new BoardDao();
				
		
		
			
			
			//listModel 객체 생성
			listModel = new Listm();
			
			/************************************************/
			list = new JList<Board>();
			list.setModel(listModel);

			list.addMouseListener(new MouseListener() {
				
				public void mouseReleased(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

					System.out.println(list.getSelectedValue().getBoardTitle()+list.getSelectedValue().getBoardAuth()+"게시판고유번호"+list.getSelectedValue().getNo());
	
		
				}
			});
			/************************************************/
			scrollPane.setViewportView(list);

		}

		
		public void reLoad() throws Exception{
			System.out.println("reload시작");
			listModel = new Listm();
			list.setModel(listModel);
			System.out.println("reload끝");
			
		}
		
		
		
		/*
		 * listModel 내부 클래스
		 */
		public class Listm implements ListModel<Board>{
			private ArrayList<Board> boardList;
			private ArrayList<String> boardTitle;
			//생성자
			public Listm() throws Exception {
				/*
				 * 현재 접속한 유저의 권한을 확인하여 
				 * 보여질 게시판만 boardList에 담는다.
				 */ 
				boardList = new ArrayList<Board>();
				
				MemberVO activeMember = FirstPageService.getActiveMember();
				if(activeMember == null){
					System.out.println("비회원입니다.");
				//	boardList = boardService.selectByAuth(3);
					System.out.println("볼 수 있는 게시판 갯수:"+boardList.size());
				}else{
					System.out.println("회원입니다. 현재권한 : "+FirstPageService.getActiveMember().getAuth());
					boardList = boardService.selectByAuth(FirstPageService.getActiveMember().getAuth());
				}
				
				
				boardTitle = new ArrayList<String>();
				for (Board board : boardList) {
					boardTitle.add(board.getBoardTitle());
				}
			}
			
			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return boardList.size();
			}

			@Override
			public Board getElementAt(int index) {
				// TODO Auto-generated method stub
				return boardList.get(index);
			}

			@Override
			public void addListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}
			
		}
	}
	
	
	
}
